package com.ntd.mvisample.screen.main;

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;
import com.ntd.mvisample.data.model.Movie;
import com.ntd.mvisample.data.source.remote.MovieRepository;

/**
 * Created by ADMIN on 4/15/2018.
 */

public class MovieProcesser extends MviBasePresenter<MovieView, MovieViewState> {
    private MovieRepository mMovieRepository;

    public MovieProcesser(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
    }
    @Override
    protected void bindIntents() {

    }
}
