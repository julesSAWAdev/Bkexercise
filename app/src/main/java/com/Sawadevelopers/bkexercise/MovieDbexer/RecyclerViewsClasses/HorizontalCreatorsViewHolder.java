package com.Sawadevelopers.bkexercise.MovieDbexer.RecyclerViewsClasses;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.Sawadevelopers.bkexercise.MovieDbexer.Activities.CreatorDetailsActivity;
import com.Sawadevelopers.bkexercise.MovieDbexer.Models.Creator;
import com.Sawadevelopers.bkexercise.MovieDbexer.R;

public class HorizontalCreatorsViewHolder extends RecyclerView.ViewHolder {
    private TextView name;

    public HorizontalCreatorsViewHolder(@NonNull View itemView) {
        super(itemView);
        this.name = itemView.findViewById(R.id.name);
    }

    public void bind(final Creator creator, final String api_key) {
        name.setText(creator.getName());

        // Create Listener for each ViewHolder, then if we click, we can see video details
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CreatorDetailsActivity.class);
                intent.putExtra("creator_id", creator.getId());
                intent.putExtra("api_key", api_key);
                context.startActivity(intent);
            }
        });
    }
}