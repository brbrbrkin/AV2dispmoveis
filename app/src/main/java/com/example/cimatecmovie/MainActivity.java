package com.example.cimatecmovie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cimatecmovie.adapter.RCAdapter;
import com.example.cimatecmovie.firebase.db;
import com.example.cimatecmovie.model.Movie;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    boolean isLoggedIn = false;

    public RecyclerView moviesRV;
    public RCAdapter adapter;
    public Button addMovieBtn;
    public ArrayList<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);

        savedInstanceState = getIntent().getExtras();

        if (savedInstanceState != null) {
            isLoggedIn = savedInstanceState.getBoolean("isLoggedIn");
        }

        // Confere se o usuário está logado
        if (isLoggedIn) {
            setContentView(R.layout.activity_main);
        } else {
            // Se não estiver logado, redireciona para a tela de login
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

        moviesRV = findViewById(R.id.recyclerView);
        addMovieBtn = findViewById(R.id.addMovieButton);

        movieList = new ArrayList<Movie>();
        adapter = new RCAdapter(movieList, this);

        //carrega o adapter com dados
        db db = new db();

        DatabaseReference movieRef = db.getMovieRef();

        movieRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                movieList.clear();

                for (DataSnapshot movieSnapshot : snapshot.getChildren()) {
                    Movie movie = movieSnapshot.getValue(Movie.class);
                    if (movie != null) {
                        movieList.add(movie);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        moviesRV.setLayoutManager(layoutManager);
        moviesRV.setAdapter(adapter);

        addMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddMovieActivity.class));

            }
        });



    }

}