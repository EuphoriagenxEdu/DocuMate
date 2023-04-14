package com.example.droidtools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Login_Page extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Objects.requireNonNull(getSupportActionBar()).hide();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.button);

        loginButton.setOnClickListener(view -> {

            if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {

                Intent intent = new Intent(Login_Page.this,Appmenu_Page.class);
                startActivity(intent);
            } else {
                Toast.makeText(Login_Page.this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}