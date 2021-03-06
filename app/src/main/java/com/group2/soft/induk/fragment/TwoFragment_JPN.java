package com.group2.soft.induk.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.group2.soft.induk.R;
import com.group2.soft.induk.activity.DetailTwoActivity_JPN;
import com.group2.soft.induk.adapter.TwoAdapter;
import com.group2.soft.induk.datacode.AREACODE_JPN;
import com.group2.soft.induk.datacode.CAT3_FOOD_JPN;
import com.group2.soft.induk.datacode.SIGUNGUCODE_JPN;
import com.group2.soft.induk.model.TwoDTO;

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
public class TwoFragment_JPN extends Fragment {
    private TwoAdapter twoAdapter = new TwoAdapter();
    private ListView listTwo;
    private EditText editSearch;
    private ImageView imageSearch;
    private String lang;
    Bundle bundle;
    String searchvalue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        View header = inflater.inflate(R.layout.header_search, null, false);

        listTwo = (ListView) view.findViewById(R.id.list_two);
        editSearch = (EditText) header.findViewById(R.id.edit_search);
        editSearch.setHint("検索 ");
        imageSearch = (ImageView) header.findViewById(R.id.image_search);
        imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchvalue = editSearch.getText().toString();
                twoAdapter.search(searchvalue);


            }
        });
        listTwo.addHeaderView(header);

        listTwo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//리스트뷰를 누르면 인텐트로 contentid값을 넘겨주고 DetailOneActivity에서 contentid값으로 다시 파싱해서 상세정보를 가져옴
                Intent intent = new Intent(getActivity(), DetailTwoActivity_JPN.class);
                TwoDTO tdto = (TwoDTO) twoAdapter.getItem(position - 1);
                intent.putExtra("contentid", tdto.getContentid());
                startActivity(intent);
            }
        });

        DownloadWebpageTask DownTask = new DownloadWebpageTask();
        String strUrl = "http://api.visitkorea.or.kr/openapi/service/rest/JpnService/areaBasedList?ServiceKey=834oAdPjoTtX%2FCihn6VDwM6KuVD3qhnZxf%2F%2F9vJ3emazbqrFpz1CV%2BULbzJUOhr7c797esiz8MaaeHQoq%2BSCbA%3D%3D&numOfRows=50&arrange=B&listYN=Y&contentTypeId=82&areaCode=1&cat1=A05&cat2=A0502&MobileOS=AND&MobileApp=WhereToGoSeoul";
        DownTask.execute(strUrl);

        return view;
    }

    class DownloadWebpageTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            try {
                return (String) downloadUrl((String) urls[0]);
            } catch (IOException e) {
                return "다운로드 실패";
            }
        }

        protected void onPostExecute(String result) {
            try {

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();//xml을 파싱하는 함수
                factory.setNamespaceAware(true);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(new StringReader(result));
                int eventType = xpp.getEventType();

                boolean bSet = false, bSet2 = false, bSet3 = false, bSet4 = false, bSet5 = false, bSet6 = false, bSet7 = false;
                int count = 0;
                int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0;
                String[] areacode = new String[50],
                        cat3 = new String[50],
                        contentid = new String[50],
                        firstimage2 = new String[50],
                        sigungucode = new String[50],
                        title = new String[50],
                        addr1 = new String[50];

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {
                    } else if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xpp.getName();
                        if (tag_name.equals("item")) {
                            count++;
                        }
                        if (tag_name.equals("areacode") || tag_name.equals("cat3") || tag_name.equals("contentid")
                                || tag_name.equals("firstimage2") || tag_name.equals("sigungucode") || tag_name.equals("title") || tag_name.equals("addr1")) {

                            if (tag_name.equals("areacode")) {
                                bSet = true;
                                a++;
                            } else if (tag_name.equals("cat3")) {
                                bSet2 = true;
                                b++;
                            } else if (tag_name.equals("contentid")) {
                                bSet3 = true;
                                c++;
                            } else if (tag_name.equals("firstimage2")) {
                                bSet4 = true;
                                if (d != count) {
                                    d = count;
                                } else {
                                    d++;
                                }
                            } else if (tag_name.equals("sigungucode")) {
                                bSet5 = true;
                                e++;
                            } else if (tag_name.equals("title")) {
                                bSet6 = true;
                                f++;
                            } else if (tag_name.equals("addr1")) {
                                bSet7 = true;
                                g++;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.TEXT) {

                        if (bSet || bSet2 || bSet3 || bSet4 || bSet5 || bSet6 || bSet7) {
                            if (bSet) {
                                int i = 0;
                                String str = "";
                                i = Integer.valueOf(xpp.getText().toString());
                                str = AREACODE_JPN.valueOf(i).toString();
                                str = str.replaceAll("_", "-");
                                str = "[グルメ] " + AREACODE_JPN.valueOf(i).toString();
                                areacode[a - 1] = str;
                                bSet = false;
                            }
                            if (bSet2) {
                                String str = "";
                                str = xpp.getText().toString();
                                str = CAT3_FOOD_JPN.valueOf(str).getValue();
                                str = str.replaceAll("_", "-");
                                cat3[b - 1] = str;
                                bSet2 = false;
                            }
                            if (bSet3) {
                                contentid[c - 1] = xpp.getText();
                                bSet3 = false;
                            }
                            if (bSet4) {
                                firstimage2[d - 1] = xpp.getText();
                                bSet4 = false;
                            }
                            if (bSet5) {
                                int i = 0;
                                String str = "";
                                i = Integer.valueOf(xpp.getText().toString());
                                str = SIGUNGUCODE_JPN.valueOf(i).toString();
                                str = str.replaceAll("_", "-");
                                sigungucode[e - 1] = str;
                                bSet5 = false;
                            }
                            if (bSet6) {
                                title[f - 1] = xpp.getText();
                                bSet6 = false;
                            }
                            if (bSet7) {
                                addr1[g - 1] = xpp.getText();
                                bSet7 = false;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                    }
                    eventType = xpp.next();
                }
                twoAdapter.addItem(areacode, cat3, contentid, firstimage2, sigungucode, title, addr1);
                listTwo.setAdapter(twoAdapter);
            } catch (Exception e) {
                System.out.println("Exception@@@@@@@@@@@@@@@@@@@@@@@@@ : " + e.getMessage());
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
            return page;
        } finally {
            conn.disconnect();
        }
    }

    public TwoAdapter getAdapter() {
        return twoAdapter;
    }
}