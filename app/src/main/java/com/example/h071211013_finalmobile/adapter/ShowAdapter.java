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
import com.example.h071211013_finalmobile.response.MovieResponse;
import com.example.h071211013_finalmobile.R;
import com.example.h071211013_finalmobile.response.ShowResponse;

import java.util.List;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder>{
    private List<ShowResponse> data;
    @NonNull
    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_show, parent, false);
        return new ShowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAdapter.ViewHolder holder, int position) {
        ShowResponse showResponse = data.get(position);
        holder.setData(showResponse);
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

        public void setData(ShowResponse showResponse) {
            judul.setText(showResponse.getTitle());
            tahun.setText(showResponse.getDate());
            Glide.with(itemView.getContext())
                    .load(showResponse.getPoster()).into(poster);

            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(itemView.getContext(), DetailItem.class);
                intent.putExtra(DetailItem.EXTRA_MOVIE,showResponse.getId());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
