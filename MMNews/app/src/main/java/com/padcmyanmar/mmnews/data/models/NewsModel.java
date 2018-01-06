package com.padcmyanmar.mmnews.data.models;

import com.padcmyanmar.mmnews.network.HttpUrlConnectionDataAgent;
import com.padcmyanmar.mmnews.network.NewsDataAgent;
import com.padcmyanmar.mmnews.network.OkHttpDataAgent;
import com.padcmyanmar.mmnews.network.RetrofitDataAgent;

/**
 * Created by Ag Phone Khant on 23/12/2017.
 */

public class NewsModel {

    private static NewsModel sObjectInstance;
    private NewsDataAgent mDataAgent;

    private NewsModel(){
//        mDataAgent = HttpUrlConnectionDataAgent.getsObjectInstance();
//        mDataAgent = OkHttpDataAgent.getsObjectInstance();
        mDataAgent= RetrofitDataAgent.getsObjectInstance();
    }

    public static NewsModel getsObjectInstance(){
        if(sObjectInstance == null){
            sObjectInstance = new NewsModel();
        }
        return sObjectInstance;
    }

    /**
     * load news from network api.
     */
    public void loadNews() {
        mDataAgent.loadNews();
    }

}
