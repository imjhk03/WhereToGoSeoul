package com.group2.soft.induk.adapter;


import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.group2.soft.induk.R;
import com.group2.soft.induk.model.OneDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Lee Kyu Hwa on 2016-08-18.
 */
public class OneAdapter extends BaseAdapter {
    private ArrayList<OneDTO> oneList = new ArrayList<OneDTO>();
    ArrayList<OneDTO> oneList2 = new ArrayList<>();

    @Override
    public int getCount() {
        return oneList.size();
    }

    @Override
    public Object getItem(int position) {
        return oneList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        OneDTO odto = oneList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_one, parent, false);
        }

//        ImageView imageUrl = (ImageView) convertView.findViewById(R.id.image_url);
        TextView one_text_title = (TextView) convertView.findViewById(R.id.one_text_title);
        TextView one_text_cat2 = (TextView) convertView.findViewById(R.id.one_text_cat2);
        TextView one_text_contenttypeid = (TextView) convertView.findViewById(R.id.one_text_contenttypeid);
        TextView one_text_areacode = (TextView) convertView.findViewById(R.id.one_text_areacode);
        TextView one_text_sigungucode = (TextView) convertView.findViewById(R.id.one_text_sigungucode);
        ImageView imagefirstimage = (ImageView) convertView.findViewById(R.id.one_image_url);

        Paint alpha = new Paint();
        imagefirstimage.setAlpha(90);

        one_text_title.setText(odto.getTitle());
        if (odto.getFirstimage() == null) {
            Glide.with((Activity) context)
                    .load(R.drawable.no_image)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(imagefirstimage);
        } else {
            Glide.with((Activity) context)
                    .load(odto.getFirstimage())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(imagefirstimage);
        }
        one_text_cat2.setText(odto.getCat2());
        one_text_contenttypeid.setText("[" + odto.getConttenttypeid() + "] ");
        one_text_areacode.setText(odto.getAreacode() + " ");
        one_text_sigungucode.setText(odto.getSigungucode());

        return convertView;
    }

    public void addItem(String[] title, String[] addr1, String[] firstimage, String[] tel, String[] contentid, String[] mapx, String[] mapy, String[] sigungucode, String[] cat2, String[] zipcode, String[] addr2, String[] contenttypeid, String[] areacode) {
        oneList.clear();
        for (int i = 0; i < title.length; i++) {
            OneDTO odto = new OneDTO();
            odto.setTitle(title[i]);
            odto.setAddr1(addr1[i]);
            odto.setFirstimage(firstimage[i]);
            odto.setTel(tel[i]);
            odto.setContentid(contentid[i]);
            odto.setMapx(mapx[i]);
            odto.setMapy(mapy[i]);
            odto.setSigungucode(sigungucode[i]);
            odto.setCat2(cat2[i]);
            odto.setZipcode(zipcode[i]);
            odto.setAddr2(addr2[i]);
            odto.setConttenttypeid(contenttypeid[i]);
            odto.setAreacode(areacode[i]);
            oneList.add(odto);
        }


    }

    public void sortByTitle() {
        Collections.sort(oneList, new Comparator<OneDTO>() {
            @Override
            public int compare(OneDTO lhs, OneDTO rhs) {
                return lhs.getTitle().compareTo(rhs.getTitle());
            }
        });
    }

    public void sortByAddr1() {
        Collections.sort(oneList, new Comparator<OneDTO>() {
            @Override
            public int compare(OneDTO lhs, OneDTO rhs) {
                return lhs.getSigungucode().compareTo(rhs.getSigungucode());
            }
        });
    }

    protected void onCreate(Bundle savedInstanceState) {

    }

    public void search(String a) {
        a = a.toUpperCase();
        int j = 0;
        if (oneList.size() == 50) {
            oneList2 = new ArrayList<>();
            for (int i = 0; i < oneList.size(); i++) {
                oneList2.add(oneList.get(i));
            }
        } else {
            for (int i = 0; i < oneList2.size(); i++) {
                oneList.add(oneList2.get(i));
            }
        }
        oneList.clear();
        for (int i = 0; i < oneList2.size(); i++) {
            OneDTO odto1 = oneList2.get(i);
            if (odto1.getTitle().toUpperCase().contains(a) || odto1.getSigungucode().toUpperCase().contains(a) || odto1.getConttenttypeid().toUpperCase().contains(a) || odto1.getAreacode().toUpperCase().contains(a)) {
                oneList.add(odto1);
                j++;
            } else if (a == null) {
                oneList.clear();
                oneList = oneList2;
            }
            if (j == 50) {
                oneList = oneList2;
            }
        }
        notifyDataSetChanged();
    }


}
