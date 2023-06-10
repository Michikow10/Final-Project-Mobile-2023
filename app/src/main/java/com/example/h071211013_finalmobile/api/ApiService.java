package com.example.h071211013_finalmobile.api;

import com.example.h071211013_finalmobile.response.ShowResponse;
import com.example.h071211013_finalmobile.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")
    Call<ShowResponse> getPopularMovies(@Query("api_key") String api_key);

    @GET("tv/popular")
    Call<MovieResponse> getPopularShows(@Query("api_key") String api_key);

}
