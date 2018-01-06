package com.padcmyanmar.mmnews.network;

import com.padcmyanmar.mmnews.network.responses.GetNewsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Ag Phone Khant on 6/1/2018.
 */

public interface NewsApi {
    @FormUrlEncoded
    @POST("getMMNews.php")
    Call<GetNewsResponse> getNews(@Field("page") int page,
                                  @Field("access_token") String accessToken);
}
