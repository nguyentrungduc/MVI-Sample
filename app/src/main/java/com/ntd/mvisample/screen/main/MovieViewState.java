package com.ntd.mvisample.screen.main;

import com.ntd.mvisample.data.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ADMIN on 4/15/2018.
 */

public class MovieViewState {
    private final boolean loadingFirstPage;
    private final Throwable firstPageError;
    private final List<Movie> data;
    private final boolean loadingNextPage;
    private final Throwable nextPageError;
    private final boolean loadingPullToRefresh;
    private final Throwable pullToRefreshError;

    private MovieViewState(List<Movie> data, boolean loadingFirstPage, Throwable firstPageError,
                          boolean loadingNextPage, Throwable nextPageError, boolean loadingPullToRefresh,
                          Throwable pullToRefreshError) {
        this.data = data;
        this.loadingNextPage = loadingNextPage;
        this.nextPageError = nextPageError;
        this.loadingPullToRefresh = loadingPullToRefresh;
        this.pullToRefreshError = pullToRefreshError;
        this.firstPageError = firstPageError;
        this.loadingFirstPage = loadingFirstPage;
    }

    public List<Movie> getData() {
        return data;
    }

    public boolean isLoadingNextPage() {
        return loadingNextPage;
    }

    public Throwable getNextPageError() {
        return nextPageError;
    }

    public boolean isLoadingPullToRefresh() {
        return loadingPullToRefresh;
    }

    public Throwable getPullToRefreshError() {
        return pullToRefreshError;
    }

    public boolean isLoadingFirstPage() {
        return loadingFirstPage;
    }

    public Throwable getFirstPageError() {
        return firstPageError;
    }

    public Builder builder() {
        return new Builder(this);
    }

    @Override public String toString() {
        return "HomeViewState{"
                + "\nloadingFirstPage="
                + loadingFirstPage
                + ",\n firstPageError="
                + firstPageError
                + ",\n data="
                + data
                + ",\n loadingNextPage="
                + loadingNextPage
                + ",\n nextPageError="
                + nextPageError
                + ",\n loadingPullToRefresh="
                + loadingPullToRefresh
                + ",\n pullToRefreshError="
                + pullToRefreshError
                + "\n}";
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieViewState that = (MovieViewState) o;

        if (loadingFirstPage != that.loadingFirstPage) return false;
        if (loadingNextPage != that.loadingNextPage) return false;
        if (loadingPullToRefresh != that.loadingPullToRefresh) return false;

        if (firstPageError != null ? !firstPageError.getClass().equals(that.firstPageError.getClass())
                : that.firstPageError != null) {
            return false;
        }
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (nextPageError != null ? !nextPageError.getClass().equals(that.nextPageError.getClass())
                : that.nextPageError != null) {
            return false;
        }
        return pullToRefreshError != null ? pullToRefreshError.getClass()
                .equals(that.pullToRefreshError.getClass()) : that.pullToRefreshError == null;
    }

    @Override public int hashCode() {
        int result = (loadingFirstPage ? 1 : 0);
        result = 31 * result + (firstPageError != null ? firstPageError.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (loadingNextPage ? 1 : 0);
        result = 31 * result + (nextPageError != null ? nextPageError.hashCode() : 0);
        result = 31 * result + (loadingPullToRefresh ? 1 : 0);
        result = 31 * result + (pullToRefreshError != null ? pullToRefreshError.hashCode() : 0);
        return result;
    }

    public static final class Builder {
        private boolean loadingFirstPage;
        private Throwable firstPageError;
        private List<Movie> data;
        private boolean loadingNextPage;
        private Throwable nextPageError;
        private boolean loadingPullToRefresh;
        private Throwable pullToRefreshError;

        public Builder() {
            data = Collections.emptyList();
        }

        public Builder(MovieViewState toCopyFrom) {
            this.data = new ArrayList<>(toCopyFrom.getData().size());
            this.data.addAll(toCopyFrom.getData());
            this.loadingFirstPage = toCopyFrom.isLoadingFirstPage();
            this.loadingNextPage = toCopyFrom.isLoadingNextPage();
            this.loadingNextPage = toCopyFrom.isLoadingNextPage();
            this.nextPageError = toCopyFrom.getNextPageError();
            this.pullToRefreshError = toCopyFrom.getPullToRefreshError();
            this.firstPageError = toCopyFrom.getFirstPageError();
        }

        public Builder firstPageLoading(boolean loadingFirstPage) {
            this.loadingFirstPage = loadingFirstPage;
            return this;
        }

        public Builder firstPageError(Throwable error) {
            this.firstPageError = error;
            return this;
        }

        public Builder data(List<Movie> data) {
            this.data = data;
            return this;
        }

        public Builder nextPageLoading(boolean loadingNextPage) {
            this.loadingNextPage = loadingNextPage;
            return this;
        }

        public Builder nextPageError(Throwable error) {
            this.nextPageError = error;
            return this;
        }

        public Builder pullToRefreshLoading(boolean loading) {
            this.loadingPullToRefresh = loading;
            return this;
        }

        public Builder pullToRefreshError(Throwable error) {
            this.pullToRefreshError = error;
            return this;
        }

        public MovieViewState build() {
            return new MovieViewState(data, loadingFirstPage, firstPageError, loadingNextPage,
                    nextPageError, loadingPullToRefresh, pullToRefreshError);
        }
    }
}
