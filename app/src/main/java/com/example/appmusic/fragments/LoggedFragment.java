package com.example.appmusic.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.appmusic.api.MusicApi;
import com.example.appmusic.activities.Base;
import com.example.appmusic.models.User;
import com.example.appmusic.R;

public class LoggedFragment extends Fragment {

    Button logged;
    TextView logged_name;
    TextView logged_email;
    TextView favourite;
    TextView onDevice;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logged, container, false);

        logged = view.findViewById(R.id.logged);
        logged_name  = view.findViewById(R.id.logged_name);
        logged_email = view.findViewById(R.id.logged_email);
        favourite = view.findViewById(R.id.logged_favourite);
        onDevice = view.findViewById(R.id.logged_on_device);

        logged.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Base.token = null;
                LoginFragment nextFrag= new LoginFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_user, nextFrag)
                        .commit();
            }
        });

        new GetTask().execute("/login/user-by-token", Base.token);

        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FavouriteFragment nextFrag= new FavouriteFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_user, nextFrag)
                        .commit();
            }
        });

        onDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnDeviceFragment nextFrag= new OnDeviceFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.layout_user, nextFrag)
                        .commit();
            }
        });

        return view;
    }

    private class GetTask extends AsyncTask<String, Void, User> {
        public GetTask(){
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected User doInBackground(String... params) {
            try {
                return (User) MusicApi.getUserByToken((String) params[0], (String) params[1]);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(User result) {
            super.onPostExecute(result);

            logged_name.setText(result.getName());
            logged_email.setText(result.getEmail());
        }
    }
}
