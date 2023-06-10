package com.example.h071211013_finalmobile.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.h071211013_finalmobile.DetailItem;
import com.example.h071211013_finalmobile.MovieResponse;
import com.example.h071211013_finalmobile.R;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder>{
    private List<MovieResponse> data;
    @NonNull
    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_show, parent, false);
        return new ShowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ViewHolder holder, int position) {
        MovieResponse movieResponse = data.get(position);
        holder.setData(movieResponse);
    }

    @Override
    public int getItemCount() {
        return data.size();
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

        public void setData(MovieResponse movieResponse) {
            judul.setText(movieResponse.getTitle());
            tahun.setText(movieResponse.getDate());
            Glide.with(itemView.getContext())
                    .load(movieResponse.getAvatarUrl()).into(poster);

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), DetailItem.class);
                intent.putExtra(DetailItem.EXTRA_MOVIE,movieResponse.getId());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
