package com.codingblocks.shivank.musicretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class OnlineMediaAdapter
        extends RecyclerView.Adapter<OnlineMediaAdapter.OnlineMediaViewHolder> {

    public static final String TAG = "OnlineMediaAdapter";

    private Context context;
    private ArrayList<Tracks> tracksArrayList;

    public OnlineMediaAdapter(Context context, ArrayList<Tracks> tracksArrayList) {
        Log.d(TAG, "OnlineMediaAdapter: ");
        this.context = context;
        this.tracksArrayList = tracksArrayList;
    }

    public void updateTracks(ArrayList<Tracks> newArrayList) {
        Log.d(TAG, "updateTracks: " + newArrayList.size());
        Log.d(TAG, "updateTracks: " + tracksArrayList.size());
        this.tracksArrayList = newArrayList;
        notifyDataSetChanged();
    }

    @Override
    public OnlineMediaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater li =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_online_tracks, parent, false);

        return new OnlineMediaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OnlineMediaViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Tracks thisTrack = tracksArrayList.get(position);
        holder.tvName.setText(thisTrack.tracks1ArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + tracksArrayList.size());
        return tracksArrayList.size();

    }

    class OnlineMediaViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        View thisView;

        public OnlineMediaViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "OnlineMediaViewHolder: ");
            thisView = itemView;
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
