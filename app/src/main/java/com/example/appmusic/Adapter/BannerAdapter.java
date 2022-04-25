package com.example.appmusic.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.appmusic.Model.Banner;
import com.example.appmusic.R;
import com.squareup.picasso.Picasso;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Banner> arrayListBanner;

    public BannerAdapter(Context context, ArrayList<Banner> arrayListBanner) {
        this.context = context;
        this.arrayListBanner = arrayListBanner;
    }


    @Override
    public int getCount() {
        return arrayListBanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);

        ImageView imageViewBackgroundBanner = view.findViewById(R.id.image_view_background_banner);
        ImageView imgViewBanner = view.findViewById(R.id.img_view_banner);
        TextView titleBannerSong = view.findViewById(R.id.title_banner_song);
        TextView textViewContent = view.findViewById(R.id.text_view_content);

//        Picasso.get().load(arrayListBanner.get(position).getImageAds()).error(R.drawable.ic_launcher_foreground).into(imageViewBackgroundBanner);
//        Picasso.get().load(arrayListBanner.get(position).getImageSong()).error(R.drawable.ic_launcher_foreground).into(imgViewBanner);


        imageViewBackgroundBanner.setImageResource(R.drawable.mot_phut_banner);

        imgViewBanner.setImageResource(R.drawable.suyt_nua_thi_banner);

        titleBannerSong.setText(arrayListBanner.get(position).getNameSong());
        textViewContent.setText(arrayListBanner.get(position).getContentAds());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
