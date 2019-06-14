package com.Sawadevelopers.bkexercise.MovieDbexer.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.Sawadevelopers.bkexercise.MovieDbexer.R;

public class MainActivity extends AppCompatActivity {

    // General parameters
    private String language = "En";
    private String api_key = "7c0efc99aa34718ff8c9364ceb52902c";

    // View Objects
    private Button trend_movies_button;


    // Runtime parameters
    private String actual_api_key = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting all objects from View



        trend_movies_button = findViewById(R.id.trend_movies_button);


        // - Trend videos button
        trend_movies_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), TrendsMoviesActivity.class);
                intent.putExtra("default_api_key", api_key);
                intent.putExtra("typed_api_key", actual_api_key);
                startActivity(intent);
            }
        });


    }
}
