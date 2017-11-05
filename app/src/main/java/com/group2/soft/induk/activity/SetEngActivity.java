package com.group2.soft.induk.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.group2.soft.induk.R;
import com.group2.soft.induk.adapter.FragmentAdapter;
import com.group2.soft.induk.adapter.OneAdapter;
import com.group2.soft.induk.adapter.ThreeAdapter;
import com.group2.soft.induk.adapter.TwoAdapter;
import com.group2.soft.induk.fragment.OneFragment_ENG;
import com.group2.soft.induk.fragment.ThreeFragment_ENG;
import com.group2.soft.induk.fragment.TwoFragment_ENG;

/**
 * Created by JHK on 16. 8. 22..
 */
public class SetEngActivity extends AppCompatActivity {
    private FragmentAdapter fragmentAdapater;
    private TabLayout tabMain;
    private ViewPager viewPager;
    private TextView main_title_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Tourist Attractions");
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(0xFF000000));

        //startActivity(new Intent(this, LoadingActivity.class));

        fragmentAdapater = new FragmentAdapter(getSupportFragmentManager(), SetEngActivity.this);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabMain = (TabLayout) findViewById(R.id.tab_main);

        TwoFragment_ENG twoFragment_eng = new TwoFragment_ENG();
        Bundle bundle = new Bundle();
        bundle.putString("lang", "EngService");
        twoFragment_eng.setArguments(bundle);

        fragmentAdapater.addFragment(new OneFragment_ENG());
        fragmentAdapater.addFragment(twoFragment_eng);
        fragmentAdapater.addFragment(new ThreeFragment_ENG());
        viewPager.setAdapter(fragmentAdapater);

        tabMain.setupWithViewPager(viewPager);

        tabMain.getTabAt(0).setIcon(R.drawable.travel);
        tabMain.getTabAt(1).setIcon(R.drawable.food);
        tabMain.getTabAt(2).setIcon(R.drawable.hotel);

        tabMain.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        tabMain.getTabAt(0).setIcon(R.drawable.travel);
//                        main_title_text.setText("관광지");
                        setTitle("Tourist Attractions");
                        break;
                    case 1:
                        tabMain.getTabAt(1).setIcon(R.drawable.food);
//                        main_title_text.setText("맛집");
                        setTitle("Dining");
                        break;
                    case 2:
                        tabMain.getTabAt(2).setIcon(R.drawable.hotel);
//                        main_title_text.setText("숙박시설");
                        setTitle("Accommodation");
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        tabMain.getTabAt(0).setIcon(R.drawable.travel);
//                        main_title_text.setText("관광지");
                        break;
                    case 1:
                        tabMain.getTabAt(1).setIcon(R.drawable.food);
//                        main_title_text.setText("맛집");
                        break;
                    case 2:
                        tabMain.getTabAt(2).setIcon(R.drawable.hotel);
//                        main_title_text.setText("숙박시설");
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item = menu.add(0, 1, 0, "sort by name");
        item.setIcon(R.mipmap.ic_launcher);
        menu.add(0, 2, 0, "sort by address").setIcon(R.drawable.ic_launcher);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (tabMain.getSelectedTabPosition() == 0) {//첫화면
            if (item.getItemId() == 1) {//주제
                OneFragment_ENG oneFragment = (OneFragment_ENG) fragmentAdapater.getItem(0);
                OneAdapter oneAdapter = oneFragment.getAdapter();
                oneAdapter.sortByTitle();
                oneAdapter.notifyDataSetChanged();
                return true;
            } else if (item.getItemId() == 2) {//주소
                OneFragment_ENG oneFragment = (OneFragment_ENG) fragmentAdapater.getItem(0);
                OneAdapter oneAdapter = oneFragment.getAdapter();
                oneAdapter.sortByAddr1();
                oneAdapter.notifyDataSetChanged();
            }
        } else if (tabMain.getSelectedTabPosition() == 1) {
            if (item.getItemId() == 1) {//주제
                TwoFragment_ENG twoFragment = (TwoFragment_ENG) fragmentAdapater.getItem(1);
                TwoAdapter twoAdapter = twoFragment.getAdapter();
                twoAdapter.sortByTitle();
                twoAdapter.notifyDataSetChanged();
                return true;
            } else if (item.getItemId() == 2) {//주소
                TwoFragment_ENG twoFragment = (TwoFragment_ENG) fragmentAdapater.getItem(1);
                TwoAdapter twoAdapter = twoFragment.getAdapter();
                twoAdapter.sortByAddr1();
                twoAdapter.notifyDataSetChanged();
            }
        } else if (tabMain.getSelectedTabPosition() == 2) {
            if (item.getItemId() == 1) {//주제
                ThreeFragment_ENG threeFragment = (ThreeFragment_ENG) fragmentAdapater.getItem(2);
                ThreeAdapter threeAdapter = threeFragment.getAdapter();
                threeAdapter.sortByTitle();
                threeAdapter.notifyDataSetChanged();
                return true;
            } else if (item.getItemId() == 2) {//주소
                ThreeFragment_ENG threeFragment = (ThreeFragment_ENG) fragmentAdapater.getItem(2);
                ThreeAdapter threeAdapter = threeFragment.getAdapter();
                threeAdapter.sortByAddr1();
                threeAdapter.notifyDataSetChanged();
            }
        }
        return false;
    }
}
