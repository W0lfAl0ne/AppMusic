package com.example.appmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.Model.Album;
import com.example.appmusic.Model.Popular;
import com.example.appmusic.R;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<Album> albums;


    public AlbumAdapter (Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.album_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albums.get(position);
        holder.albumSinger.setText(album.getSinger());
        holder.albumName.setText(album.getName());
        holder.albumImage.setImageResource(R.drawable.suyt_nua_thi_banner);
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView albumImage;
        TextView albumName, albumSinger;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumImage = itemView.findViewById(R.id.album_image);
            albumName = itemView.findViewById(R.id.album_name);
            albumSinger = itemView.findViewById(R.id.album_singer);
        }
    }

    public void getData() {
        Album album = new Album();
        album.setId("1");
        album.setName("classic");
        album.setImage("bf");
        album.setContent("abc");
        albums.add(album);

        Album album1 = new Album();
        album1.setId("2");
        album1.setName("baroque");
        album1.setImage("bf");
        album1.setContent("abc");
        albums.add(album1);

        Album album2 = new Album();
        album2.setId("2");
        album2.setName("v-pop");
        album2.setImage("bf");
        album2.setContent("abc");
        albums.add(album2);
    }
}
