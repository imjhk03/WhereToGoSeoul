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
import com.group2.soft.induk.model.TwoDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by JHK on 16. 8. 18..
 */
public class TwoAdapter extends BaseAdapter {
    private ArrayList<TwoDTO> twoList = new ArrayList<TwoDTO>();
    ArrayList<TwoDTO> twoList2 = new ArrayList<>();

    @Override
    public int getCount() {
        return twoList.size();
    }

    @Override
    public Object getItem(int position) {
        return twoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        TwoDTO tdto = twoList.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_two, parent, false);
        }

        ImageView imageFirstImage2 = (ImageView) convertView.findViewById(R.id.two_image_firstimage2);
        TextView textTitle = (TextView) convertView.findViewById(R.id.two_text_title);
        TextView textCat3 = (TextView) convertView.findViewById(R.id.two_text_cat3);
        TextView textAreaCode = (TextView) convertView.findViewById(R.id.two_text_areacode);
        TextView textSigunguCode = (TextView) convertView.findViewById(R.id.two_text_sigungucode);

        Paint alpha = new Paint();
        imageFirstImage2.setAlpha(90);

        textTitle.setText(tdto.getTitle());
        if (tdto.getFirstimage2() == null) {
            Glide.with((Activity) context)
                    .load(R.drawable.no_image)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(imageFirstImage2);
        } else {
            Glide.with((Activity) context)
                    .load(tdto.getFirstimage2())
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
                    .into(imageFirstImage2);
        }
        textCat3.setText(tdto.getCat3());
        textAreaCode.setText(tdto.getAreacode());
        textSigunguCode.setText(" " + tdto.getSigungucode());

        return convertView;
    }

    //twoAdapter.addItem(areacode, cat3, contentid, firstimage2, sigungucode, title);
    public void addItem(String[] areacode, String[] cat3, String[] contentid, String[] firstimage2, String[] sigungucode, String[] title, String[] addr1) {
        twoList.clear();
        for (int i = 0; i < title.length; i++) {
            TwoDTO tdto = new TwoDTO();
            tdto.setAreacode(areacode[i]);
            tdto.setTitle(title[i]);
            tdto.setContentid(contentid[i]);
            tdto.setFirstimage2(firstimage2[i]);
            tdto.setCat3(cat3[i]);
            tdto.setSigungucode(sigungucode[i]);
            tdto.setAddr1(addr1[i]);
            twoList.add(tdto);
        }
        System.out.println("size2 : " + twoList.size());
    }

    public void sortByTitle() {
        Collections.sort(twoList, new Comparator<TwoDTO>() {
            @Override
            public int compare(TwoDTO lhs, TwoDTO rhs) {
                return lhs.getTitle().compareTo(rhs.getTitle());
            }
        });
    }

    public void sortByAddr1() {
        Collections.sort(twoList, new Comparator<TwoDTO>() {
            @Override
            public int compare(TwoDTO lhs, TwoDTO rhs) {
                return lhs.getSigungucode().compareTo(rhs.getSigungucode());
            }
        });
    }

    public void search(String a) {
        a = a.toUpperCase();
        int j = 0;
        if (twoList.size() == 50) {
            twoList2 = new ArrayList<>();
            for (int i = 0; i < twoList.size(); i++) {
                twoList2.add(twoList.get(i));
            }
        } else {
            for (int i = 0; i < twoList2.size(); i++) {
                twoList.add(twoList2.get(i));
            }
        }
        twoList.clear();
        for (int i = 0; i < twoList2.size(); i++) {
            TwoDTO odto1 = twoList2.get(i);
            if (odto1.getTitle().toUpperCase().contains(a) || odto1.getAreacode().toUpperCase().contains(a) || odto1.getSigungucode().toUpperCase().contains(a) || odto1.getCat3().toUpperCase().contains(a)) {
                twoList.add(odto1);
                j++;
            } else if (a == null) {
                twoList.clear();
                twoList = twoList2;
            }
            if (j == 50) {
                twoList = twoList2;
            }
        }
        notifyDataSetChanged();
    }
}
