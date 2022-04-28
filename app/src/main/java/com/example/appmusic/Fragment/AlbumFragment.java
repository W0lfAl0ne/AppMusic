package com.example.appmusic.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appmusic.Adapter.AlbumAdapter;
import com.example.appmusic.Model.Album;
import com.example.appmusic.R;

import java.util.ArrayList;

public class AlbumFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    TextView albumMore;
    ArrayList<Album> albums = new ArrayList<>();
    AlbumAdapter albumAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album, container, false);
        recyclerView = view.findViewById(R.id.recyclerView_album);
        albumMore = view.findViewById(R.id.album_more);
        getData();

        albumAdapter = new AlbumAdapter(getActivity(), albums);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(albumAdapter);
        return view;
    }

    public void getData() {
        Album album = new Album();
        album.setId(1);
        album.setName("chỉ là không cùng nhau");
        album.setSinger("Tăng Phúc");
        album.setImage("bf");
        album.setContent("abc");
        albums.add(album);

        Album album1 = new Album();
        album1.setId(2);
        album1.setName("Lạ Lùng");
        album1.setSinger("Vũ");
        album1.setImage("bf");
        album1.setContent("abc");
        albums.add(album1);

        Album album2 = new Album();
        album2.setId(3);
        album2.setName("Sai Người Sai Thời Điểm");
        album2.setSinger("Thanh Hưng");
        album2.setImage("bf");
        album2.setContent("abc");
        albums.add(album2);

    }
}