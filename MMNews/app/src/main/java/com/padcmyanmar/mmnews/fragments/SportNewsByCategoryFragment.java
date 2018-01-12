package com.padcmyanmar.mmnews.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.mmnews.R;
import com.padcmyanmar.mmnews.adapters.SportNewsAdapter;
import com.padcmyanmar.mmnews.viewholders.ItemSportNewsViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ag Phone Khant on 7/1/2018.
 */

public class SportNewsByCategoryFragment extends Fragment {
    @BindView(R.id.rv_sport_news)
    RecyclerView rvSportNews;

    SportNewsAdapter mSportNewsAdapter = new SportNewsAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sport_news,container,false);
        ButterKnife.bind(this,view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL,false);
        rvSportNews.setLayoutManager(linearLayoutManager);
        rvSportNews.setAdapter(mSportNewsAdapter);

        return view;
    }


}
