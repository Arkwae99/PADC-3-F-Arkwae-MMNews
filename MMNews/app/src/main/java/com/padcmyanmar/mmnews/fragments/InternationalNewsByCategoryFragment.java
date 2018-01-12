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
import com.padcmyanmar.mmnews.adapters.InternationalNewsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ag Phone Khant on 7/1/2018.
 */

public class InternationalNewsByCategoryFragment extends Fragment{
    @BindView(R.id.rv_international_news)
    RecyclerView rvInternationalNews;

    InternationalNewsAdapter mInternationalNewsAdapter = new InternationalNewsAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_international_news,container,false);
        ButterKnife.bind(this,view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        rvInternationalNews.setLayoutManager(linearLayoutManager);
        rvInternationalNews.setAdapter(mInternationalNewsAdapter);


        return view;
    }
}
