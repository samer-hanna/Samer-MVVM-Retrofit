package com.example.retrofitmvvm.data;

import com.example.retrofitmvvm.pojo.PostModel;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface PostInterface {
   @Headers("Content-Type: application/json")
   @GET("jo/rss/topfreeapplications/limit=50/json?fbclid=IwAR1blQkByXbsZAbeWxU56qREUHJoZj-CqZ2R0IAQ3trZi3NlnxzzgYHt-2o")
   Call<PostModel> getData();
}
