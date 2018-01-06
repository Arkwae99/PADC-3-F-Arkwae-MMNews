package com.padcmyanmar.mmnews.events;

import com.padcmyanmar.mmnews.data.vo.NewsVO;

import java.util.List;

/**
 * Created by Ag Phone Khant on 24/12/2017.
 */

public class LoadedNewsEvent {
    private List<NewsVO> newsList;

    public List<NewsVO> getNewsList() {
        return newsList;
    }

    public LoadedNewsEvent(List<NewsVO> newsList) {
        this.newsList = newsList;

    }
}
