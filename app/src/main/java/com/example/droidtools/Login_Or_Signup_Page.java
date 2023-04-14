package com.example.droidtools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class Login_Or_Signup_Page extends AppCompatActivity {
    private Button login;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_signup_page);

        Objects.requireNonNull(getSupportActionBar()).hide();

        login = findViewById(R.id.login);
        signup = findViewById(R.id.signup);

        login.setOnClickListener(view -> {
            Intent intent = new Intent(Login_Or_Signup_Page.this,Login_Page.class);
            startActivity(intent);
        });
        signup.setOnClickListener(view -> {
            Intent intent = new Intent(Login_Or_Signup_Page.this,Signup_Page.class);
            startActivity(intent);
        });
    }
}