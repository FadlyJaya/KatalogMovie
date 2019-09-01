package com.example.katalogmovie.fragment;


import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.katalogmovie.model.Movie;
import com.example.katalogmovie.R;
import com.example.katalogmovie.adapter.MovieAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    View view;
    private TypedArray dataPhoto;
    private String[] dataName, dataGenre, dataDurasi, dataProduser, dataSutradara, dataPenulis, dataProduksi, dataSinopsis;

    private RecyclerView recyclerView;
    private List<Movie> movies ;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = view.findViewById(R.id.rv_movie);
        MovieAdapter movieAdapter = new MovieAdapter(getContext(), movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(movieAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepare();
        addItem();

    }

    private void prepare() {
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        dataName = getResources().getStringArray(R.array.data_movie);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataDurasi = getResources().getStringArray(R.array.data_durasi);
        dataProduser = getResources().getStringArray(R.array.data_produser);
        dataSutradara = getResources().getStringArray(R.array.data_sutradara);
        dataPenulis = getResources().getStringArray(R.array.data_penulis);
        dataProduksi = getResources().getStringArray(R.array.data_produksi);
        dataSinopsis = getResources().getStringArray(R.array.data_sinopsis);
    }


    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setNama(dataName[i]);
            movie.setGenre(dataGenre[i]);
            movie.setDurasi(dataDurasi[i]);
            movie.setProduser(dataProduser[i]);
            movie.setSutradara(dataSutradara[i]);
            movie.setPenulis(dataPenulis[i]);
            movie.setProduksi(dataProduksi[i]);
            movie.setSinopsis(dataSinopsis[i]);
            movies.add(movie);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
