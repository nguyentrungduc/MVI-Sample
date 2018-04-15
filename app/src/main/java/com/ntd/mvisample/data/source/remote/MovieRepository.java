package com.ntd.mvisample.data.source.remote;

import com.ntd.mvisample.data.model.ListMovie;

import io.reactivex.Observable;

/**
 * Created by ADMIN on 4/14/2018.
 */

public class MovieRepository {
    private MovieDataSource.MovieRemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieDataSource.MovieRemoteDataSource movieRemoteDataSource) {{}
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    public Observable<ListMovie> searchPopulerMovie(String key, String language, String page) {
        return mMovieRemoteDataSource.searchPopularMovie(key, language, page);
    }
}
