package com.example.appmusic.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.appmusic.Adapter.SongListAdapter;
import com.example.appmusic.Model.Song;
import com.example.appmusic.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {
    private int id;
    private CoordinatorLayout coordinatorLayout;
    private CollapsingToolbarLayout collapsingtoolbarLayout;
    private RecyclerView recyclerviewSongList;
    private ArrayList<Song> songList = new ArrayList<>();
    private String name;
    private SongListAdapter songListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);
        collapsingtoolbarLayout = findViewById(R.id.collapsing_toolbar);
        recyclerviewSongList = findViewById(R.id.recyclerView_SongList);
        getDataIntent();


        collapsingtoolbarLayout.setBackgroundResource(R.drawable.mot_phut_banner);

        songListAdapter = new SongListAdapter(this,songList);
        recyclerviewSongList.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewSongList.setAdapter(songListAdapter);

    }

    public void getDataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("Banner")) {
                id = intent.getIntExtra("Banner", 0);
                // Truy Vấn DB với id
                name = "1 Phút";
                songList.add(new Song(1, "1 Phut", "abc","Andiez"));
                songList.add(new Song(2, "Suyt nua thi", "abc","Andiez"));

            }
            else if (intent.hasExtra("Popular")) {
                id = intent.getIntExtra("Popular", 0);
                name = "Baroque";
                songList.add(new Song(1, "spring waltz", "abc","Chopin"));
                songList.add(new Song(2, "Requiem", "abc","Mozart"));
            }else if (intent.hasExtra("Album")) {
                id = intent.getIntExtra("Album", 0);
                name = "sai người sai thời điểm";
                songList.add(new Song(1, "sai người sai thời điểm", "abc","Thanh Hưng"));
                songList.add(new Song(2, "đúng người sai thời điểm", "abc","Thanh Hưng"));
                songList.add(new Song(3, "đúng người đúng thời điểm", "abc","Thanh Hưng"));

            }
        }
    }
}