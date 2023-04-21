package com.example.droidtools.login_signups;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.droidtools.Menus.Appmenu_Page;
import com.example.droidtools.R;

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

            if (username.getText().toString().equals("1234") && password.getText().toString().equals("1234")) {

                Intent intent = new Intent(Login_Page.this, Appmenu_Page.class);
                startActivity(intent);
            } else {
                Toast.makeText(Login_Page.this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}