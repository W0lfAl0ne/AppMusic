package com.example.appmusic.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appmusic.Adapter.BannerAdapter;
import com.example.appmusic.Model.Banner;
import com.example.appmusic.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;


public class BannerFragment extends Fragment {

    ArrayList<Banner> banners = new ArrayList<>();
    BannerAdapter bannerAdapter;
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;

    Runnable runnable;
    Handler handler;
    int currentItem;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner, container, false);
        viewPager = view.findViewById(R.id.view_pager);
        circleIndicator = view.findViewById(R.id.indicator_banner);
        getData();
        return view;
    }

    private void getData() {
        Banner banner = new Banner();
        banner.setIdAds("1");
        banner.setImageAds("");
        banner.setContentAds("1 phut abc");
        banner.setIdSong("1");
        banner.setNameSong("1 Phút");
        banner.setImageSong("drawable/mot_phut_img.png");
        banners.add(banner);

        Banner banner2 = new Banner();
        banner2.setIdAds("2");
        banner2.setImageAds("drawable/suyt_nua_thi_img.png");
        banner2.setContentAds("Suyt nua thi abc");
        banner2.setIdSong("2");
        banner2.setNameSong("suyt nua thi");
        banner2.setImageSong("drawable/suyt_nua_thi_banner.png");
        banners.add(banner2);

        Banner banner3 = new Banner();
        banner3.setIdAds("3");
        banner3.setImageAds("");
        banner3.setContentAds("chac vi minh chua tot abc");
        banner3.setIdSong("3");
        banner3.setNameSong("chac vi minh chua tot");
        banner3.setImageSong("");
        banners.add(banner3);

        bannerAdapter = new BannerAdapter(getActivity(),banners);
        viewPager.setAdapter(bannerAdapter);
        circleIndicator.setViewPager(viewPager);
        handler = new Handler();
        runnable = () -> {
            currentItem = viewPager.getCurrentItem();
            currentItem++;
            if (currentItem>= viewPager.getAdapter().getCount()){
                currentItem = 0;
            }
            viewPager.setCurrentItem(currentItem, true);
            handler.postDelayed(runnable,4500);
        };
        handler.postDelayed(runnable,4500);
    }
}