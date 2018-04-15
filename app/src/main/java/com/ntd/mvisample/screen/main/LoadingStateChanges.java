/*
 * Copyright 2016 Hannes Dorfmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.ntd.mvisample.screen.main;

import com.ntd.mvisample.data.model.Movie;

import java.util.List;

/**
 * @author Hannes Dorfmann
 */

public interface LoadingStateChanges {

  /**
   * Indicates that the first page is loading
   */
  final class FirstPageLoading implements LoadingStateChanges {

    @Override public String toString() {
      return "FirstPageLoadingState{}";
    }
  }

  /**
   * Indicates that an error has occurred while loading the first page
   */
  final class FirstPageError implements LoadingStateChanges {
    private final Throwable error;

    public FirstPageError(Throwable error) {
      this.error = error;
    }

    public Throwable getError() {
      return error;
    }

    @Override public String toString() {
      return "FirstPageErrorState{" +
          "error=" + error +
          '}';
    }
  }

  /**
   * Indicates that the first page data has been loaded successfully
   */
  final class FirstPageLoaded implements LoadingStateChanges {
    private final List<Movie> data;

    public FirstPageLoaded(List<Movie> data) {
      this.data = data;
    }

    public List<Movie> getData() {
      return data;
    }
  }

  /**
   * Next Page has been loaded successfully
   */
  final class NextPageLoaded implements LoadingStateChanges {
    private final List<Movie> data;

    public NextPageLoaded(List<Movie> data) {
      this.data = data;
    }

    public List<Movie> getData() {
      return data;
    }
  }

  /**
   * Error while loading new page
   */
  final class NexPageLoadingError implements LoadingStateChanges {
    private final Throwable error;

    public NexPageLoadingError(Throwable error) {
      this.error = error;
    }

    public Throwable getError() {
      return error;
    }
  }

  /**
   * Indicates that loading the next page has started
   */
  final class NextPageLoading implements LoadingStateChanges {
  }

  /**
   * Indicates that loading the newest items via pull to refresh has started
   */
  final class PullToRefreshLoading implements LoadingStateChanges {
  }

  /**
   * Indicates that an error while loading the newest items via pull to refresh has occurred
   */
  final class PullToRefeshLoadingError implements LoadingStateChanges {
    private final Throwable error;

    public PullToRefeshLoadingError(Throwable error) {
      this.error = error;
    }

    public Throwable getError() {
      return error;
    }
  }

  /**
   * Indicates that data has been loaded successfully over pull-to-refresh
   */
  final class PullToRefreshLoaded implements LoadingStateChanges {
    private final List<Movie> data;

    public PullToRefreshLoaded(List<Movie> data) {
      this.data = data;
    }

    public List<Movie> getData() {
      return data;
    }
  }

  /**
   * Loading all Products of a given category has been started
   */
  final class ProductsOfCategoryLoading implements LoadingStateChanges {
    private final String categoryName;

    public ProductsOfCategoryLoading(String categoryName) {
      this.categoryName = categoryName;
    }

    public String getCategoryName() {
      return categoryName;
    }
  }

  /**
   * An error while loading all products has been occurred
   */
  final class ProductsOfCategoryLoadingError implements LoadingStateChanges {
    private final String categoryName;
    private final Throwable error;

    public ProductsOfCategoryLoadingError(String categoryName, Throwable error) {
      this.categoryName = categoryName;
      this.error = error;
    }

    public String getCategoryName() {
      return categoryName;
    }

    public Throwable getError() {
      return error;
    }
  }

}
