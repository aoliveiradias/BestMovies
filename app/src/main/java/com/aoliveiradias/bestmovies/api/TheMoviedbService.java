package com.aoliveiradias.bestmovies.api;

import com.aoliveiradias.bestmovies.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMoviedbService {

    @GET("movie/popular")
    Call<MovieResponse> getMoviesOrderByPolular(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MovieResponse> getMoviesOrderByTopRated(@Query("api_key") String apiKey);
}
