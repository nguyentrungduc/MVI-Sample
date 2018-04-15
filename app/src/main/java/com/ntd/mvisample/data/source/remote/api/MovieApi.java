package com.ntd.mvisample.data.source.remote.api;

import com.ntd.mvisample.data.model.ListMovie;
import com.ntd.mvisample.data.model.Movie;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ADMIN on 4/14/2018.
 */

public interface MovieApi {
    @GET("movie/popular")
    Observable<ListMovie> getPopularMovie(@Query("api_key") String api_key,
                                          @Query("language") String language, @Query("page") String page);
}
