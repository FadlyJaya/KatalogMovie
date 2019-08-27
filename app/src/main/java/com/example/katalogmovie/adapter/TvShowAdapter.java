package com.example.katalogmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.katalogmovie.R;
import com.example.katalogmovie.activity.TvShowActivity;
import com.example.katalogmovie.model.TvShow;

import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder> {

    private Context context;
    private List<TvShow> tvShows;

    public TvShowAdapter(Context context, List<TvShow> tvShows) {
        this.context = context;
        this.tvShows = tvShows;
    }

    private List<TvShow> getTvShows(){
        return tvShows;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_tvshow, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final TvShow tvShow = getTvShows().get(i);
        viewHolder.imageView.setImageResource(tvShow.getPhoto());
        viewHolder.nameTvs.setText(tvShow.getName());
        viewHolder.genreTvs.setText(tvShow.getGenre());
        viewHolder.overviewTvs.setText(tvShow.getOverview());

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TvShowActivity.class);
                intent.putExtra("TVSHOWS", tvShows.get(i));

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView nameTvs, genreTvs, overviewTvs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.relative);
            imageView = itemView.findViewById(R.id.img_photo);
            nameTvs = itemView.findViewById(R.id.tv_name);
            genreTvs = itemView.findViewById(R.id.tv_genre);
            overviewTvs = itemView.findViewById(R.id.tv_overview);
        }
    }
}
