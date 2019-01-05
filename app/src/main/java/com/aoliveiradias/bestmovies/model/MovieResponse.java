package com.aoliveiradias.bestmovies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("results")
    @Expose
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }
}
