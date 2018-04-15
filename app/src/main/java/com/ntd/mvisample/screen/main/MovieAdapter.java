package com.ntd.mvisample.screen.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ntd.mvisample.R;
import com.ntd.mvisample.data.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 4/15/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Movie> mMovies;
    private Context mContext;
    static final int VIEW_TYPE_MOVIE = 1;
    static final int VIEW_TYPE_LOADING = 2;
    private boolean isLoadingNextPage = false;

    public MovieAdapter(Context context){
        mContext = context;
        mMovies = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemMovie = layoutInflater.inflate(R.layout.item_movie, parent,false);
        View itemLoading = layoutInflater.inflate(R.layout.item_loading, parent,false);

        switch (viewType) {
            case VIEW_TYPE_MOVIE:
                return new MovieViewHolder(itemMovie);
            case VIEW_TYPE_LOADING:
                return new LoadingViewHolder(itemLoading);
        }
        throw new IllegalArgumentException("Couldn't create a ViewHolder for viewType  = " + viewType);
    }

    public void setData(List<Movie> listMovies) {
        if (mMovies == null) {
            return;
        }
        mMovies.clear();
        mMovies.addAll(listMovies);
        notifyDataSetChanged();
    }

    public void updateData(List<Movie> movieList) {
        mMovies.addAll(movieList);
        notifyDataSetChanged();
    }
    public List<Movie> getData() {
        return mMovies;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof LoadingViewHolder) {
            return;
        }
        else {
            MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
            Picasso.get().load("https://image.tmdb.org/t/p/w300_and_h450_bestv2/"
                    + mMovies.get(position).getBackdropPath()).into(movieViewHolder.imageView);
            Picasso.get().load("https://image.tmdb.org/t/p/w300_and_h450_bestv2/"
                    + mMovies.get(position).getBackdropPath()).into(movieViewHolder.imageViewBackGround);
            movieViewHolder.textViewNameMovie.setText(mMovies.get(position).getTitle());
        }
    }

    /**
     * @return true if value has changed since last invocation
     */
    public boolean setLoadingNextPage(boolean loadingNextPage) {
        boolean hasLoadingMoreChanged = loadingNextPage != isLoadingNextPage;

        boolean notifyInserted = loadingNextPage && hasLoadingMoreChanged;
        boolean notifyRemoved = !loadingNextPage && hasLoadingMoreChanged;
        isLoadingNextPage = loadingNextPage;

        if (notifyInserted) {
            notifyItemInserted(mMovies.size());
        } else if (notifyRemoved) {
            notifyItemRemoved(mMovies.size());
        }

        return hasLoadingMoreChanged;
    }

    public boolean isLoadingNextPage() {
        return isLoadingNextPage;
    }

    @Override
    public int getItemCount() {
        return mMovies == null ? 0 : (mMovies.size() + (isLoadingNextPage ? 1 : 0));
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewNameMovie;
        ImageView imageViewBackGround;


        public MovieViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewNameMovie = itemView.findViewById(R.id.textView);
        }
    }

    static class LoadingViewHolder extends RecyclerView.ViewHolder{

        private LoadingViewHolder(View itemView) {
            super(itemView);
        }
    }
}
