package com.padcmyanmar.mmnews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.mmnews.adapters.ImagesInNewsDetailsAdapter;
import com.padcmyanmar.mmnews.data.models.NewsModel;
import com.padcmyanmar.mmnews.data.vo.NewsVO;

import net.aungpyaephyo.mmtextview.components.MMTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ag Phone Khant on 10/12/2017.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetailsImages;

    @BindView(R.id.tv_news)
    MMTextView tvNews;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetailsAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this,this);
//        tsetSupportActionBar(toolbar);
//        AcionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowTitleEnabled(false);
        mImagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter();
        vpNewsDetailsImages.setAdapter(mImagesInNewsDetailsAdapter);

        String newsId= getIntent().getStringExtra("news_id");
        NewsVO news= NewsModel.getsObjectInstance().getNewsById(newsId);
        bindData(news);
    }

    private void bindData(NewsVO news){
        tvNews.setText(news.getDetails());
        tvPublicationTitle.setText(news.getPublication().getTitle());
        tvPostedDate.setText(news.getPostedDate());

        Glide.with(ivPublicationLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivPublicationLogo);

    }
}

