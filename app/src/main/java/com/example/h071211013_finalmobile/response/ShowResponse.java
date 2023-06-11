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

    @SerializedName("vote")
    private String vote;

    @SerializedName("rating")
    private String rate;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster")
    private String poster;

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
    public String getRate() {
        return rate;
    }
    public String getPoster() {
        return poster;
    }

    @SerializedName("data")
    private List<ShowResponse> data;

    public List<ShowResponse> getData() {
        return data;
    }

}
