package com.group2.soft.induk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.group2.soft.induk.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Hong on 2016-08-22.
 */
public class MainActivity extends AppCompatActivity {
    TextView text, text2, text3, ment;
    private ImageButton btn_kor, btn_eng, btn_chn, btn_jpn;

    Typeface typeRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_language);

        startActivity(new Intent(this, LoadingActivity.class));

        btn_kor = (ImageButton) findViewById(R.id.korea);
        btn_eng = (ImageButton) findViewById(R.id.english);
        btn_chn = (ImageButton) findViewById(R.id.china);
        btn_jpn = (ImageButton) findViewById(R.id.japan);

        btn_kor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//버튼을 누르면 실행됨
                Intent intent = new Intent(MainActivity.this, SetKorActivity.class);//인텐트로 보내지는곳의 클래스와,보낼곳의 위치 DetailOneActivity->ShowMapOne
                startActivity(intent);
            }
        });

        btn_eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//버튼을 누르면 실행됨
                Intent intent = new Intent(MainActivity.this, SetEngActivity.class);//인텐트로 보내지는곳의 클래스와,보낼곳의 위치 DetailOneActivity->ShowMapOne
                startActivity(intent);
            }
        });

        btn_jpn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//버튼을 누르면 실행됨
                Intent intent = new Intent(MainActivity.this, SetJpnActivity.class);//인텐트로 보내지는곳의 클래스와,보낼곳의 위치 DetailOneActivity->ShowMapOne
                startActivity(intent);
            }
        });

        btn_chn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//버튼을 누르면 실행됨
                Intent intent = new Intent(MainActivity.this, SetChnActivity.class);//인텐트로 보내지는곳의 클래스와,보낼곳의 위치 DetailOneActivity->ShowMapOne
                startActivity(intent);
            }
        });

        typeRe = Typeface.createFromAsset(getAssets(), "AdobeGothicStd-Bold.otf");


        text = (TextView) findViewById(R.id.text);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);

        text.setTypeface(typeRe);
        text2.setTypeface(typeRe);
        text3.setTypeface(typeRe);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Thread myThread = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        handler.sendMessage(handler.obtainMessage());
                        Thread.sleep(1000);
                    } catch (Throwable t) {

                    }
                }
            }
        });
        myThread.start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            updateThread();
        }
    };

    private void updateThread() {
        String now_time = now_time();

        text.setText(now_time);
    }

    public String now_time() {
        long now = System.currentTimeMillis();
        // 현재 시간을 저장 한다.
        Date date = new Date(now);
        // 시간 포맷으로 만든다.
        SimpleDateFormat sdfHour = new SimpleDateFormat("HH");
        String temp = sdfHour.format(date);
        String ampm = "";
        if (Integer.parseInt(temp) >= 12) {
            temp = String.valueOf(Integer.parseInt(temp) - 12);
            ampm = " PM";
        } else {
            ampm = " AM";
        }
        SimpleDateFormat sdfMin = new SimpleDateFormat("mm");
        String temp2 = sdfMin.format(date);
        temp = temp + ":" + temp2 + ampm;


        SimpleDateFormat sdfMon = new SimpleDateFormat("MM/dd");
        SimpleDateFormat sdfDate = new SimpleDateFormat("E");
        String str = sdfMon.format(date);
        String te = sdfDate.format(date);

        switch (te) {
            case "월":
                te = " Mon ";
                break;
            case "화":
                te = " Tue ";
                break;
            case "수":
                te = " Wed ";
                break;
            case "목":
                te = " Thu ";
                break;
            case "금":
                te = " Fri ";
                break;
            case "토":
                te = " Sat ";
                break;
            case "일":
                te = " Sun ";
                break;
        }
        str = str + "  " + te + "  " + temp;
        return str;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK: //back키를 눌렀을 경우
                new AlertDialog.Builder(this) //AlertDialog생성
                        .setTitle("종료") //Title은 종료
                        .setMessage("종료 하시겠어요?") //Dialog메시지
                        .setPositiveButton("예", new DialogInterface.OnClickListener() { //'예' 버튼을 누르면
                            public void onClick(DialogInterface dialog, int whichButton) {
                                finish(); //앱 종료
                            }
                        })
                        .setNegativeButton("아니오", null).show(); //아니오를 누르면 Dialog창 사라지도록
                return false;
            default:
                return false;
        }
    }
}
