package com.ntd.mvisample.data.source.remote;

import com.ntd.mvisample.data.model.ListMovie;
import com.ntd.mvisample.data.model.Movie;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ADMIN on 4/14/2018.
 */

public interface MovieDataSource {
    interface MovieRemoteDataSource {
        Observable<ListMovie> searchPopularMovie(String key, String language, String page);
    }
}


