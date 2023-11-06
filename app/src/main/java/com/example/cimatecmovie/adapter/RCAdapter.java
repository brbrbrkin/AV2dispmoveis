package com.example.cimatecmovie.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cimatecmovie.MainActivity;
import com.example.cimatecmovie.R;
import com.example.cimatecmovie.model.Movie;

import java.util.ArrayList;

//codigo adaptado do geeks for geeks
//https://www.geeksforgeeks.org/how-to-update-recyclerview-adapter-data-in-android/
public class RCAdapter extends RecyclerView.Adapter<RCAdapter.ViewHolder> {
    public interface OnItemLongClickListener {
        public boolean onItemLongClicked(int position);
    }

    private MainActivity mActivity;
    private ArrayList<Movie> movies;

    public RCAdapter(ArrayList<Movie> filmes, MainActivity mActivity) {
        this.movies = filmes;
        this.mActivity = mActivity;
    }
    @NonNull
    @Override
    public RCAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCAdapter.ViewHolder holder, int position) {
        Movie item = movies.get(position);
        holder.listTV.setText(item.getName());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //mActivity.onItemLongPress(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView listTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listTV = itemView.findViewById(R.id.cardItemTextView);
        }

    }
}
