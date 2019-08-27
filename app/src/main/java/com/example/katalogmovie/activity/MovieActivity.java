package com.example.katalogmovie.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.katalogmovie.model.Movie;
import com.example.katalogmovie.R;

public class MovieActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra("MOVIES");

        int photo = movie.getPhoto();
        String name = movie.getNama();
        String genre = movie.getGenre();
        String durasi = movie.getDurasi();
        String produser = movie.getProduser();
        String sutradara = movie.getSutradara();
        String penulis = movie.getPenulis();
        String produksi = movie.getProduksi();
        String sinopsis = movie.getSinopsis();

        ImageView imageView = findViewById(R.id.img_photo);
        imageView.setImageResource(photo);
        TextView textName = findViewById(R.id.tv_name);
        textName.setText(name);
        TextView textGenre = findViewById(R.id.tv_genre);
        textGenre.setText(genre);
        TextView textDurasi = findViewById(R.id.tv_durasi);
        textDurasi.setText(durasi);
        TextView textProduser = findViewById(R.id.tv_produser);
        textProduser.setText(produser);
        TextView textSutradara = findViewById(R.id.tv_sutradara);
        textSutradara.setText(sutradara);
        TextView textPenulis = findViewById(R.id.tv_penulis);
        textPenulis.setText(penulis);
        TextView textProduksi = findViewById(R.id.tv_produksi);
        textProduksi.setText(produksi);
        TextView textSinopsis = findViewById(R.id.tv_sinopsis);
        textSinopsis.setText(sinopsis);
    }
}
