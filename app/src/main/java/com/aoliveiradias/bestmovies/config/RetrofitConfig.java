package com.aoliveiradias.bestmovies.config;

import com.aoliveiradias.bestmovies.api.TheMoviedbService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public TheMoviedbService getTheMoviedbService() {
        return this.retrofit.create(TheMoviedbService.class);
    }
}
