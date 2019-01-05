package com.aoliveiradias.bestmovies.adapter;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aoliveiradias.bestmovies.R;
import com.aoliveiradias.bestmovies.activity.MovieDetailActivity;
import com.aoliveiradias.bestmovies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> mDataset;

    public MovieAdapter(List<Movie> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_movie_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Picasso.get().load("http://image.tmdb.org/t/p/w185/" + mDataset.get(position).getPosterPath()).into(holder.mPosterImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MovieDetailActivity.class);
                intent.putExtra("MOVIE", mDataset.get(position));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        final CardView mPopularMovieCardView;
        final ImageView mPosterImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mPopularMovieCardView = itemView.findViewById(R.id.cv_popular_movie);
            mPosterImageView = itemView.findViewById(R.id.iv_movie_poster);
        }
    }
}
