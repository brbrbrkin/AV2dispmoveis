package com.example.cimatecmovie.model;

import java.util.HashMap;
import java.util.Map;

public class Movie {
    private int id;
    private String name;
    private int yearOfRelease;
    private int likeCount;

    public Movie() {
        // Default constructor required for Firebase
    }

    public Movie(int id, String name, int yearOfRelease, int likeCount) {
        this.id = id;
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.likeCount = likeCount;
    }

    public String getName() {
        return name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public int getLikeCount() {
        return likeCount;
    }

}

