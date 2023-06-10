package com.example.h071211013_finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.h071211013_finalmobile.api.ApiConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailItem extends AppCompatActivity {
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

    }

}