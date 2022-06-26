package com.example.appmusic.fragments;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.appmusic.R;
import com.example.appmusic.notification.CreateNotification;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;


public class PlayBarFragment extends Fragment {

    View view;
    CircleImageView circleImageView;
    ObjectAnimator objectAnimator;
    ImageButton btnPreview, btnPlay, btnNext;
    TextView songName;
    boolean isPlaying = false;
    long playTime = 0;
    String img;



    public PlayBarFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_bar, container, false);

        init();

        return view;
    }

    private void init() {
        circleImageView = view.findViewById(R.id.img_dianhac);
//        playMusic(img);
        objectAnimator = ObjectAnimator.ofFloat(circleImageView, "rotation", 0f, 360f);
        objectAnimator.setDuration(20000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setInterpolator(new LinearInterpolator());

        btnPreview = view.findViewById(R.id.btn_preview);
        btnPlay = view.findViewById((R.id.btn_play));
        btnNext = view.findViewById((R.id.btn_next));
        songName = view.findViewById((R.id.song_name));

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying){
                    btnPlay.setImageResource(R.drawable.iconplay);
                    isPlaying = !isPlaying;
                    stopDisc();
                    songName.setText("Khong co");
                } else {
                    btnPlay.setImageResource(R.drawable.ic_pause_white);
                    isPlaying = !isPlaying;
                    startDisc();
                    songName.setText("Dang chay");
                }
            }
        });
    }

    public void playMusic(String img) {
        try {
            new LoadImageURL(circleImageView).execute(img);
        } catch (Exception e) {
            circleImageView.setImageResource(R.drawable.iconfloatingactionbutton);
        };

    }

    public void stopDisc() {
        playTime = objectAnimator.getCurrentPlayTime();
        objectAnimator.cancel();
    }

    public void startDisc() {
        objectAnimator.setCurrentPlayTime(playTime);
        objectAnimator.start();

    }

    private class LoadImageURL extends AsyncTask<String, Void, Bitmap> {
        CircleImageView imageView;

        public LoadImageURL(CircleImageView rs) {
            this.imageView = rs;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new URL(strings[0]).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }


}