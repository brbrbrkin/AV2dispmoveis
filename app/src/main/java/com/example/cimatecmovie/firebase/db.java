package com.example.cimatecmovie.firebase;

import com.example.cimatecmovie.AddMovieActivity;
import com.example.cimatecmovie.model.Movie;
import com.example.cimatecmovie.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

// Classe para interação com o banco de dados Firebase Realtime Database
public class db {
    private DatabaseReference databaseReference;

    public interface Callback {
        void onSuccess();
        void onFailure();
    }
    public db() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference moviesRef = databaseReference.child("movies");

        Movie movie1 = new Movie(1, "O Poderoso Chefão", 1972, 0);
        Movie movie2 = new Movie(2, "O Poderoso Chefão II", 1974, 0);
        Movie movie3 = new Movie(3, "Batman: O Cavaleiro das Trevas", 2008, 0);

        moviesRef.child("1").setValue(movie1);
        moviesRef.child("2").setValue(movie2);
        moviesRef.child("3").setValue(movie3);

    }

    public DatabaseReference getMovieRef() {
        return databaseReference.child("movies");
    }
    // Create a new movie in the database
    public void addMovie(int id, Movie movie, AddMovieActivity activity) {
        DatabaseReference newMovie = getMovieRef().child(String.valueOf(id));
        newMovie.setValue(movie)
                .addOnCompleteListener(task -> {
                    activity.finish();
                });
    }

    // Update the like count for a movie
    public void updateLikeCount(String movieId, int newLikeCount) {
        DatabaseReference movieRef = databaseReference.child("movies").child(movieId);
        movieRef.child("likeCount").setValue(newLikeCount);
    }

    // Add a user to the database
    public void addUser(User user) {
        DatabaseReference userRef = databaseReference.child("users").child(user.getMatricula());
        userRef.setValue(user);
    }

    public int getMovieCount() {
        DatabaseReference movieRef = databaseReference.child("movies");
        return (int) movieRef.get().getResult().getChildrenCount();
    }

}
