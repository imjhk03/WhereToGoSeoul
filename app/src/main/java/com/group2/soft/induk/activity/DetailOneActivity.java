package com.group2.soft.induk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.group2.soft.induk.R;
import com.group2.soft.induk.ShowMapOne;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Lee Kyu Hwa on 2016-08-19.
 */
public class DetailOneActivity extends Activity {
    private Intent intent = new Intent();

    private Context context = this;

    private TextView textView;
    String title, homepage, overview, tel, telname;
    TextView one_detail_title, one_detail_overview, one_detail_tel, one_detail_zipcode, one_detail_addr1;

    ImageView one_detail_firstimage;
    Button button;
    String contentid, mapx, mapy, addr1, firstimage, zipcode, addr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_detail);

        one_detail_title = (TextView) findViewById(R.id.one_detail_title);
        one_detail_firstimage = (ImageView) findViewById(R.id.one_detail_firstimage);
        one_detail_tel = (TextView) findViewById(R.id.one_detail_tel);
        one_detail_zipcode = (TextView) findViewById(R.id.one_detail_zipcode);
        one_detail_addr1 = (TextView) findViewById(R.id.one_detail_addr1);
        one_detail_overview = (TextView) findViewById(R.id.one_detail_overview);

        button = (Button) findViewById(R.id.one_detail_mapbutton);

        intent = getIntent();
        contentid = intent.getStringExtra("contentid");
        title = intent.getStringExtra("title");
        addr1 = intent.getStringExtra("addr1");
        addr2 = intent.getStringExtra("addr2");
        mapx = intent.getStringExtra("mapx");
        mapy = intent.getStringExtra("mapy");
        zipcode = intent.getStringExtra("zipcode");
        tel = intent.getStringExtra("tel");
        firstimage = intent.getStringExtra("firstimage");

        one_detail_title.setText(title);
        Glide.with(context)
                .load(firstimage)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .fitCenter()
                .into(one_detail_firstimage);
        if (zipcode == null) {
            one_detail_zipcode.setText("");
            one_detail_zipcode.setVisibility(View.GONE);
        } else {
            one_detail_zipcode.setText("- 우편번호 : " + zipcode);
        }
        if (addr2 == null) {
            one_detail_addr1.setText("- 주소 : " + addr1);
        } else {
            one_detail_addr1.setText("- 주소 : " + addr1 + " " + addr2);
        }
        if (tel == null) {
            one_detail_tel.setText("- 전화번호 : 연락처 없음");

        } else {
            tel = tel.replaceAll("&lt;", "<");
            tel = tel.replaceAll("&gt;", ">");
            tel = tel.replaceAll("<br>", "\n");
            tel = tel.replaceAll("<br />", "\n");
            tel = tel.replaceAll("<br/>", "\n");
            tel = tel.replaceAll("&nbsp;", " ");
            one_detail_tel.setText("- 전화번호 : " + tel);
        }

        if (mapx == null || mapy == null) {
            button.setVisibility(View.GONE);
        }

        DownloadWebpageTask downTask = new DownloadWebpageTask();
        String strUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?areaCode=1&MobileOS=ETC&MobileApp=app&ServiceKey=i1UFCFYni9XNLIIaPZy6i4Gakp9pYR%2FSDisEzIS%2FG2AI5B1FdT48nYTohty%2BHzQFkK5YXINU5D80jbDWLJNgZw%3D%3D&defaultYN=Y&overviewYN=Y&contentId=" + contentid;
        downTask.execute(strUrl);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//버튼을 누르면 실행됨
                Intent intent1 = new Intent(DetailOneActivity.this, ShowMapOne.class);//인텐트로 보내지는곳의 클래스와,보낼곳의 위치 DetailOneActivity->ShowMapOne
                intent1.putExtra("mapx", mapx);
                intent1.putExtra("mapy", mapy);
                intent1.putExtra("addr1", addr1);
                startActivity(intent1);
            }
        });

    }

    class DownloadWebpageTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {//url을 입력받아서 다운로드함
            try {

                return (String) downloadUrl((String) urls[0]);
            } catch (IOException e) {
                return "다운로드 실패";
            }
        }

        @Override
        protected void onPostExecute(String result) {

            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml을 파싱하는 함수
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new StringReader(result));
                int eventType = xpp.getEventType();
                boolean bSet = false, bSet2 = false, bSet3 = false, bSet4 = false, bSet5 = false;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {
                    } else if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xpp.getName();
                        if (tag_name.equals("title") || tag_name.equals("homepage") || tag_name.equals("overview") || tag_name.equals("tel") || tag_name.equals("telname")) {
                            if (tag_name.equals("title")) {
                                bSet = true;
                            }
                            if (tag_name.equals("homepage")) {
                                bSet2 = true;
                            }
                            if (tag_name.equals("overview")) {
                                bSet3 = true;
                            }
                            if (tag_name.equals("tel")) {
                                bSet4 = true;
                            }
                            if (tag_name.equals("telname")) {
                                bSet5 = true;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.TEXT) {
                        if (bSet || bSet2 || bSet3 || bSet4 || bSet5) {
                            if (bSet) {
                                title = xpp.getText();
                                bSet = false;
                            }
                            if (bSet2) {
                                homepage = xpp.getText();
                                bSet2 = false;
                            }
                            if (bSet3) {
                                overview = xpp.getText();
                                bSet3 = false;
                            }
                            if (bSet4) {
                                tel = xpp.getText();
                                bSet4 = false;
                            }
                            if (bSet5) {
                                telname = xpp.getText();
                                bSet5 = false;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                    }
                    eventType = xpp.next();
                }
                overview = overview.replaceAll("&lt;", "<");
                overview = overview.replaceAll("&gt;", ">");
                overview = overview.replaceAll("<br>", "\n");
                overview = overview.replaceAll("<br/>", "\n");
                overview = overview.replaceAll("<br />", "\n");
                overview = overview.replaceAll("&nbsp;", " ");
                one_detail_overview.setText(overview);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception :: " + e.getMessage());
            }
        }
    }

    private String downloadUrl(String myurl) throws IOException {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(myurl);
            conn = (HttpURLConnection) url.openConnection();
            BufferedInputStream buf = new BufferedInputStream(conn.getInputStream());
            BufferedReader bufreader = new BufferedReader(new InputStreamReader(buf, "utf-8"));
            String line = null;
            String page = "";
            while ((line = bufreader.readLine()) != null) {
                page += line;
            }
            return page;//page에 웹페이지에 있는 xml을 가지고와서 string으로 바꿔줌
        } finally {
            conn.disconnect();
        }
    }
}
