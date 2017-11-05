package com.group2.soft.induk.adapter;


import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.group2.soft.induk.R;
import com.group2.soft.induk.model.ThreeDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Lee Kyu Hwa on 2016-08-18.
 */
public class ThreeAdapter extends BaseAdapter {
    private ArrayList<ThreeDTO> threeList = new ArrayList<ThreeDTO>();
    ArrayList<ThreeDTO> threeList2 = new ArrayList<>();

    @Override
    public int getCount() {
        return threeList.size();
    }

    @Override
    public Object getItem(int position) {
        return threeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        ThreeDTO thdto = threeList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_three, parent, false);
        }

//        ImageView imageUrl = (ImageView) convertView.findViewById(R.id.image_url);
        /*
        TextView Three_text_title = (TextView) convertView.findViewById(R.id.three_text_title);
        TextView Three_text_cat3 = (TextView) convertView.findViewById(R.id.three_text_cat3);
        TextView Three_text_addr=(TextView)convertView.findViewById(R.id.three_text_addr);
        ImageView imagefirstimage=(ImageView) convertView.findViewById(R.id.three_image_url);
        */

        ImageView imagefirstimage = (ImageView) convertView.findViewById(R.id.three_image_url);
        TextView textTitle = (TextView) convertView.findViewById(R.id.three_text_title);
        TextView textCat3 = (TextView) convertView.findViewById(R.id.three_text_cat3);
        TextView textAreaCode = (TextView) convertView.findViewById(R.id.three_text_areacode);
        TextView textSigunguCode = (TextView) convertView.findViewById(R.id.three_text_sigungucode);

        Paint alpha = new Paint();
        imagefirstimage.setAlpha(90);


        textTitle.setText(thdto.getTitle());
        textCat3.setText(thdto.getCat3());
        textAreaCode.setText(thdto.getAreacode());
        textSigunguCode.setText(" " + thdto.getSigungucode());


//        Uri uri = Uri.parse(odto.getUrl());
        /*
        Three_text_title.setText(thdto.getTitle());
        Three_text_cat3.setText(thdto.getCat3());
        Three_text_areacode.setText(thdto.());
        Three_text_addr.setText(" " + thdto.getSigungucode());
*/
        if (thdto.getFirstimage() == null) {
            Glide.with((Activity) context)
                    .load(R.drawable.no_image)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(imagefirstimage);
        } else {
            Glide.with((Activity) context)
                    .load(thdto.getFirstimage())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(imagefirstimage);
        }

        return convertView;
    }

    public void addItem(String[] title, String[] addr1, String[] firstimage, String[] tel, String[] contentid, String[] mapx, String[] mapy, String[] sigungucode, String[] cat2, String[] cat3, String[] addr2, String[] zipcode, String[] areacode) {
        threeList.clear();
        for (int i = 0; i < title.length; i++) {
            ThreeDTO thdto = new ThreeDTO();
            thdto.setTitle(title[i]);
            thdto.setAddr1(addr1[i]);
            thdto.setFirstimage(firstimage[i]);
            thdto.setTel(tel[i]);
            thdto.setContentid(contentid[i]);
            thdto.setMapx(mapx[i]);
            thdto.setMapy(mapy[i]);
            thdto.setSigungucode(sigungucode[i]);
            thdto.setCat2(cat2[i]);
            thdto.setCat3(cat3[i]);
            thdto.setAddr2(addr2[i]);
            thdto.setZipcode(zipcode[i]);
            thdto.setAreacode(areacode[i]);
            threeList.add(thdto);
        }

    }

    public void sortByTitle() {
        Collections.sort(threeList, new Comparator<ThreeDTO>() {
            @Override
            public int compare(ThreeDTO lhs, ThreeDTO rhs) {
                return lhs.getTitle().compareTo(rhs.getTitle());
            }
        });
    }

    public void sortByAddr1() {
        Collections.sort(threeList, new Comparator<ThreeDTO>() {
            @Override
            public int compare(ThreeDTO lhs, ThreeDTO rhs) {
                return lhs.getSigungucode().compareTo(rhs.getSigungucode());
            }
        });
    }

    public void search(String a) {
        a = a.toUpperCase();
        int j = 0;
        if (threeList.size() == 50) {
            threeList2 = new ArrayList<>();
            for (int i = 0; i < threeList.size(); i++) {
                threeList2.add(threeList.get(i));
            }
        } else {
            for (int i = 0; i < threeList2.size(); i++) {
                threeList.add(threeList2.get(i));
            }
        }
        threeList.clear();
        for (int i = 0; i < threeList2.size(); i++) {
            ThreeDTO odto1 = threeList2.get(i);
            if (odto1.getTitle().toUpperCase().contains(a) || odto1.getAreacode().toUpperCase().contains(a) || odto1.getCat3().toUpperCase().contains(a) || odto1.getSigungucode().toUpperCase().contains(a)) {
                threeList.add(odto1);
                j++;
            } else if (a == null) {
                threeList.clear();
                threeList = threeList2;
            }
            if (j == 50) {
                threeList = threeList2;
            }
        }
        notifyDataSetChanged();
    }
}
