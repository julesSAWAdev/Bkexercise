package com.Sawadevelopers.bkexercise.MovieDbexer.RecyclerViewsClasses;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Sawadevelopers.bkexercise.MovieDbexer.Activities.TVDetailsActivity;
import com.Sawadevelopers.bkexercise.MovieDbexer.Models.TVShow;
import com.Sawadevelopers.bkexercise.MovieDbexer.R;
import com.bumptech.glide.Glide;

public class TrendsTVViewHolder extends RecyclerView.ViewHolder {
    private TextView title;
    private TextView description;
    private ImageView thumbnail;

    public TrendsTVViewHolder(@NonNull View itemView) {
        super(itemView);
        this.title = itemView.findViewById(R.id.title);
        this.description = itemView.findViewById(R.id.description);
        this.thumbnail = itemView.findViewById(R.id.thumbnail);
    }

    public void bind(final TVShow tv_show, final String api_key) {
        title.setText(tv_show.getName());
        String new_description = tv_show.getOverview();
        if (new_description.length() >= 100){
            new_description = new_description.substring(0,100) + "...";
        }
        description.setText(new_description);

        Glide.with(itemView).load(tv_show.getPosterFullPath()).into(thumbnail);

        // Create Listener for each ViewHolder, then if we click, we can see video details
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, TVDetailsActivity.class);
                intent.putExtra("tv_id", tv_show.getId());
                intent.putExtra("api_key", api_key);
                context.startActivity(intent);
            }
        });
    }
}