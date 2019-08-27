package com.example.katalogmovie.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.katalogmovie.R;
import com.example.katalogmovie.model.TvShow;

public class TvShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_show);

        Intent intent = getIntent();
        TvShow tvShow = intent.getParcelableExtra("TVSHOWS");

        int photo = tvShow.getPhoto();
        String name = tvShow.getName();
        String genre = tvShow.getGenre();
        String creator = tvShow.getCreator();
        String stars = tvShow.getStarts();
        String overview = tvShow.getOverview();

        ImageView imageView = findViewById(R.id.img_photo);
        imageView.setImageResource(photo);
        TextView tvName = findViewById(R.id.tv_name);
        tvName.setText(name);
        TextView tvGenre = findViewById(R.id.tv_genre);
        tvGenre.setText(genre);
        TextView tvCreator = findViewById(R.id.tv_creator);
        tvCreator.setText(creator);
        TextView tvStars = findViewById(R.id.tv_stars);
        tvStars.setText(stars);
        TextView tvOverview = findViewById(R.id.tv_overview);
        tvOverview.setText(overview);
    }
}
