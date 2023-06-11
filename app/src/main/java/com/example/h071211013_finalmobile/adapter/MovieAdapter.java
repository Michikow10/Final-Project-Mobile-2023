package com.example.h071211013_finalmobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.h071211013_finalmobile.DetailItemMovie;
import com.example.h071211013_finalmobile.response.MovieResponse;
import com.example.h071211013_finalmobile.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    Context context;
    private List<MovieResponse> movieResponseList;

    public MovieAdapter(List<MovieResponse> movieResponseList) {
        this.context = context;
        this.movieResponseList = movieResponseList;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_show, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        MovieResponse movieResponse = movieResponseList.get(position);

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + movieResponse.getPoster())
                .into(holder.poster);
        holder.judul.setText(movieResponse.getTitle());
        holder.tahun.setText(movieResponse.getDate().substring(0, 4));

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailItemMovie.class);
            intent.putExtra(DetailItemMovie.KEY_MOVIE, (Parcelable) movieResponse);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieResponseList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView judul, tahun;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.iv_poster);
            judul = itemView.findViewById(R.id.tv_judul);
            tahun = itemView.findViewById(R.id.tv_tahun);
        }

    }
}
