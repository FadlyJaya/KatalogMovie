package com.example.katalogmovie.fragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.katalogmovie.activity.TvShowActivity;
import com.example.katalogmovie.adapter.TvShowAdapter;
import com.example.katalogmovie.model.Movie;
import com.example.katalogmovie.R;
import com.example.katalogmovie.adapter.MovieAdapter;
import com.example.katalogmovie.model.TvShow;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowFragment extends Fragment {

    View view;
    private TypedArray dataPhoto;
    private String[] dataName, dataGenre, dataCreator, dataStart, dataOverview ;

    private RecyclerView recyclerView;
    private List<TvShow> tvShows;

    public TvShowFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tvshow, container, false);
        recyclerView = view.findViewById(R.id.rv_movie);
        TvShowAdapter tvShowAdapter = new TvShowAdapter(getContext(), tvShows);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(tvShowAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepare();
        addItem();

    }

    private void prepare() {
        dataPhoto = getResources().obtainTypedArray(R.array.img_tvshow);
        dataName = getResources().getStringArray(R.array.name_tvshow);
        dataGenre = getResources().getStringArray(R.array.genre_tvshow);
        dataCreator = getResources().getStringArray(R.array.creator_tvshow);
        dataStart = getResources().getStringArray(R.array.start_tvshow);
        dataOverview = getResources().getStringArray(R.array.overview_tvshow);
    }


    private void addItem() {
        tvShows = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            TvShow tvShow = new TvShow();
            tvShow.setPhoto(dataPhoto.getResourceId(i, -1));
            tvShow.setName(dataName[i]);
            tvShow.setGenre(dataGenre[i]);
            tvShow.setCreator(dataCreator[i]);
            tvShow.setStarts(dataStart[i]);
            tvShow.setOverview(dataOverview[i]);

            tvShows.add(tvShow);
        }
    }
}
