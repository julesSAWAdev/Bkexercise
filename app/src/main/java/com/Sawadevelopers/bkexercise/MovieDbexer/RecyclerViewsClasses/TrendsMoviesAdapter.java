package com.Sawadevelopers.bkexercise.MovieDbexer.RecyclerViewsClasses;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Sawadevelopers.bkexercise.MovieDbexer.Models.Movie;
import com.Sawadevelopers.bkexercise.MovieDbexer.R;

import java.util.List;


public class
TrendsMoviesAdapter extends RecyclerView.Adapter<TrendsMoviesViewHolder> {
    private List<Movie> movies;
    private String api_key;

    // Provide a suitable constructor (depends on the kind of dataset)
    public TrendsMoviesAdapter(List<Movie> movies, String api_key) {
        this.api_key = api_key;
        this.movies = movies;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public TrendsMoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_trends_movies, parent, false);

        return new TrendsMoviesViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(TrendsMoviesViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.bind(movies.get(position), this.api_key);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return movies.size();
    }
}
