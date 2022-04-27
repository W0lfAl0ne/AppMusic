package com.example.appmusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.appmusic.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class SongListActivity extends AppCompatActivity {
    private int id;
    private CoordinatorLayout coordinatorLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView songList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        toolbar = findViewById(R.id.toolbar_list);
        songList = findViewById(R.id.recyclerView_SongList);
        getData();
    }

    public void getData() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("Banner")) {
                id = intent.getIntExtra("Banner", 0);
                Toast.makeText(this,"da click vao Banner " + id, Toast.LENGTH_SHORT).show();
            }
            else if (intent.hasExtra("Popular")) {
                id = intent.getIntExtra("Popular", 0);
                Toast.makeText(this,"da click vao Popular " + id, Toast.LENGTH_SHORT).show();
            }
        }
    }
}