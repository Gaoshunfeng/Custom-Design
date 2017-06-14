package com.example.vivi.custom_design;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class Tablayoutuse extends AppCompatActivity {
    private SimpleFragmentPagerAdapter pagerAdapter;

    private ViewPager viewPager;
    private SwipeRefreshLayout refresh;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);
        refresh= (SwipeRefreshLayout) findViewById(R.id.refresh);
        pagerAdapter=new SimpleFragmentPagerAdapter(getSupportFragmentManager(),this);
        viewPager = (ViewPager) findViewById(R.id.viewpage);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(pagerAdapter.getTabView(i));
        }
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler myhandle=new Handler();
                myhandle.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh.setRefreshing(false);
                    }
                }, 1000);
            }
        });

    }


}
