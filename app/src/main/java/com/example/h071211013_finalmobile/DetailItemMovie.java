package com.example.h071211013_finalmobile;

import static com.example.h071211013_finalmobile.DetailItemShow.KEY_SHOW;

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
    public static final String KEY_MOVIE ="extra_movie" ;
    ImageView backdrop, btnback, btnfav, poster, icon;
    TextView judul, tanggal, rating, sinopsis;

    private MovieResponse movieResponse;

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

        movieResponse = getIntent().getParcelableExtra(KEY_MOVIE);


        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + backdrop)
                .into(backdrop);
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + poster)
                .into(poster);

        judul.setText(movieResponse.getTitle());
        tanggal.setText(movieResponse.getDate());
        rating.setText(String.valueOf(movieResponse.getVote()));
        sinopsis.setText(movieResponse.getOverview());

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailItemMovie.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    
}
