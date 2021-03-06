package com.example.appmusic.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusic.R;
import com.example.appmusic.adapters.SongListAdapter;
import com.example.appmusic.models.AMusic;
import com.example.appmusic.models.Music;
import com.example.appmusic.models.MusicOnDevice;

import java.util.ArrayList;
import java.util.List;

public class OnDeviceFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    List<Music> music;
    private SongListAdapter songListAdapter;
    Context context;
    ImageButton btnBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_on_device, container, false);
        recyclerView = view.findViewById(R.id.device_recycler);
        context = getActivity();
        btnBack = view.findViewById(R.id.device_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoggedFragment nextFrag= new LoggedFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_user, nextFrag)
                        .commit();
            }
        });

        songListAdapter = new SongListAdapter(context, getAllMusicInFolder(), 0, null);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(songListAdapter);

        return view;
    }

    public List<AMusic> getAllMusicInFolder() {
        MusicOnDevice musicOne = new MusicOnDevice(1, "B???n kh??ng hi???u t??i",
                R.raw.bankhonghieutoi, 216, R.drawable.bankhonghieutoi, "Ho??ng V??n S??ng");
        MusicOnDevice musicTwo = new MusicOnDevice(2, "V??? tuy???t v???i nh???t",
                R.raw.votuyetvoinhat, 334, R.drawable.votuyetvoinhat, "V?? Duy Kh??nh");
        MusicOnDevice musicThree = new MusicOnDevice(3, "C?? anh ??? ????y r???i",
                R.raw.coanhodayroi, 291, R.drawable.coanhodayroi, "Anh Qu??n Idol");
        List<AMusic> aMusics = new ArrayList<>();
        aMusics.add(musicOne);
        aMusics.add(musicTwo);
        aMusics.add(musicThree);

        return aMusics;
    }

}
