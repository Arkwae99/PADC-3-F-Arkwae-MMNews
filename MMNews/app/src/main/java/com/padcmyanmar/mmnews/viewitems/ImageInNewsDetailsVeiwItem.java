package com.padcmyanmar.mmnews.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.mmnews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ag Phone Khant on 10/12/2017.
 */

public class ImageInNewsDetailsVeiwItem extends FrameLayout{
    @BindView(R.id.iv_news_details_image)
    ImageView ivNewsDetailImage;

    public ImageInNewsDetailsVeiwItem(@NonNull Context context) {
        super(context);
    }

    public ImageInNewsDetailsVeiwItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageInNewsDetailsVeiwItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }
    public void setData(String imageUrl){
        Glide.with(ivNewsDetailImage.getContext())
                .load(imageUrl)
                .into(ivNewsDetailImage);

    }
}
