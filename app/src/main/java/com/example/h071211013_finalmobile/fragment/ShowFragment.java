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

import com.example.h071211013_finalmobile.adapter.ShowAdapter;
import com.example.h071211013_finalmobile.api.ApiConfig;
import com.example.h071211013_finalmobile.response.MovieResponse;
import com.example.h071211013_finalmobile.R;
import com.example.h071211013_finalmobile.adapter.MovieAdapter;
import com.example.h071211013_finalmobile.response.ShowResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowFragment extends Fragment {

    private static List<ShowResponse> showResponseList;

    public ShowFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_show, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ProgressBar progressBar = view.findViewById(R.id.load);
        RecyclerView showRecyclerView = view.findViewById(R.id.rv_show);
        showRecyclerView.setHasFixedSize(true);
        showRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        ShowAdapter showAdapter = new ShowAdapter(showResponseList);

        showLoading();
        Call<ShowResponse> client = ApiConfig.getApiService().getShows(ApiConfig.getApiKey());
        client.enqueue(new Callback<ShowResponse>() {
            public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {
                if (response.isSuccessful()){
                    if (response != null) {
                        showResponseList = (List<ShowResponse>) response.body().getData();
                        ShowAdapter showAdapter = new ShowAdapter(showResponseList);
                        showRecyclerView.setAdapter(showAdapter);
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
            public void onFailure(Call<ShowResponse> call, Throwable t) {
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