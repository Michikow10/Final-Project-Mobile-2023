package com.example.h071211013_finalmobile.api;

import com.example.h071211013_finalmobile.response.ShowResponse;
import com.example.h071211013_finalmobile.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular?")
    Call<MovieResponse> getMovies();

    @GET("tv/popular?")
    Call<ShowResponse> getShows(@Query("api_key") String api_key);

}
