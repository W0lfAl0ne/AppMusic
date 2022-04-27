package com.example.appmusic.Fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appmusic.Activity.SongListActivity;
import com.example.appmusic.Model.Popular;
import com.example.appmusic.R;

import java.util.ArrayList;

public class PopularFragment extends Fragment {
    View view;
    HorizontalScrollView horizontalScrollView;
    TextView popular_more;
    ArrayList<Popular> populars = new ArrayList<>();



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_popular, container, false);
        horizontalScrollView = view.findViewById(R.id.horizontal_Scroll_View);
        popular_more = view.findViewById(R.id.popular_more);
        getData();

        return view;
    }

    private void getData(){
        Popular popular = new Popular();
        popular.setId(1);
        popular.setName("classic");
        popular.setImage("bf");
        popular.setContent("abc");
        populars.add(popular);

        Popular popular1 = new Popular();
        popular1.setId(2);
        popular1.setName("baroque");
        popular1.setImage("bf");
        popular1.setContent("abc");
        populars.add(popular1);

        Popular popular2 = new Popular();
        popular2.setId(3);
        popular2.setName("v-pop");
        popular2.setImage("bf");
        popular2.setContent("abc");
        populars.add(popular2);

        LinearLayout linearLayout = new LinearLayout(getActivity());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(650,450);
        layout.setMargins(10,20,10,30);
        for (int i = 0; i < populars.size(); ++i){
            CardView cardView = new CardView(getActivity());
            cardView.setRadius(10);

            ImageView imageView = new ImageView(getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.drawable.suyt_nua_thi_banner);
            TextView textView = new TextView(getContext());
            textView.setText(populars.get(i).getName());
            textView.setTextSize(30);
            textView.setTypeface(Typeface.SERIF, Typeface.BOLD);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(getResources().getColor(R.color.popular_text));


            cardView.setLayoutParams(layout);

            cardView.addView(imageView);
            cardView.addView(textView);

            int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                Toast.makeText(context,"da click vao banner " + arrayListBanner.get(position).getNameSong(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), SongListActivity.class);
                    intent.putExtra("Popular", populars.get(finalI).getId());
                    startActivity(intent);
                }
            });

            linearLayout.addView(cardView);
        }
        horizontalScrollView.addView(linearLayout);

    }
}