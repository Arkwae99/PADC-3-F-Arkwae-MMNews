package com.padcmyanmar.mmnews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;


import com.padcmyanmar.mmnews.adapters.NewsByCategoryAdapter;
import com.padcmyanmar.mmnews.data.models.NewsModel;
import com.padcmyanmar.mmnews.events.LoadedNewsEvent;
import com.padcmyanmar.mmnews.fragments.InternationalNewsByCategoryFragment;
import com.padcmyanmar.mmnews.fragments.NewsByCategoryFragment;
import com.padcmyanmar.mmnews.fragments.SportNewsByCategoryFragment;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ag Phone Khant on 7/1/2018.
 */

public class NewsByCategoryActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_by_category)
    ViewPager vpNewsByCategory;

    @BindView(R.id.tb_news_by_category)
    TabLayout tbNewsByCategory;

    private NewsByCategoryAdapter mNewsByCategoryAdapter;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NewsByCategoryActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_by_category);
        ButterKnife.bind(this, this);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_news_by_category);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mNewsByCategoryAdapter = new NewsByCategoryAdapter(getSupportFragmentManager());
        vpNewsByCategory.setAdapter(mNewsByCategoryAdapter);
        mNewsByCategoryAdapter.addTab("Local News", new NewsByCategoryFragment());
        mNewsByCategoryAdapter.addTab("International News", new InternationalNewsByCategoryFragment());
        mNewsByCategoryAdapter.addTab("Sport News", new SportNewsByCategoryFragment());
        tbNewsByCategory.setupWithViewPager(vpNewsByCategory);
        vpNewsByCategory.setOffscreenPageLimit(mNewsByCategoryAdapter.getCount());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
