package com.padcmyanmar.mmnews.data.models;

import android.util.Log;

import com.padcmyanmar.mmnews.MMNewsApp;
import com.padcmyanmar.mmnews.data.vo.NewsVO;
import com.padcmyanmar.mmnews.events.LoadedNewsEvent;
import com.padcmyanmar.mmnews.network.HttpUrlConnectionDataAgent;
import com.padcmyanmar.mmnews.network.NewsDataAgent;
import com.padcmyanmar.mmnews.network.OkHttpDataAgent;
import com.padcmyanmar.mmnews.network.RetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Ag Phone Khant on 23/12/2017.
 */

public class NewsModel {

    private static NewsModel sObjectInstance;
    private NewsDataAgent mDataAgent;
    private Map<String , NewsVO>mNews;

    private NewsModel(){
//        mDataAgent = HttpUrlConnectionDataAgent.getsObjectInstance();
//        mDataAgent = OkHttpDataAgent.getsObjectInstance();
        mDataAgent= RetrofitDataAgent.getsObjectInstance();
        mNews = new HashMap<>();

        EventBus.getDefault().register(this);
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

    /**
     * Get news object by id.
     * @param newsId
     * @return
     */
    public NewsVO getNewsById(String newsId){
        return mNews.get(newsId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onNewsLoaded(LoadedNewsEvent event){
        for (NewsVO news : event.getNewsList()){
            mNews.put(news.getNewsId() , news);
        }
    }

}
