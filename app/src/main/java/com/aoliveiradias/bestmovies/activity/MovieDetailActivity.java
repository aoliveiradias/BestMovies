package com.aoliveiradias.bestmovies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.aoliveiradias.bestmovies.R;
import com.aoliveiradias.bestmovies.model.Movie;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ImageView ivMoviePoster = findViewById(R.id.ivMoviePoster);
        TextView tvOverview = findViewById(R.id.tvOverview);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvPopularity = findViewById(R.id.tvPopularity);
        TextView tvVoteAverage = findViewById(R.id.tvVoteAverage);
        TextView tvReleaseDate = findViewById(R.id.tvReleaseDate);

        Intent intent = getIntent();
        if (intent.resolveActivity(getPackageManager()) != null) {
            Movie movie = intent.getParcelableExtra("MOVIE");
            tvOverview.setText(movie.getOverview());
            tvTitle.setText(movie.getTitle());
            tvPopularity.setText(movie.getPopularity());
            tvVoteAverage.setText(movie.getVoteAverage());
            tvReleaseDate.setText(movie.getReleaseDate());
            Picasso.with(this).load("http://image.tmdb.org/t/p/w185/" + movie.getPosterPath()).into(ivMoviePoster);
        }
    }
}
