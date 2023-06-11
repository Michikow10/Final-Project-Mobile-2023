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
    public static final String KEY_SHOW ="key_show" ;
    ImageView backdrop, btnback, btnfav, poster, icon;
    TextView judul, tanggal, rating, sinopsis;

    private ShowResponse showResponse;

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

        showResponse = getIntent().getParcelableExtra(KEY_SHOW);

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + backdrop)
                .into(backdrop);
        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + poster)
                .into(poster);

        judul.setText(showResponse.getTitle());
        tanggal.setText(showResponse.getDate());
        rating.setText(String.valueOf(showResponse.getVote()));
        sinopsis.setText(showResponse.getOverview());

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailItemShow.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

