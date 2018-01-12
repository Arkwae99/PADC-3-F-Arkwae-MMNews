package com.padcmyanmar.mmnews.network;

import com.google.gson.Gson;
import com.padcmyanmar.mmnews.events.LoadedNewsEvent;
import com.padcmyanmar.mmnews.network.responses.GetNewsResponse;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ag Phone Khant on 6/1/2018.
 */

public class RetrofitDataAgent implements NewsDataAgent {
    /** Singleton Pattern*/
    private static RetrofitDataAgent sObjectInstance;
    private NewsApi nNewsApi;
    private RetrofitDataAgent(){
        OkHttpClient httpClient = new OkHttpClient.Builder() //1.
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()//2
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .build();
         nNewsApi = retrofit.create(NewsApi.class);

    }
    public static RetrofitDataAgent getsObjectInstance(){
        if(sObjectInstance == null){
            sObjectInstance = new RetrofitDataAgent();
        }
        return sObjectInstance;
    }
    /**Singleton Pattern */

    @Override
    public void loadNews() {
        Call<GetNewsResponse> getNewsResponseCall = nNewsApi.getNews(1,"b002c7e1a528b7cb460933fc2875e916");
        getNewsResponseCall.enqueue(new Callback<GetNewsResponse>() {
            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {
                GetNewsResponse getNewsResponse = response.body();
                if (getNewsResponse!=null){
                    LoadedNewsEvent event = new LoadedNewsEvent(getNewsResponse.getMmNews());
                    EventBus.getDefault().post(event);
                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {

            }
        });


    }
}
