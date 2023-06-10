package com.example.h071211013_finalmobile.api;

import com.example.h071211013_finalmobile.DataResponse;
import com.example.h071211013_finalmobile.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("users")
    Call<DataResponse> getUser(@Query("per_page") String per_page);

    @GET("users/{id}")
    Call<MovieResponse> getSingleUser(@Path("id") int id);
}
