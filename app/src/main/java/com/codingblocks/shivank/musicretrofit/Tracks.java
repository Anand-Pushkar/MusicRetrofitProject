package com.codingblocks.shivank.musicretrofit;

import android.util.Log;

import java.util.ArrayList;


public class Tracks {

    ArrayList<Tracks1> tracks1ArrayList;

    public Tracks(ArrayList<Tracks1> tracks1ArrayList) {
        this.tracks1ArrayList = tracks1ArrayList;
    }

    public ArrayList<Tracks1> getTracks1ArrayList() {
        return tracks1ArrayList;
    }

    public void setTracks1ArrayList(ArrayList<Tracks1> tracks1ArrayList) {
        this.tracks1ArrayList = tracks1ArrayList;
    }

    class Tracks1 {
        public static final String TAG = "Tracks class";
        private String name;
        private String artist;
        private String url;

        public Tracks1(String name, String artist, String url) {
            Log.d(TAG, "Tracks: ");
            this.name = name;
            this.artist = artist;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getArtist() {
            return artist;
        }

        public void setArtist(String artist) {
            this.artist = artist;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}