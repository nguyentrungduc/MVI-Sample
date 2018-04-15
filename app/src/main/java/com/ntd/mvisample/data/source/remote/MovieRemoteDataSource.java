package com.ntd.mvisample.data.source.remote;

import com.ntd.mvisample.data.model.ListMovie;
import com.ntd.mvisample.data.source.remote.api.MovieApi;

import io.reactivex.Observable;

/**
 * Created by ADMIN on 4/14/2018.
 */

public class MovieRemoteDataSource extends BaseRemoteDataSource implements MovieDataSource.MovieRemoteDataSource {
    public MovieRemoteDataSource(MovieApi movieApi) {
        super(movieApi);
    }

    @Override
    public Observable<ListMovie> searchPopularMovie(String key, final String language, String page) {
        return mMovieApi.getPopularMovie(key, language, page);
    }
}
