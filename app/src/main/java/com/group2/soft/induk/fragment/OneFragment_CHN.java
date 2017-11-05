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
import com.group2.soft.induk.activity.DetailOneActivity_CHN;
import com.group2.soft.induk.adapter.OneAdapter;
import com.group2.soft.induk.datacode.AREACODE_CHN;
import com.group2.soft.induk.datacode.CAT2_CHN;
import com.group2.soft.induk.datacode.CONTENT_TYPE_ID_CHN;
import com.group2.soft.induk.datacode.SIGUNGUCODE_CHN;
import com.group2.soft.induk.model.OneDTO;

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
 * Created by Lee Kyu Hwa on 2016-08-17.
 */
public class OneFragment_CHN extends Fragment {
    private OneAdapter oneAdapter = new OneAdapter();
    private ListView listOne;
    private EditText editSearch;
    private ImageView imageSearch;
    String searchvalue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        View header = inflater.inflate(R.layout.header_search, null, false);

        listOne = (ListView) view.findViewById(R.id.list_one);
        editSearch = (EditText) header.findViewById(R.id.edit_search);
        imageSearch = (ImageView) header.findViewById(R.id.image_search);
        editSearch.setHint("搜索 ");
        imageSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchvalue = editSearch.getText().toString();
                oneAdapter.search(searchvalue);


            }
        });
        listOne.addHeaderView(header);
        listOne.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//리스트뷰를 누르면 인텐트로 contentid값을 넘겨주고 DetailOneActivity에서 contentid값으로 다시 파싱해서 상세정보를 가져옴
                Intent intent = new Intent(getActivity(), DetailOneActivity_CHN.class);
                OneDTO odto = (OneDTO) oneAdapter.getItem(position - 1);
                System.out.println(position + " " + odto.getContentid());
                intent.putExtra("contentid", odto.getContentid());
                intent.putExtra("title", odto.getTitle());
                intent.putExtra("mapx", odto.getMapx());
                intent.putExtra("mapy", odto.getMapy());
                intent.putExtra("addr1", odto.getAddr1());
                intent.putExtra("addr2", odto.getAddr2());
                intent.putExtra("tel", odto.getTel());
                intent.putExtra("firstimage", odto.getFirstimage());
                intent.putExtra("zipcode", odto.getZipcode());
                startActivity(intent);
            }
        });

        DownloadWebpageTask downTask = new DownloadWebpageTask();
        String strUrl = "http://api.visitkorea.or.kr/openapi/service/rest/ChsService/areaBasedList?ServiceKey=834oAdPjoTtX%2FCihn6VDwM6KuVD3qhnZxf%2F%2F9vJ3emazbqrFpz1CV%2BULbzJUOhr7c797esiz8MaaeHQoq%2BSCbA%3D%3D&numOfRows=50&arrange=B&listYN=Y&areaCode=1&MobileOS=AND&MobileApp=WhereToGoSeoul";
        downTask.execute(strUrl);
        return view;
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
                boolean bSet = false, bSet2 = false, bSet3 = false, bSet4 = false, bSet5 = false, bSet6 = false, bSet7 = false, bSet8 = false, bSet9 = false, bSet10 = false, bSet11 = false, bSet12 = false, bSet13 = false;
                int count = 0;
                int i = 0, j = 0, k = 0, h = 0, a = 0, b = 0, c = 0, d = 0, f = 0, g = 0, l = 0, m = 0, n = 0;
                String[] title = new String[50], firstimage = new String[50], addr1 = new String[50], tel = new String[50], contentid = new String[50], mapx = new String[50], mapy = new String[50], sigungucode = new String[50], cat2 = new String[50], zipcode = new String[50], addr2 = new String[50], contenttypeid = new String[50], areacode = new String[50];
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_DOCUMENT) {

                    } else if (eventType == XmlPullParser.START_TAG) {
                        String tag_name = xpp.getName();
                        if (tag_name.equals("item")) {
                            count++;
                        }
                        if (tag_name.equals("title") || tag_name.equals("firstimage") || tag_name.equals("addr1") || tag_name.equals("tel") || tag_name.equals("contentid") || tag_name.equals("mapx") || tag_name.equals("mapy") || tag_name.equals("sigungucode") || tag_name.equals("cat2") || tag_name.equals("addr2") || tag_name.equals("contenttypeid")
                                || (tag_name.equals("zipcode")) || (tag_name.equals("areacode"))) {
                            if (tag_name.equals("firstimage")) {
                                bSet2 = true;
                                if (j != count) {
                                    j = count;
                                } else {
                                    j++;
                                }
                            }
                            if (tag_name.equals("tel")) {
                                bSet4 = true;
                                if (h != count) {
                                    h = count;
                                } else {
                                    h++;
                                }
                            }
                            if (tag_name.equals("title")) {
                                bSet = true;
                                i++;
                            }
                            if (tag_name.equals("addr1")) {
                                bSet3 = true;
                                k++;
                            }

                            if (tag_name.equals("contentid")) {
                                bSet5 = true;
                                a++;
                            }
                            if (tag_name.equals("mapx")) {
                                bSet6 = true;
                                if (b != count) {
                                    b = count;
                                } else {
                                    b++;
                                }
                            }
                            if (tag_name.equals("mapy")) {
                                bSet7 = true;
                                if (c != count) {
                                    c = count;
                                } else {
                                    c++;
                                }
                            }
                            if (tag_name.equals("sigungucode")) {
                                bSet8 = true;
                                d++;
                            }
                            if (tag_name.equals("cat2")) {
                                bSet9 = true;
                                f++;
                            }
                            if (tag_name.equals("zipcode")) {
                                bSet10 = true;
                                if (g != count) {
                                    g = count;
                                } else {
                                    g++;
                                }
                            }
                            if (tag_name.equals("addr2")) {
                                bSet11 = true;
                                if (l != count) {
                                    l = count;
                                } else {
                                    l++;
                                }
                            }
                            if (tag_name.equals("contenttypeid")) {
                                bSet12 = true;
                                m++;
                            }
                            if (tag_name.equals("areacode")) {
                                bSet13 = true;
                                n++;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.TEXT) {
                        if (bSet || bSet2 || bSet3 || bSet4 || bSet5 || bSet6 || bSet7 || bSet8 || bSet9 || bSet10 || bSet11 || bSet12 || bSet13) {
                            if (bSet) {
                                title[i - 1] = xpp.getText();
                                bSet = false;
                            }
                            if (bSet2) {
                                firstimage[j - 1] = xpp.getText();
                                bSet2 = false;
                            }
                            if (bSet3) {
                                addr1[k - 1] = xpp.getText();
                                bSet3 = false;
                            }
                            if (bSet4) {
                                tel[h - 1] = xpp.getText();
                                bSet4 = false;
                            }
                            if (bSet5) {
                                contentid[a - 1] = xpp.getText();
                                bSet5 = false;
                            }
                            if (bSet6) {
                                mapx[b - 1] = xpp.getText();
                                bSet6 = false;
                            }
                            if (bSet7) {
                                mapy[c - 1] = xpp.getText();
                                bSet7 = false;
                            }
                            if (bSet8) {
                                int s = 0;
                                String str = "";
                                s = Integer.valueOf(xpp.getText().toString());
                                if (s == 99) {
                                    str = " ";
                                    sigungucode[d - 1] = str;
                                    bSet8 = false;
                                } else {
                                    str = SIGUNGUCODE_CHN.valueOf(s).toString();
                                    str = str.replaceAll("_", "-");
                                    sigungucode[d - 1] = str;
                                    bSet8 = false;
                                }
                            }
                            if (bSet9) {
                                String str = "";
                                str = xpp.getText().toString();
                                cat2[f - 1] = CAT2_CHN.valueOf(str).getValue();
                                bSet9 = false;
                            }
                            if (bSet10) {
                                zipcode[g - 1] = xpp.getText();
                                bSet10 = false;
                            }
                            if (bSet11) {
                                addr2[l - 1] = xpp.getText();
                                bSet11 = false;
                            }
                            if (bSet12) {
                                int s = 0;
                                s = Integer.valueOf(xpp.getText().toString());
                                String str = CONTENT_TYPE_ID_CHN.valueOf(s).toString();
                                str = str.replaceAll("_", "/");
                                contenttypeid[m - 1] = str;
                                bSet12 = false;
                            }
                            if (bSet13) {
                                int s = 0;
                                s = Integer.valueOf(xpp.getText().toString());
                                String str = AREACODE_CHN.valueOf(s).toString();
                                areacode[n - 1] = str;
                                bSet13 = false;
                            }
                        } else {
                            eventType = xpp.next();
                            continue;
                        }
                    } else if (eventType == XmlPullParser.END_TAG) {
                    }
                    eventType = xpp.next();
                }
                oneAdapter.addItem(title, addr1, firstimage, tel, contentid, mapx, mapy, sigungucode, cat2, zipcode, addr2, contenttypeid, areacode);
                listOne.setAdapter(oneAdapter);
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

    public OneAdapter getAdapter() {
        return oneAdapter;
    }
}
