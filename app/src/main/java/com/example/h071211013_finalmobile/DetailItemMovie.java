package com.example.h071211013_finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.h071211013_finalmobile.api.ApiConfig;
import com.example.h071211013_finalmobile.response.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailItemMovie extends AppCompatActivity {
    private static List<MovieResponse> movieResponseList;
    public static final String EXTRA_MOVIE ="extra_movie" ;
    ImageView backdrop, btnback, btnfav, poster, icon;
    TextView judul, tanggal, rating, sinopsis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        backdrop = findViewById(R.id.iv_backdrop);
        btnback = findViewById(R.id.btn_back);
        btnfav = findViewById(R.id.btn_fav);
        judul = findViewById(R.id.tv_judul);
        tanggal = findViewById(R.id.tv_tanggal);
        rating = findViewById(R.id.tv_rating);
        sinopsis = findViewById(R.id.tv_sinopsis);
        poster = findViewById(R.id.iv_poster);
        icon = findViewById(R.id.iv_icon);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailItemMovie.this,MainActivity.class);
                startActivity(intent);
            }
        });
        getDataApi();
    }

    private void getDataApi() {
        if (isNetworkAvailable()) {
            Intent intent = getIntent();
            String movieId = intent.getStringExtra("movie_id");
            Toast.makeText(this, movieId, Toast.LENGTH_SHORT).show();
            Call<MovieResponse> call = ApiConfig.getApiService().getMovies(ApiConfig.getApiKey());
            call.enqueue(new Callback<MovieResponse>() {
                @Override
                public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(DetailItemMovie.this, "test", Toast.LENGTH_SHORT).show();
                        if (response.body() != null) {
                            movieResponseList = (List<MovieResponse>) response.body().getData();
                            
                            String judul = getIntent().getStringExtra("judul");
                            String rating = getIntent().getStringExtra("rating");
                            String synopsis = getIntent().getStringExtra("synopsis");
                            String backdropPath = getIntent().getStringExtra("backdrop");
                            String poster = getIntent().getStringExtra("poster");

                            sinopsis.setText(synopsis);

                            Glide.with(DetailItemMovie.this)
                                    .load("https://image.tmdb.org/t/p/w500" + backdropPath)
                                    .into(backdrop);
                        }
                    } else {
                        Toast.makeText(DetailItemMovie.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<MovieResponse> call, Throwable t) {
                    Toast.makeText(DetailItemMovie.this, "Unable to fetch data!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
