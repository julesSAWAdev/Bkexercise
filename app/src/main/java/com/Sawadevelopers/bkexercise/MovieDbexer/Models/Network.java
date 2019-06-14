package com.Sawadevelopers.bkexercise.MovieDbexer.Models;

import com.google.gson.annotations.SerializedName;

public class Network {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private int id;

    @SerializedName("logo_path")
    private String logo_path;

    @SerializedName("origin_country")
    private String origin_country;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public String getOrigin_country() {
        return origin_country;
    }
}
