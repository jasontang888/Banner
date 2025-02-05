package com.test.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ms.bottombar.PageNavigationView;
import com.test.LazyFragment;
import com.test.R;

import java.util.ArrayList;

public class SimpleFragmentActivity extends AppCompatActivity {

    private String[] mTitles = {"首页", "更多"};
    private ArrayList<LazyFragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ViewPager viewPager = findViewById(R.id.vp);
        PageNavigationView bottomTabLayout = findViewById(R.id.tab);
        PageNavigationView.MaterialBuilder material = bottomTabLayout.material();
        for (String title : mTitles) {
            material.addItem(android.R.drawable.ic_menu_more, title);
        }
        material.build().setupWithViewPager(viewPager);

        mFragments.add(new HomeFragment());
        mFragments.add(new MoreFragment());

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
