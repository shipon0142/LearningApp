package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.learningapp.model.User;
import com.example.learningapp.utils.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tabDots;
ViewPager pager;
public static User LOGGED_IN_USER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabDots=findViewById(R.id.tabDots);
        pager = (ViewPager) findViewById(R.id.pager);

        tabDots.setupWithViewPager(pager, true);

        tabDots.addTab(tabDots.newTab().setText("Tab1"));
        tabDots.addTab(tabDots.newTab().setText("Tab2"));
        tabDots.addTab(tabDots.newTab().setText("Tab3"));
        tabDots.setTabGravity(TabLayout.GRAVITY_FILL);

        ViewPagerAdapter adapter=new ViewPagerAdapter(this,getSupportFragmentManager(),tabDots.getTabCount());
        pager.setAdapter(adapter);
        for (int i = 0; i < tabDots.getTabCount(); i++) {
            TabLayout.Tab tab = tabDots.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
    }
}