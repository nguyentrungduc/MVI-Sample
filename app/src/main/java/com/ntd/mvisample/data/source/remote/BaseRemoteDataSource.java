package com.ntd.mvisample.data.source.remote;

import com.ntd.mvisample.data.source.remote.api.MovieApi;

/**
 * Created by ADMIN on 4/14/2018.
 */

public class BaseRemoteDataSource {
    MovieApi mMovieApi;

    public BaseRemoteDataSource(MovieApi movieApi) {
        mMovieApi = movieApi;
    }
}
