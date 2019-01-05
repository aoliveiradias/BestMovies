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
    private ImageView ivMoviePoster;
    private TextView tvOverview;
    private TextView tvTitle;
    private TextView tvPopularity;
    private TextView tvVoteAvarage;
    private TextView tvReleaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        ivMoviePoster = findViewById(R.id.ivMoviePoster);
        tvOverview = findViewById(R.id.tvOverview);
        tvTitle = findViewById(R.id.tvTitle);
        tvPopularity = findViewById(R.id.tvPopularity);
        tvVoteAvarage = findViewById(R.id.tvVoteAvarage);
        tvReleaseDate = findViewById(R.id.tvReleaseDate);

        Intent intent = getIntent();
        if (intent.resolveActivity(getPackageManager()) != null) {
            Movie movie = intent.getParcelableExtra("MOVIE");
            tvOverview.setText(movie.getOverview());
            tvTitle.setText(movie.getTitle());
            tvPopularity.setText(movie.getPopularity());
            tvVoteAvarage.setText(movie.getVoteAverage());
            tvReleaseDate.setText(movie.getReleaseDate());
            Picasso.get().load("http://image.tmdb.org/t/p/w185/" + movie.getPosterPath()).into(ivMoviePoster);
        }
    }
}
