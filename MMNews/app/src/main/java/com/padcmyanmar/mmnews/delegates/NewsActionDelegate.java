package com.padcmyanmar.mmnews.delegates;

import com.padcmyanmar.mmnews.data.vo.NewsVO;

/**
 * Created by Ag Phone Khant on 17/12/2017.
 */

public interface NewsActionDelegate {

     void onTapNewsItem(NewsVO tappedNews);
     void onTapCommentButton();
     void onTapSendToButton();
     void onTapFavouriteButton();
}
