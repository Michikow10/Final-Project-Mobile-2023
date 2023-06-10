package com.example.h071211013_finalmobile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataResponse {
    @SerializedName("data")
    private List<MovieResponse> data;

    public List<MovieResponse> getData() {
        return data;
    }
}
