package com.aoliveiradias.bestmovies.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("page")
    @Expose
    private Integer page;

    @SerializedName("results")
    @Expose
    private List<Movie> results;

    public MovieResponse(Integer page, List<Movie> results) {
        this.page = page;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public List<Movie> getResults() {
        return results;
    }
}
