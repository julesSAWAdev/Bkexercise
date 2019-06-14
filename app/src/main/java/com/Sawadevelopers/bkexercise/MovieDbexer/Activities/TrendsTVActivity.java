package com.Sawadevelopers.bkexercise.MovieDbexer.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.Sawadevelopers.bkexercise.MovieDbexer.Controllers.Controller;
import com.Sawadevelopers.bkexercise.MovieDbexer.Models.TVShow;
import com.Sawadevelopers.bkexercise.MovieDbexer.Models.TVShowsList;
import com.Sawadevelopers.bkexercise.MovieDbexer.R;
import com.Sawadevelopers.bkexercise.MovieDbexer.RecyclerViewsClasses.TrendsTVAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrendsTVActivity extends AppCompatActivity {

    // General parameters
    private String language = "En";
    private String api_key = "7c0efc99aa34718ff8c9364ceb52902c";

    //For API
    private Controller controller;

    // View Objects
    private RecyclerView ListRecyclerView1;
    private RecyclerView ListRecyclerView2;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager1;
    private RecyclerView.LayoutManager layoutManager2;

    // Runtime parameters
    private String intent_typed_api_key;
    private String intent_default_api_key;

    private int actual_page = 1;
    private List<TVShow> actual_tvs = new ArrayList<TVShow>();



    private void getTVTrends(String period, final RecyclerView rv){
        controller.queryTVTrends(period, new Callback<TVShowsList>(){
            public void onResponse(Call<TVShowsList> call, Response<TVShowsList> response) {
                if(response.isSuccessful()) {
                    TVShowsList tvsList = response.body();
                    actual_tvs = tvsList.getTVShows();

                    // specify an adapter
                    mAdapter = new TrendsTVAdapter(actual_tvs, api_key);
                    rv.setAdapter(mAdapter);
                } else {
                    System.out.println(response.errorBody());
                }
            }
            public void onFailure(Call call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trends_tv);

        // Get Intent data
        intent_default_api_key = getIntent().getStringExtra("default_api_key");
        intent_typed_api_key = getIntent().getStringExtra("typed_api_key");
        if (intent_typed_api_key != null && ! intent_typed_api_key.equals(new String(""))){
            api_key = intent_typed_api_key;
        }
        else{
            api_key = intent_default_api_key;
        }

        // Getting all objects from View
        ListRecyclerView1 = (RecyclerView) findViewById(R.id.tvList);
        ListRecyclerView2 = (RecyclerView) findViewById(R.id.tvList2);

        // Initialising display data

        controller = new Controller(api_key, language);

        // - Recycler Views for movies trends
        layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ListRecyclerView1.setLayoutManager(layoutManager1);
        layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ListRecyclerView2.setLayoutManager(layoutManager2);

        // - Filling recycler views
        getTVTrends("day", ListRecyclerView1);
        getTVTrends("week", ListRecyclerView2);
    }
}
