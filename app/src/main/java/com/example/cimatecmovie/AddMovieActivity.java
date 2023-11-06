package com.example.cimatecmovie;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cimatecmovie.firebase.db;
import com.example.cimatecmovie.model.Movie;

public class AddMovieActivity extends AppCompatActivity {

    EditText movieTitleEditText;
    EditText movieYearEditText;
    Button addMovieBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

       db db = new db();

        movieTitleEditText = findViewById(R.id.filmeEditText);
        movieYearEditText = findViewById(R.id.anoEditText);
        addMovieBtn = findViewById(R.id.addmovieButton);

        addMovieBtn.setOnClickListener(v -> {
            String movieTitle = movieTitleEditText.getText().toString();
            String movieYear = movieYearEditText.getText().toString();
            int movieId = db.getMovieCount() + 1;
            Movie movie = new Movie(movieId, movieTitle, Integer.parseInt(movieYear),0);
            db.addMovie(movieId, movie, this);
        });
    }

}
