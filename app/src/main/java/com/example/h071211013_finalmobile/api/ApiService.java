package com.example.h071211013_finalmobile.api;

import com.example.h071211013_finalmobile.DataResponse;
import com.example.h071211013_finalmobile.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("movie/popular")
    Call<DataResponse> getPopularMovies(@Query("api_key") String api_key);

    @GET("tv/popular")
    Call<MovieResponse> getPopularShows(@Query("api_key") String api_key);

}
