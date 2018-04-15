package com.ntd.mvisample;

import com.ntd.mvisample.data.source.remote.api.MovieServiceClient;

/**
 * Created by ADMIN on 4/14/2018.
 */

public class Application extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        MovieServiceClient.initialize(this);
    }

}
