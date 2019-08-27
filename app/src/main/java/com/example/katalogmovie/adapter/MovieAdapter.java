package com.example.katalogmovie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.katalogmovie.model.Movie;
import com.example.katalogmovie.R;
import com.example.katalogmovie.activity.MovieActivity;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    private List<Movie> getMovies(){
        return movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
       final Movie movie = getMovies().get(i);
       viewHolder.imgMovie.setImageResource(movie.getPhoto());
       viewHolder.textName.setText(movie.getNama());
       viewHolder.textGenre.setText(movie.getGenre());
       viewHolder.textDurasi.setText(movie.getDurasi());

       viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context, MovieActivity.class);
               intent.putExtra("MOVIES", movies.get(i));

               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        ImageView imgMovie;
        TextView textName, textGenre, textDurasi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout = itemView.findViewById(R.id.relative);
            imgMovie = itemView.findViewById(R.id.img_photo);
            textName = itemView.findViewById(R.id.tv_name);
            textGenre = itemView.findViewById(R.id.tv_genre);
            textDurasi = itemView.findViewById(R.id.tv_durasi);
        }
    }
}
