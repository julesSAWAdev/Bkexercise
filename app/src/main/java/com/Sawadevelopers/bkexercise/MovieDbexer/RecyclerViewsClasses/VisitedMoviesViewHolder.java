package com.Sawadevelopers.bkexercise.MovieDbexer.RecyclerViewsClasses;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Sawadevelopers.bkexercise.MovieDbexer.Activities.MovieDetailsActivity;
import com.Sawadevelopers.bkexercise.MovieDbexer.Models.Movie;
import com.Sawadevelopers.bkexercise.MovieDbexer.R;
import com.bumptech.glide.Glide;


public class VisitedMoviesViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView description;
    private ImageView thumbnail;

    public VisitedMoviesViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.title);
        this.description = itemView.findViewById(R.id.description);
        this.thumbnail = itemView.findViewById(R.id.thumbnail);
    }

    public void bind(final Movie movie, final String api_key) {
        title.setText(movie.getTitle());
        String new_description = movie.getOverview();
        if (new_description.length() >= 100){
            new_description = new_description.substring(0,100) + "...";
        }
        description.setText(new_description);

        Glide.with(itemView).load(movie.getPosterFullPath()).into(thumbnail);

        // Create Listener for each ViewHolder, then if we click, we can see video details
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, MovieDetailsActivity.class);
                intent.putExtra("movie_id", movie.getId());
                intent.putExtra("api_key", api_key);
                context.startActivity(intent);
            }
        });
    }
}
