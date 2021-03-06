package com.example.appmusic.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.api.MusicApi;
import com.example.appmusic.activities.Base;
import com.example.appmusic.activities.PlayMusicActivity;
import com.example.appmusic.models.AMusic;
import com.example.appmusic.models.Music;
import com.example.appmusic.R;
import com.example.appmusic.models.MusicOnDevice;
import com.example.appmusic.result.EResponse;

import java.util.HashSet;
import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder>{
    private Context context;
    private List<AMusic> songList;
    private int id;
    private String type_id;
    private int statusLike;
    public static AMusic musicStatic;

    public SongListAdapter(Context context, List<AMusic> songList, int id, String type_id) {
        this.context = context;
        this.songList = songList;
        this.id = id;
        this.type_id = type_id;
    }

    public void handlerMusicStatic() {
        musicStatic.setPlaylists(new HashSet<>(songList));
        for(AMusic music : musicStatic.getPlaylists()) {
            Log.v("Music", "test test test" + music.getName());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.song_list_item, viewGroup, false);
        return new ViewHolder(view, i);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        AMusic music = songList.get(i);
        statusLike = getStatusLikeByUsername(music);
        if(music.isType()) {
            holder.songSinger.setText(((Music) music).singersToString());
        } else {
            holder.songSinger.setText(((MusicOnDevice) music).getSinger());
        }
        holder.songName.setText(music.getName());
        holder.songIndex.setText(i + 1 + "");
        holder.songLike.setImageResource(statusLike == 1
                ? R.drawable.iconloved : R.drawable.iconlove);
        holder.viewStatusLike = statusLike;
    }

    public int getStatusLikeByUsername(AMusic music) {
        if(music.isType()) {
            Music newMusic = (Music) music;
            return newMusic.getUserByUsername(Base.username) != null ? 1 : 0;
        }

        return 0;
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView songIndex, songSinger, songName;
        ImageView songLike, songMyPlaylist;
        int viewStatusLike;
        ViewHolder(@NonNull View itemView, int i) {
            super(itemView);
            songIndex = itemView.findViewById(R.id.song_index);
            songSinger = itemView.findViewById(R.id.song_singer);
            songName = itemView.findViewById(R.id.song_name);
            songLike = itemView.findViewById(R.id.song_like);
            songMyPlaylist = itemView.findViewById(R.id.song_myPlayList);

            songLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Base.isLogged() && songList.get(Integer.parseInt(songIndex.getText().toString()) - 1).isType()) {
                        new EventHandlerLike(songLike, viewStatusLike).execute("/user/like", String.valueOf(songList
                                        .get(Integer.parseInt(songIndex.getText().toString()) - 1).getId()),
                                Base.token, String.valueOf(viewStatusLike));
                    } else {
                        Toast.makeText(context, EResponse.FAILED.toString(), Toast.LENGTH_LONG).show();
                    }

                }
            });

            songMyPlaylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    songMyPlaylist.setImageResource(R.drawable.iconsdoubletick);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    musicStatic = songList.get(Integer.parseInt(songIndex.getText().toString()) - 1);
                    musicStatic.setId(Integer.parseInt(songIndex.getText().toString()) - 1);
                    Base.musicStatic = musicStatic;
                    context.startActivity(intent);
                    handlerMusicStatic();
                }
            });
        }
    }

    public String[] listToStrings(List<AMusic> music) {
        String[] array = new String[music.size()];
        for(int i = 0; i< music.size(); i++) {
            if(music.get(i).isType()) {
                array[i] = ((Music) music.get(i)).convertToElementString();
            } else {
                array[i] = ((MusicOnDevice) music.get(i)).convertToElementString();
            }
        }
        return array;
    }

    private class EventHandlerLike extends AsyncTask<String, Void, String> {
        protected ProgressDialog dialog;
        protected ImageView songLike;
        protected int viewStatusLike;
        public EventHandlerLike(ImageView imageView, int viewStatusLike){
            this.songLike = imageView;
            this.viewStatusLike = viewStatusLike;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params) {
            try {
                return (String) MusicApi.handlerLikeMusic((String) params[0],(String) params[1], (String) params[2], Integer.parseInt(params[3]));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            if(viewStatusLike == 0) {
                songLike.setImageResource(R.drawable.iconloved);
                Toast.makeText(context, EResponse.SUCCESS.toString(), Toast.LENGTH_LONG).show();
            } else {
                songLike.setImageResource(R.drawable.iconlove);
                Toast.makeText(context, "UNLIKE" + EResponse.SUCCESS.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }
}
