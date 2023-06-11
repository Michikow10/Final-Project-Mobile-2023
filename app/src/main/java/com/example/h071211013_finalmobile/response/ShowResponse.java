package com.example.h071211013_finalmobile.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShowResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String title;

    @SerializedName("first_air_date")
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
    public String getPoster() {
        return poster;
    }
    public String getBackdrop() {
        return backdrop;
    }

    @SerializedName("results")
    private List<ShowResponse> results;

    public List<ShowResponse> getData() {
        return results;
    }

}
