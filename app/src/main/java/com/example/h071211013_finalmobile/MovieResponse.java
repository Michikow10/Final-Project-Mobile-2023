package com.example.h071211013_finalmobile;

import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("date")
    private String date;

    @SerializedName("year")
    private String year;

    @SerializedName("rating")
    private String rate;

    @SerializedName("avatar")
    private String avatarUrl;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDate() {
        return date;
    }
    public String getYear() {
        return year;
    }
    public String getRate() {
        return rate;
    }
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @SerializedName("data")
    private MovieResponse data;

    public MovieResponse getData() {
        return data;
    }
}

