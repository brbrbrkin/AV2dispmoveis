package com.example.cimatecmovie.model;

public class User {
    private String matricula; // ID
    private String userName;

    public User() {
        // Default constructor required for Firebase
    }

    public User(String matricula, String userName) {
        this.matricula = matricula;
        this.userName = userName;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getUserName() {
        return userName;
    }
}
