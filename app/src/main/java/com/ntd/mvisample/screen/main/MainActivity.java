package com.ntd.mvisample.screen.main;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hannesdorfmann.mosby3.mvi.MviActivity;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView;
import com.ntd.mvisample.R;
import com.ntd.mvisample.data.source.remote.MovieRemoteDataSource;
import com.ntd.mvisample.data.source.remote.MovieRepository;
import com.ntd.mvisample.data.source.remote.api.MovieServiceClient;

import io.reactivex.Observable;

public class MainActivity extends MviActivity<MovieView, MovieProcesser> implements MovieView {

    private RecyclerView mRecyclerView;
    private MovieAdapter mAdapter;
    private View mLoadingView;
    private LinearLayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    @NonNull
    @Override
    public MovieProcesser createPresenter() {
        return new MovieProcesser(new MovieRepository(
                new MovieRemoteDataSource(MovieServiceClient.getInstance())));
    }

    private void initView() {
        mLayoutManager = new LinearLayoutManager(this);
        mLoadingView = findViewById(R.id.loadingView);
        mAdapter = new MovieAdapter(this);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public Observable<Boolean> loadFirstPageIntent() {
        return RxRecyclerView.scrollStateChanges(mRecyclerView)
                .filter(event -> !mAdapter.isLoadingNextPage())
                .filter(event -> event == RecyclerView.SCROLL_STATE_IDLE)
                .filter(event -> mLayoutManager.findFirstCompletelyVisibleItemPosition()
                        == mAdapter.getData().size() - 1)
                .map(integer -> true);
    }

    @Override
    public Observable<Boolean> loadNextPageIntent() {
        return null;
    }

    @Override
    public void render(MovieViewState viewState) {
        if (!viewState.isLoadingFirstPage() && viewState.getFirstPageError() == null) {
            renderShowData(viewState);
        } else if (viewState.isLoadingFirstPage()) {
            renderFirstPageLoading();
        } else if (viewState.getFirstPageError() != null) {
            renderFirstPageError();
        } else {
            throw new IllegalStateException("Unknown view state " + viewState);
        }
    }

    private void renderShowData(MovieViewState state) {
        mLoadingView.setVisibility(View.GONE);
       // errorView.setVisibility(View.GONE);
        boolean changed = mAdapter.setLoadingNextPage(state.isLoadingNextPage());
        if (changed && state.isLoadingNextPage()) {
            // scroll to the end of the list so that the user sees the load more progress bar
            mRecyclerView.smoothScrollToPosition(mAdapter.getItemCount());
        }
        mAdapter.setData(state.getData()); // TODO error: this must be done before setLoading() otherwise error will occure. see https://github.com/sockeqwe/mosby/issues/244

        if (state.getNextPageError() != null) {
            Snackbar.make(mRecyclerView, "Error", Snackbar.LENGTH_LONG)
                    .show(); // TODO callback
        }
    }

    private void renderFirstPageLoading() {
        mLoadingView.setVisibility(View.VISIBLE);
        //errorView.setVisibility(View.GONE);
    }

    private void renderFirstPageError() {
//        TransitionManager.beginDelayedTransition((ViewGroup) getView());
        mLoadingView.setVisibility(View.GONE);
//        swipeRefreshLayout.setVisibility(View.GONE);
//        errorView.setVisibility(View.VISIBLE);
    }
}
