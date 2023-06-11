package com.example.h071211013_finalmobile.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("release_date")
    private String date;

    @SerializedName("vote_average")
    private String vote;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String poster;

    @SerializedName("backdrop_path")
    private String backdrop;


    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDate() {
        return date;
    }
    public String getVote() {
        return vote;
    }
    public String getOverview() {
        return overview;
    }
    public String getPoster() {
        return poster;
    }
    public String getBackdrop() {
        return backdrop;
    }

    @SerializedName("results")
    private List<MovieResponse> results;

    public List<MovieResponse> getData() {
        return results;
    }
}

