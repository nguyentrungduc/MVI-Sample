package com.ntd.mvisample.data.source.remote.api;

import android.app.Application;
import android.support.annotation.NonNull;

/**
 * Created by ADMIN on 4/14/2018.
 */

public class MovieServiceClient extends ServerClient{
    private static MovieApi mMovieApiInstance;

    public static void initialize(@NonNull Application application) {
        mMovieApiInstance = createService(application,
                "https://api.themoviedb.org/3/", MovieApi.class);
    }

    public static MovieApi getInstance() {
        if (mMovieApiInstance == null) {
            throw new RuntimeException("Need call method NameServiceClient#initialize() first");
        }
        return mMovieApiInstance;
    }
}
