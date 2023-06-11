package com.example.h071211013_finalmobile;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.h071211013_finalmobile.api.ApiConfig;
import com.example.h071211013_finalmobile.response.MovieResponse;
import com.example.h071211013_finalmobile.response.ShowResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailItemShow extends AppCompatActivity {
    private static List<ShowResponse> showResponseList;
    public static final String EXTRA_SHOW ="extra_show" ;
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
                Intent intent = new Intent(DetailItemShow.this,MainActivity.class);
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
            Call<ShowResponse> call = ApiConfig.getApiService().getShows(ApiConfig.getApiKey());
            call.enqueue(new Callback<ShowResponse>() {
                @Override
                public void onResponse(Call<ShowResponse> call, Response<ShowResponse> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(DetailItemShow.this, "test", Toast.LENGTH_SHORT).show();
                        if (response.body() != null) {
                            showResponseList = (List<ShowResponse>) response.body().getData();

                            String judul = getIntent().getStringExtra("judul");
                            String rating = getIntent().getStringExtra("rating");
                            String synopsis = getIntent().getStringExtra("synopsis");
                            String backdropPath = getIntent().getStringExtra("backdrop");
                            String poster = getIntent().getStringExtra("poster");
                            
                            sinopsis.setText(synopsis);

                            Glide.with(DetailItemShow.this)
                                    .load("https://image.tmdb.org/t/p/w500" + backdropPath)
                                    .into(backdrop);

                        }
                    } else {
                        Toast.makeText(DetailItemShow.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ShowResponse> call, Throwable t) {
                    Toast.makeText(DetailItemShow.this, "Unable to fetch data!", Toast.LENGTH_SHORT).show();
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

