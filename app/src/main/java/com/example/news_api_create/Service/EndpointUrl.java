package com.example.news_api_create.Service;

import com.example.news_api_create.Model.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointUrl {


    @GET("wp-news/wp-json/wp/v2/posts")
    Call<List<Response>> getPosts();
}
