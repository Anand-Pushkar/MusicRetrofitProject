package com.codingblocks.shivank.musicretrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;


public interface OnlineTracksAPI {
    @Headers({
            "format: json",
            "app_key: b4c19a3f036101f9b77249513310a2f9"
    })
    @GET("2.0/?method=track.search&track=Believe&&format=json")
    Call<ArrayList<Tracks>> getTracks();
}
