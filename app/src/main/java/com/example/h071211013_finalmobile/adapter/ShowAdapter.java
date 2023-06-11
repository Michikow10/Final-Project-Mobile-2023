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
import com.example.h071211013_finalmobile.DetailItemShow;
import com.example.h071211013_finalmobile.R;
import com.example.h071211013_finalmobile.response.MovieResponse;
import com.example.h071211013_finalmobile.response.ShowResponse;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder>{
    Context context;
    private List<ShowResponse> showResponseList;
    public ShowAdapter(List<ShowResponse> showResponseList) {
        this.context = context;
        this.showResponseList = showResponseList;
    }
    @NonNull
    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_show, parent, false);
        return new ShowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        ShowResponse showResponse = showResponseList.get(position);

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + showResponse.getPoster())
                .into(holder.poster);
        holder.judul.setText(showResponse.getTitle());
        holder.tahun.setText(showResponse.getDate().substring(0, 4));

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, DetailItemShow.class);
            intent.putExtra(DetailItemShow.KEY_SHOW, (Parcelable) showResponse);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return showResponseList.size();
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
