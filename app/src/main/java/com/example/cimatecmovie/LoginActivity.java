package com.example.cimatecmovie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

        EditText usernameET;
        EditText passwordET;

        Button loginButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            usernameET = findViewById(R.id.usernameEditText);
            passwordET = findViewById(R.id.passwordEditText);
            loginButton = findViewById(R.id.loginButton);

            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lógica de login
                    // Apenas redireciona para a tela principal
                    Bundle bundle = new Bundle();
                    bundle.putString("username", usernameET.getText().toString());
                    bundle.putBoolean("isLoggedIn", true);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
}
