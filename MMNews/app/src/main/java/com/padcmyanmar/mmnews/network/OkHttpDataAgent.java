package com.padcmyanmar.mmnews.network;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.padcmyanmar.mmnews.MMNewsApp;
import com.padcmyanmar.mmnews.events.LoadedNewsEvent;
import com.padcmyanmar.mmnews.network.responses.GetNewsResponse;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Ag Phone Khant on 6/1/2018.
 */

public class OkHttpDataAgent implements NewsDataAgent {

    /** Singleton Pattern*/
    private static OkHttpDataAgent sObjectInstance;
    private OkHttpDataAgent(){

    }
    public static OkHttpDataAgent getsObjectInstance(){
        if(sObjectInstance == null){
            sObjectInstance = new OkHttpDataAgent();
        }
        return sObjectInstance;
    }
    /**Singleton Pattern */

    @Override
    public void loadNews() {
        new LoadsNewsTask().execute("http://padcmyanmar.com/padc-3/mm-news/apis/v1/getMMNews.php");
    }

    private static class LoadsNewsTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... urls) {
            String url=urls[0];
            OkHttpClient httpClient = new OkHttpClient.Builder() //1.
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .build();

            RequestBody formBody = new FormBody.Builder() //2.
                    .add("access_token", "b002c7e1a528b7cb460933fc2875e916")
                    .add("page", "1")
                    .build();

            Request request = new Request.Builder() //3
                    .url(url)
                    .post(formBody)
                    .build();
            try {
                Response response = httpClient.newCall(request).execute(); //4.
                if (response.isSuccessful() && response.body() != null) {
                    String responseString = response.body().string();
                    return responseString;
                }
            } catch (IOException e) {
                Log.e(MMNewsApp.LOG_TAG, e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(String response) {
            super.onPostExecute(response);
            Gson gson = new Gson();
            gson.fromJson(response, GetNewsResponse.class);
            GetNewsResponse getNewsResponse =gson.fromJson(response,GetNewsResponse.class);
            LoadedNewsEvent event = new LoadedNewsEvent(getNewsResponse.getMmNews());
            EventBus eventBus = EventBus.getDefault();
            eventBus.post(event);
        }
    }
}
