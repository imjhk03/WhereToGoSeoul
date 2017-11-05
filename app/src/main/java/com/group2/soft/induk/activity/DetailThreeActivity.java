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
public class DetailThreeActivity extends Activity {
    private Intent intent = new Intent();

    private Context context = this;

    private TextView textView;
    String title, homepage, overview, tel, telname;
    TextView three_detail_title, three_detail_overview, three_detail_tel, three_detail_addr1, three_detail_zipcode;

    private TextView textView_infocenterlodging, textView_scalelodging, textView_accomcountlodging, textView_roomcount, textView_roomtype, textView_parkinglodging, textView_chkcooking,
            textView_checkintime, textView_checkouttime, textView_reservationlodging, textView_reservationurl, textView_pickup, textView_foodplace;

    ImageView three_detail_firstimage;
    Button button;
    String contentid, mapx, mapy, addr1, firstimage, zipcode, addr2;

    String infocenterlodging, scalelodging, accomcountlodging, roomcount, roomtype, parkinglodging, chkcooking, checkintime, checkouttime, reservationlodging, reservationurl,
            pickup, foodplace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_detail);

        three_detail_title = (TextView) findViewById(R.id.three_detail_title);
        three_detail_firstimage = (ImageView) findViewById(R.id.three_detail_firstimage);
        three_detail_tel = (TextView) findViewById(R.id.three_detail_tel);
        three_detail_zipcode = (TextView) findViewById(R.id.three_detail_zipcode);
        three_detail_addr1 = (TextView) findViewById(R.id.three_detail_addr1);
        three_detail_overview = (TextView) findViewById(R.id.three_detail_overview);

        button = (Button) findViewById(R.id.three_detail_mapbutton);

        textView_infocenterlodging = (TextView) findViewById(R.id.three_text_infocenterlodging);
        textView_scalelodging = (TextView) findViewById(R.id.three_text_scalelodging);
        textView_accomcountlodging = (TextView) findViewById(R.id.three_text_accomcountlodging);
        textView_roomcount = (TextView) findViewById(R.id.three_text_roomcount);
        textView_roomtype = (TextView) findViewById(R.id.three_text_roomtype);
        textView_parkinglodging = (TextView) findViewById(R.id.three_text_parkinglodging);
        textView_chkcooking = (TextView) findViewById(R.id.three_text_chkcooking);
        textView_checkintime = (TextView) findViewById(R.id.three_text_checkintime);
        textView_checkouttime = (TextView) findViewById(R.id.three_text_checkouttime);
        textView_reservationlodging = (TextView) findViewById(R.id.three_text_reservationlodging);
        textView_reservationurl = (TextView) findViewById(R.id.three_text_reservationurl);
        textView_pickup = (TextView) findViewById(R.id.three_text_pickup);
        textView_foodplace = (TextView) findViewById(R.id.three_text_foodplace);

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

        three_detail_title.setText(title);
        Glide.with(context)
                .load(firstimage)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .fitCenter()
                .into(three_detail_firstimage);
        if (zipcode == null) {
            three_detail_zipcode.setText("");
            three_detail_zipcode.setVisibility(View.GONE);
        } else {
            three_detail_zipcode.setText("- 우편번호 : " + zipcode);
        }
        if (addr2 == null) {
            three_detail_addr1.setText("- 주소 : " + addr1);
        } else {
            three_detail_addr1.setText("- 주소 : " + addr1 + " " + addr2);
        }
        if (tel == null) {
            three_detail_tel.setText("- 전화번호 : 연락처 없음");

        } else {
            tel = tel.replaceAll("&lt;", "<");
            tel = tel.replaceAll("&gt;", ">");
            tel = tel.replaceAll("<br>", "\n");
            tel = tel.replaceAll("<br />", "\n");
            tel = tel.replaceAll("<br/>", "\n");
            tel = tel.replaceAll("&nbsp;", " ");
            three_detail_tel.setText("- 전화번호 : " + tel);
        }

        if (mapx == null || mapy == null) {
            button.setVisibility(View.GONE);
        }

        DownloadWebpageTask1 downTask1 = new DownloadWebpageTask1();
        System.out.println(contentid);
        String strUrl1 = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?areaCode=1&MobileOS=ETC&MobileApp=app&ServiceKey=i1UFCFYni9XNLIIaPZy6i4Gakp9pYR%2FSDisEzIS%2FG2AI5B1FdT48nYTohty%2BHzQFkK5YXINU5D80jbDWLJNgZw%3D%3D&defaultYN=Y&overviewYN=Y&contentId=" + contentid;
        downTask1.execute(strUrl1);

        DownloadWebpageTask downTask = new DownloadWebpageTask();
        System.out.println(contentid);
        String strUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailIntro?areaCode=1&MobileOS=ETC&MobileApp=app&ServiceKey=i1UFCFYni9XNLIIaPZy6i4Gakp9pYR%2FSDisEzIS%2FG2AI5B1FdT48nYTohty%2BHzQFkK5YXINU5D80jbDWLJNgZw%3D%3D&contentId=" + contentid + "&contentTypeId=32&MobileOS=AND&MobileApp=AppTesting";
        downTask.execute(strUrl);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//버튼을 누르면 실행됨
                Intent intent1 = new Intent(DetailThreeActivity.this, ShowMapOne.class);//인텐트로 보내지는곳의 클래스와,보낼곳의 위치 DetailOneActivity->ShowMapOne
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
                three_detail_overview.setText(overview);
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
                        bSet6 = false, bSet7 = false, bSet8 = false, bSet9 = false, bSet10 = false,
                        bSet11 = false, bSet12 = false, bSet13 = false, bSet14 = false;

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {

                    } else if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xpp.getName();
                        if (tag_name.equals("infocenterlodging") || tag_name.equals("scalelodging") || tag_name.equals("accomcountlodging") || tag_name.equals("roomcount") || tag_name.equals("roomtype")
                                || tag_name.equals("parkinglodging") || tag_name.equals("chkcooking") || tag_name.equals("checkintime") || tag_name.equals("checkouttime") || tag_name.equals("reservationlodging")
                                || tag_name.equals("reservationurl") || tag_name.equals("pickup") || tag_name.equals("foodplace") || tag_name.equals("roomtype")) {
                            if (tag_name.equals("infocenterlodging")) {
                                bSet = true;
                            }
                            if (tag_name.equals("scalelodging")) {
                                bSet2 = true;
                            }
                            if (tag_name.equals("accomcountlodging")) {
                                bSet3 = true;
                            }
                            if (tag_name.equals("roomcount")) {
                                bSet4 = true;
                            }
                            if (tag_name.equals("roomtype")) {
                                bSet5 = true;
                            }
                            if (tag_name.equals("parkinglodging")) {
                                bSet6 = true;
                            }
                            if (tag_name.equals("chkcooking")) {
                                bSet7 = true;
                            }
                            if (tag_name.equals("checkintime")) {
                                bSet8 = true;
                            }
                            if (tag_name.equals("checkouttime")) {
                                bSet9 = true;
                            }
                            if (tag_name.equals("reservationlodging")) {
                                bSet10 = true;
                            }
                            if (tag_name.equals("reservationurl")) {
                                bSet11 = true;
                            }
                            if (tag_name.equals("pickup")) {
                                bSet12 = true;
                            }
                            if (tag_name.equals("foodplace")) {
                                bSet13 = true;
                            }
                            if (tag_name.equals("roomtype")) {
                                bSet14 = true;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.TEXT) {
                        if (bSet || bSet2 || bSet3 || bSet4 || bSet5 || bSet6 || bSet7 || bSet8 || bSet9 || bSet10 || bSet11 || bSet12 || bSet13 || bSet14) {
                            if (bSet) {
                                infocenterlodging = xpp.getText();
                                bSet = false;
                            }
                            if (bSet2) {
                                scalelodging = xpp.getText();
                                bSet2 = false;
                            }
                            if (bSet3) {
                                accomcountlodging = xpp.getText();
                                bSet3 = false;
                            }
                            if (bSet4) {
                                roomcount = xpp.getText();
                                bSet4 = false;
                            }
                            if (bSet5) {
                                roomtype = xpp.getText();
                                bSet5 = false;
                            }
                            if (bSet6) {
                                parkinglodging = xpp.getText();
                                bSet6 = false;
                            }
                            if (bSet7) {
                                chkcooking = xpp.getText();
                                bSet7 = false;
                            }
                            if (bSet8) {
                                checkintime = xpp.getText();
                                bSet8 = false;
                            }
                            if (bSet9) {
                                checkouttime = xpp.getText();
                                bSet9 = false;
                            }
                            if (bSet10) {
                                reservationlodging = xpp.getText();
                                bSet10 = false;
                            }
                            if (bSet11) {
                                reservationurl = xpp.getText();
                                reservationurl = reservationurl.replaceAll("&lt;", "<");
                                reservationurl = reservationurl.replaceAll("&gt;", ">");
                                reservationurl = reservationurl.replaceAll("<br>", "\n");
                                reservationurl = reservationurl.replaceAll("<br/>", "\n");
                                reservationurl = reservationurl.replaceAll("<br />", "\n");
                                reservationurl = reservationurl.replaceAll("&nbsp;", " ");
                                bSet11 = false;
                            }
                            if (bSet12) {
                                pickup = xpp.getText();
                                bSet12 = false;
                            }
                            if (bSet13) {
                                foodplace = xpp.getText();
                                bSet13 = false;
                            }
                            if (bSet14) {
                                roomtype = xpp.getText();
                                bSet14 = false;
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

                textView_infocenterlodging.setText("- 문의 및 안내 : " + infocenterlodging);
                if (scalelodging == null) {
                    textView_scalelodging.setText("");
                    textView_scalelodging.setVisibility(View.GONE);
                } else {
                    textView_scalelodging.setText("- 규모 : " + scalelodging);
                }
                if (accomcountlodging == null) {
                    textView_accomcountlodging.setText("");
                    textView_accomcountlodging.setVisibility(View.GONE);
                } else {
                    textView_accomcountlodging.setText("- 수용 가능 인원 : " + accomcountlodging);
                }
                if (roomcount == null) {
                    textView_roomcount.setText("");
                    textView_roomcount.setVisibility(View.GONE);
                } else {
                    textView_roomcount.setText("- 객실 수 : " + roomcount);
                }
                if (roomtype == null) {
                    textView_roomtype.setText("");
                    textView_roomtype.setVisibility(View.GONE);
                } else {
                    textView_roomtype.setText("- 객실 유형 : " + roomtype);
                }
                if (parkinglodging == null) {
                    textView_parkinglodging.setText("");
                    textView_parkinglodging.setVisibility(View.GONE);
                } else {
                    textView_parkinglodging.setText("- 주차 가능 : " + parkinglodging);
                }
                if (chkcooking == null) {
                    textView_chkcooking.setText("");
                    textView_chkcooking.setVisibility(View.GONE);
                } else {
                    textView_chkcooking.setText("- 조리 가능 : " + chkcooking);
                }
                if (checkintime == null) {
                    textView_checkintime.setText("");
                    textView_checkintime.setVisibility(View.GONE);
                } else {
                    textView_checkintime.setText("- 체크인 : " + checkintime);
                }
                if (checkouttime == null) {
                    textView_checkouttime.setText("");
                    textView_checkouttime.setVisibility(View.GONE);
                } else {
                    textView_checkouttime.setText("- 체크아웃 : " + checkouttime);
                }
                if (reservationlodging == null) {
                    textView_reservationlodging.setText("");
                    textView_reservationlodging.setVisibility(View.GONE);
                } else {
                    textView_reservationlodging.setText("- 예약 안내 : " + reservationlodging);
                }
                if (reservationurl == null) {
                    textView_reservationurl.setText("");
                    textView_reservationurl.setVisibility(View.GONE);
                } else {
                    textView_reservationurl.setText("- 예약안내 홈페이지 : \n" + reservationurl);
                }
                if (pickup == null) {
                    textView_pickup.setText("");
                    textView_pickup.setVisibility(View.GONE);
                } else {
                    textView_pickup.setText("- 픽업서비스 : " + pickup);
                }
                if (foodplace == null) {
                    textView_foodplace.setText("");
                    textView_foodplace.setVisibility(View.GONE);
                } else {
                    textView_foodplace.setText("- 식음료장 : " + foodplace);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception :: " + e.getMessage());
            }
        }
    }
}
