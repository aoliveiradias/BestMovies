package com.aoliveiradias.bestmovies.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.aoliveiradias.bestmovies.R;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private String[] mDataset;

    public MovieAdapter(String[] myDataset) {
        mDataset = myDataset;
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


    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_movie_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.mPosterImageView);

    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
