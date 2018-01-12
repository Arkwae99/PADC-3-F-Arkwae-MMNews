package com.padcmyanmar.mmnews.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.mmnews.R;
import com.padcmyanmar.mmnews.viewholders.ItemSportNewsViewHolder;

/**
 * Created by Ag Phone Khant on 12/1/2018.
 */

public class SportNewsAdapter extends RecyclerView.Adapter{
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View sportNewsView = inflater.inflate(R.layout.item_sport_news,parent,false);
        ItemSportNewsViewHolder itemSportNewsViewHolder= new ItemSportNewsViewHolder(sportNewsView);
        return itemSportNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
