package com.example.h071211013_finalmobile.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.h071211013_finalmobile.api.ApiConfig;
import com.example.h071211013_finalmobile.response.MovieResponse;
import com.example.h071211013_finalmobile.R;
import com.example.h071211013_finalmobile.adapter.MovieAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieFragment extends Fragment {
    private static List<MovieResponse> movieResponseList;

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
            filmRecyclerView.setHasFixedSize(true);
            filmRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        MovieAdapter movieAdapter = new MovieAdapter(movieResponseList);

        showLoading();
        Call<MovieResponse> client = ApiConfig.getApiService().getMovies(ApiConfig.getApiKey());
        client.enqueue(new Callback<MovieResponse>() {
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()){
                    if (response != null) {
                        movieResponseList = (List<MovieResponse>) response.body().getData();
                        MovieAdapter movieAdapter = new MovieAdapter(movieResponseList);
                        filmRecyclerView.setAdapter(movieAdapter);
                        progressBar.setVisibility(View.GONE);
                                hideLoading();
                    }
                }else{
                    if(response.body() !=null){
                        Log.e("Main Activity", "onFailure: "+ response.message());
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                showAlert();
            }

        });
    }

    private void hideLoading() {

    }

    private void showAlert() {

    }

    private void showLoading() {

    }
}