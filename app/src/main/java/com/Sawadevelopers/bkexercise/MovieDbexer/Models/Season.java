package com.Sawadevelopers.bkexercise.MovieDbexer.Models;

import com.google.gson.annotations.SerializedName;

public class Season {

    @SerializedName("air_date")
    private String air_date;

    @SerializedName("episode_count")
    private int episode_count;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("overview")
    private String overview;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("season_number")
    private int season_number;

    public String getAir_date() {
        return air_date;
    }

    public int getEpisode_count() {
        return episode_count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public int getSeason_number() {
        return season_number;
    }
}
