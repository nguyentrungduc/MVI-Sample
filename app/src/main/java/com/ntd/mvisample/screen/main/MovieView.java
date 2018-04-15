package com.ntd.mvisample.screen.main;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import io.reactivex.Observable;

/**
 * Created by ADMIN on 4/15/2018.
 */

public interface MovieView extends MvpView {
    Observable<Boolean> loadFirstPageIntent();

    Observable<Boolean> loadNextPageIntent();

    void render(MovieViewState viewState);
}
