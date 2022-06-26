package com.example.appmusic.activities;

import android.os.Bundle;

import androidx.viewpager2.widget.ViewPager2;
import com.example.appmusic.adapters.MainViewPagerAdapter;
import com.example.appmusic.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends Base {
    TabLayout tabLayout;
    ViewPager2 viewPager;
    MainViewPagerAdapter mainViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout  = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPaper);

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(),getLifecycle(), this);

//        mainViewPagerAdapter.FragmentAdd(new HomeFragment(),"Home");
//        mainViewPagerAdapter.FragmentAdd(new SearchFragment(),"Search");

        viewPager.setAdapter(mainViewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setIcon(R.drawable.icontrangchu);
                    tab.setText("Home");
                    break;
                case 1:
                    tab.setIcon(R.drawable.icontimkiem);
                    tab.setText("Search");
                    break;
                case 2:
                    tab.setIcon(R.drawable.iconuser);
                    tab.setText("Login");
                    break;
            }
        }).attach();
    }

}