package com.codingblocks.shivank.musicretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    RecyclerView rvTracks;
    OnlineMediaAdapter onlineMediaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: before set adapter");
        rvTracks = (RecyclerView) findViewById(R.id.rvTracks);
        rvTracks.setLayoutManager(new LinearLayoutManager(this));
        onlineMediaAdapter = new OnlineMediaAdapter(this, new ArrayList<Tracks>());
        rvTracks.setAdapter(onlineMediaAdapter);
        Log.d(TAG, "onCreate: After set adapter");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/")
                .addConverterFactory(
                        GsonConverterFactory.create()
                ).build();

        OnlineTracksAPI onlineTracksAPI = retrofit.create(OnlineTracksAPI.class);
        onlineTracksAPI.getTracks().enqueue(new Callback<ArrayList<Tracks>>() {
            @Override
            public void onResponse(Call<ArrayList<Tracks>> call, Response<ArrayList<Tracks>> response) {
                Log.d(TAG, "onResponse: " + response.body());
                onlineMediaAdapter.updateTracks(response.body().get);
            }

            @Override
            public void onFailure(Call<ArrayList<Tracks>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: ");
            }

        }
        );

    }
}
