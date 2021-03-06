package com.group2.soft.induk.activity;

import android.app.Activity;
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
import com.group2.soft.induk.ShowMap;

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
 * Created by JHK on 16. 8. 22..
 */
public class DetailTwoActivity extends Activity {
    private Intent intent = new Intent();

    private TextView textView_title, textView_addr1, textView_overview, textView_tel, textView_zipcode;

    private TextView textView_firstmenu, textView_infocenterfood, textView_opentimefood, textView_packing, textView_parkingfood, textView_reservationfood,
            textView_restdatefood, textView_seat, textView_smoking, textView_treatmenu;

    private ImageView imageView_firstimage;

    private String addr1, addr2, firstimage, mapx, mapy, overview, tel, title, zipcode, contentid;

    private String firstmenu, infocenterfood, opentimefood, packing, parkingfood, reservationfood, restdatefood, seat, smoking, treatmenu;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_detail);

        button = (Button) findViewById(R.id.two_detail_mapbutton);

        textView_title = (TextView) findViewById(R.id.two_detail_title);
        textView_addr1 = (TextView) findViewById(R.id.two_text_addr1);
        textView_overview = (TextView) findViewById(R.id.two_text_overview);
        textView_tel = (TextView) findViewById(R.id.two_text_tel);
        textView_zipcode = (TextView) findViewById(R.id.two_text_zipcode);

        imageView_firstimage = (ImageView) findViewById(R.id.two_image_firstimage);

        textView_firstmenu = (TextView) findViewById(R.id.two_text_firstmenu);
        textView_infocenterfood = (TextView) findViewById(R.id.two_text_infocenterfood);
        textView_opentimefood = (TextView) findViewById(R.id.two_text_opentimefood);
        textView_packing = (TextView) findViewById(R.id.two_text_packing);
        textView_parkingfood = (TextView) findViewById(R.id.two_text_parkingfood);
        textView_reservationfood = (TextView) findViewById(R.id.two_text_reservationfood);
        textView_restdatefood = (TextView) findViewById(R.id.two_text_restdatefood);
        textView_seat = (TextView) findViewById(R.id.two_text_seat);
        textView_smoking = (TextView) findViewById(R.id.two_text_smoking);
        textView_treatmenu = (TextView) findViewById(R.id.two_text_treatmenu);

        intent = getIntent();
        contentid = intent.getStringExtra("contentid");

        DownloadWebpageTask1 downTask1 = new DownloadWebpageTask1();
        //System.out.println("contentid :" + contentid);
        String strUrl1 = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?ServiceKey=834oAdPjoTtX%2FCihn6VDwM6KuVD3qhnZxf%2F%2F9vJ3emazbqrFpz1CV%2BULbzJUOhr7c797esiz8MaaeHQoq%2BSCbA%3D%3D&contentId=" + contentid + "&defaultYN=Y&firstImageYN=Y&areacodeYN=&addrinfoYN=Y&catcodeYN=Y&mapinfoYN=Y&overviewYN=Y&MobileOS=ETC&MobileApp=AppTesting";
        downTask1.execute(strUrl1);

        DownloadWebpageTask downTask = new DownloadWebpageTask();
        //System.out.println("contentid :"+contentid);
        String strUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?ServiceKey=834oAdPjoTtX%2FCihn6VDwM6KuVD3qhnZxf%2F%2F9vJ3emazbqrFpz1CV%2BULbzJUOhr7c797esiz8MaaeHQoq%2BSCbA%3D%3D&contentId=" + contentid + "&contentTypeId=39&MobileOS=AND&MobileApp=AppTesting";
        downTask.execute(strUrl);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//버튼을 누르면 실행됨
                Intent intent1 = new Intent(DetailTwoActivity.this, ShowMap.class);//인텐트로 보내지는곳의 클래스와,보낼곳의 위치 DetailOneActivity->ShowMapOne
                intent1.putExtra("mapx", mapx);
                intent1.putExtra("mapy", mapy);
                intent1.putExtra("addr1", addr1);
                startActivity(intent1);
            }
        });
    }

    class DownloadWebpageTask1 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {//url을 입력받아서 다운로드함
            try {
                System.out.println("url : " + urls[0]);
                return (String) downloadUrl((String) urls[0]);
            } catch (IOException e) {
                return "다운로드 실패";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            System.out.println("result : " + result);
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml을 파싱하는 함수
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new StringReader(result));
                int eventType = xpp.getEventType();

                boolean bSet = false, bSet2 = false, bSet3 = false, bSet4 = false, bSet5 = false,
                        bSet6 = false, bSet7 = false, bSet8 = false, bSet9 = false;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {
                    } else if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xpp.getName();
                        if (tag_name.equals("addr1") || tag_name.equals("addr2") || tag_name.equals("firstimage") || tag_name.equals("mapx") || tag_name.equals("mapy")
                                || tag_name.equals("overview") || tag_name.equals("tel") || tag_name.equals("title") || tag_name.equals("zipcode")) {
                            if (tag_name.equals("addr1")) {
                                bSet = true;
                            }
                            if (tag_name.equals("addr2")) {
                                bSet2 = true;
                            }
                            if (tag_name.equals("firstimage")) {
                                bSet3 = true;
                            }
                            if (tag_name.equals("mapx")) {
                                bSet4 = true;
                            }
                            if (tag_name.equals("mapy")) {
                                bSet5 = true;
                            }
                            if (tag_name.equals("overview")) {
                                bSet6 = true;
                            }
                            if (tag_name.equals("tel")) {
                                bSet7 = true;
                            }
                            if (tag_name.equals("title")) {
                                bSet8 = true;
                            }
                            if (tag_name.equals("zipcode")) {
                                bSet9 = true;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.TEXT) {
                        if (bSet || bSet2 || bSet3 || bSet4 || bSet5 || bSet6 || bSet7 || bSet8 || bSet9) {
                            if (bSet) {
                                addr1 = xpp.getText();
                                bSet = false;
                            }
                            if (bSet2) {
                                addr2 = xpp.getText();
                                bSet2 = false;
                            }
                            if (bSet3) {
                                firstimage = xpp.getText();
                                bSet3 = false;
                            }
                            if (bSet4) {
                                mapx = xpp.getText();
                                bSet4 = false;
                            }
                            if (bSet5) {
                                mapy = xpp.getText();
                                bSet5 = false;
                            }
                            if (bSet6) {
                                overview = xpp.getText();
                                overview = overview.replaceAll("&lt;", "<");
                                overview = overview.replaceAll("&gt;", ">");
                                overview = overview.replaceAll("<br>", "\n");
                                overview = overview.replaceAll("<br/>", "\n");
                                overview = overview.replaceAll("<br />", "\n");
                                overview = overview.replaceAll("<Br>", "\n");
                                bSet6 = false;
                            }
                            if (bSet7) {
                                tel = xpp.getText();
                                bSet7 = false;
                            }
                            if (bSet8) {
                                title = xpp.getText();
                                bSet8 = false;
                            }
                            if (bSet9) {
                                zipcode = xpp.getText();
                                bSet9 = false;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                    }
                    eventType = xpp.next();
                }

                textView_title.setText(title);
                if (firstimage == null) {
                    Glide.with(DetailTwoActivity.this)
                            .load(R.drawable.no_image)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true)
                            .into(imageView_firstimage);
                } else {
                    Glide.with(DetailTwoActivity.this)
                            .load(firstimage)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true)
                            .into(imageView_firstimage);
                }
                if (zipcode == null) {
                    textView_zipcode.setText("");
                    textView_zipcode.setVisibility(View.GONE);
                } else {
                    textView_zipcode.setText("- 우편번호 : " + zipcode);
                }
                if (addr2 == null) {
                    textView_addr1.setText("- 주소 : " + addr1);
                } else {
                    textView_addr1.setText("- 주소 : " + addr1 + " " + addr2);
                }
                if (tel == null) {
                    textView_tel.setText("- 전화번호 : 연락처 없음");

                } else {
                    tel = tel.replaceAll("&lt;", "<");
                    tel = tel.replaceAll("&gt;", ">");
                    tel = tel.replaceAll("<br>", "\n");
                    tel = tel.replaceAll("<br />", "\n");
                    tel = tel.replaceAll("<br/>", "\n");
                    tel = tel.replaceAll("&nbsp;", " ");
                    textView_tel.setText("- 전화번호 : " + tel);
                }
                textView_overview.setText(overview);

                if (mapx == null || mapy == null) {
                    button.setVisibility(View.GONE);
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception :: " + e.getMessage());
            }
        }
    }

    class DownloadWebpageTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {//url을 입력받아서 다운로드함
            try {
                System.out.println("url : " + urls[0]);
                return (String) downloadUrl((String) urls[0]);
            } catch (IOException e) {
                return "다운로드 실패";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            System.out.println("result : " + result);
            try {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml을 파싱하는 함수
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new StringReader(result));
                int eventType = xpp.getEventType();

                boolean bSet = false, bSet2 = false, bSet3 = false, bSet4 = false, bSet5 = false,
                        bSet6 = false, bSet7 = false, bSet8 = false, bSet9 = false, bSet10 = false;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {

                    } else if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xpp.getName();
                        if (tag_name.equals("firstmenu") || tag_name.equals("infocenterfood") || tag_name.equals("opentimefood") || tag_name.equals("packing") || tag_name.equals("parkingfood")
                                || tag_name.equals("reservationfood") || tag_name.equals("restdatefood") || tag_name.equals("seat") || tag_name.equals("smoking") || tag_name.equals("treatmenu")) {
                            if (tag_name.equals("firstmenu")) {
                                bSet = true;
                            }
                            if (tag_name.equals("infocenterfood")) {
                                bSet2 = true;
                            }
                            if (tag_name.equals("opentimefood")) {
                                bSet3 = true;
                            }
                            if (tag_name.equals("packing")) {
                                bSet4 = true;
                            }
                            if (tag_name.equals("parkingfood")) {
                                bSet5 = true;
                            }
                            if (tag_name.equals("reservationfood")) {
                                bSet6 = true;
                            }
                            if (tag_name.equals("restdatefood")) {
                                bSet7 = true;
                            }
                            if (tag_name.equals("seat")) {
                                bSet8 = true;
                            }
                            if (tag_name.equals("smoking")) {
                                bSet9 = true;
                            }
                            if (tag_name.equals("treatmenu")) {
                                bSet10 = true;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.TEXT) {
                        if (bSet || bSet2 || bSet3 || bSet4 || bSet5 || bSet6 || bSet7 || bSet8 || bSet9 || bSet10) {
                            if (bSet) {
                                firstmenu = xpp.getText();
                                bSet = false;
                            }
                            if (bSet2) {
                                infocenterfood = xpp.getText();
                                infocenterfood = infocenterfood.replaceAll("&lt;", "<");
                                infocenterfood = infocenterfood.replaceAll("&gt;", ">");
                                infocenterfood = infocenterfood.replaceAll("<br>", "\n");
                                infocenterfood = infocenterfood.replaceAll("<br />", "\n");
                                infocenterfood = infocenterfood.replaceAll("<br/>", "\n");
                                infocenterfood = infocenterfood.replaceAll("<bR>", "\n");
                                infocenterfood = infocenterfood.replaceAll("&nbsp;", " ");
                                bSet2 = false;
                            }
                            if (bSet3) {
                                opentimefood = xpp.getText();
                                opentimefood = opentimefood.replaceAll("&lt;", "<");
                                opentimefood = opentimefood.replaceAll("&gt;", ">");
                                opentimefood = opentimefood.replaceAll("<br>", "\n");
                                opentimefood = opentimefood.replaceAll("<br />", "\n");
                                opentimefood = opentimefood.replaceAll("<br/>", "\n");
                                opentimefood = opentimefood.replaceAll("&nbsp;", " ");
                                bSet3 = false;
                            }
                            if (bSet4) {
                                packing = xpp.getText();
                                bSet4 = false;
                            }
                            if (bSet5) {
                                parkingfood = xpp.getText();
                                bSet5 = false;
                            }
                            if (bSet6) {
                                reservationfood = xpp.getText();
                                bSet6 = false;
                            }
                            if (bSet7) {
                                restdatefood = xpp.getText();
                                bSet7 = false;
                            }
                            if (bSet8) {
                                seat = xpp.getText();
                                bSet8 = false;
                            }
                            if (bSet9) {
                                smoking = xpp.getText();
                                bSet9 = false;
                            }
                            if (bSet10) {
                                treatmenu = xpp.getText();
                                treatmenu = treatmenu.replaceAll("&lt;", "<");
                                treatmenu = treatmenu.replaceAll("&gt;", ">");
                                treatmenu = treatmenu.replaceAll("<br>", "\n");
                                treatmenu = treatmenu.replaceAll("<br />", "\n");
                                treatmenu = treatmenu.replaceAll("<br/>", "\n");
                                treatmenu = treatmenu.replaceAll("&nbsp;", "\n");
                                bSet10 = false;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                    }
                    eventType = xpp.next();
                }
                /*
                System.out.println("addr1 :" +addr1 +" addr2 : "+addr2+" firstimage : "+firstimage+" mapx : "+mapx+" mapy : "+mapy
                        +" overview :" +overview +" tel : "+tel+" title : "+title+" zipcode : "+zipcode);
                System.out.println("firstmenu :" +firstmenu +"infocenterfood : "+infocenterfood+"opentimefood : "+opentimefood+"packing : "+packing+"parkingfood : "+parkingfood
                +"reservationfood :" +reservationfood +"restdatefood : "+restdatefood+"seat : "+seat+"smoking : "+smoking+"treatmenu : "+treatmenu);
                */

                textView_infocenterfood.setText("- 문의 및 안내 : " + infocenterfood);
                textView_firstmenu.setText("- 대표 메뉴 : " + firstmenu);
                textView_opentimefood.setText("- 영업 시간 : " + opentimefood);
                if (packing == null) {
                    textView_packing.setText("");
                    textView_packing.setVisibility(View.GONE);
                } else {
                    textView_packing.setText("- 포장 가능 여부 : " + packing);
                }
                if (parkingfood == null) {
                    textView_parkingfood.setText("");
                    textView_parkingfood.setVisibility(View.GONE);
                } else {
                    textView_parkingfood.setText("- 주차 시간 : " + parkingfood);
                }
                if (reservationfood == null) {
                    textView_reservationfood.setText("");
                    textView_reservationfood.setVisibility(View.GONE);
                } else {
                    textView_reservationfood.setText("- 예약 안내 : " + reservationfood);
                }
                if (restdatefood == null) {
                    textView_restdatefood.setText("");
                    textView_restdatefood.setVisibility(View.GONE);
                } else {
                    textView_restdatefood.setText("- 쉬는날 : " + restdatefood);
                }
                if (seat == null) {
                    textView_seat.setText("");
                    textView_seat.setVisibility(View.GONE);
                } else {
                    textView_seat.setText("- 좌석수 : " + seat);
                }
                if (smoking == null) {
                    textView_smoking.setText("");
                    textView_smoking.setVisibility(View.GONE);
                } else {
                    textView_smoking.setText("- 금연/흡연 여부 : " + smoking);
                }
                textView_treatmenu.setText("- 취급 메뉴 : \n" + treatmenu);
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
