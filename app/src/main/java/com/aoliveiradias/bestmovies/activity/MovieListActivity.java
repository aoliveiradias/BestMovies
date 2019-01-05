package com.aoliveiradias.bestmovies.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.aoliveiradias.bestmovies.R;
import com.aoliveiradias.bestmovies.adapter.MovieAdapter;
import com.aoliveiradias.bestmovies.api.TheMoviedbService;
import com.aoliveiradias.bestmovies.config.RetrofitConfig;
import com.aoliveiradias.bestmovies.model.Movie;
import com.aoliveiradias.bestmovies.model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {

    private ProgressBar mLoadingIndicator;
    private final RetrofitConfig retrofitConfig = new RetrofitConfig();
    private List<Movie> movieList = new ArrayList<>();
    private static final String API_KEY = "YOUR_API_KEY";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        mLoadingIndicator = findViewById(R.id.pb_movies_list);
        getPopularMovies();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_most_popular:
                getPopularMovies();
                break;
            case R.id.item_top_rated:
                getTopRatedMovies();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getPopularMovies() {
        mLoadingIndicator.setVisibility(View.VISIBLE);
        TheMoviedbService theMoviedbService = this.retrofitConfig.getTheMovieDbService();
        Call<MovieResponse> moviesOrderByPopular = theMoviedbService.getMoviesOrderByPopular(API_KEY);
        moviesOrderByPopular.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    movieList = response.body().getResults();
                    generateDataList();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call, @NonNull Throwable throwable) {
                System.out.println(throwable);
            }
        });
        mLoadingIndicator.setVisibility(View.INVISIBLE);
    }


    private void getTopRatedMovies() {
        mLoadingIndicator.setVisibility(View.VISIBLE);
        TheMoviedbService theMoviedbService = this.retrofitConfig.getTheMovieDbService();
        Call<MovieResponse> moviesTopRated = theMoviedbService.getMoviesOrderByTopRated(API_KEY);
        moviesTopRated.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call, @NonNull Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    movieList = response.body().getResults();
                    generateDataList();
                }
                mLoadingIndicator.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call, @NonNull Throwable throwable) {
                System.out.println(throwable);
                mLoadingIndicator.setVisibility(View.INVISIBLE);
            }
        });

    }


    private void generateDataList() {
        RecyclerView mRecyclerView = findViewById(R.id.rv_movies);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new MovieAdapter(movieList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
