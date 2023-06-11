package com.example.h071211013_finalmobile.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.h071211013_finalmobile.response.MovieResponse;
import com.example.h071211013_finalmobile.R;
import com.example.h071211013_finalmobile.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {
    private static List<MovieResponse> movieResponseArrayList;

    public MovieFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProgressBar progressBar = view.findViewById(R.id.load);
        RecyclerView filmRecyclerView = view.findViewById(R.id.rv_film);

    }
}