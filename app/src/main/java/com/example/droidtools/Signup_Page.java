package com.example.droidtools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Signup_Page extends AppCompatActivity {
    private EditText password;
    private EditText cPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        Objects.requireNonNull(getSupportActionBar()).hide();


        Button signup = findViewById(R.id.signUpBtn);
        signup.setOnClickListener(view -> {
            password = findViewById(R.id.password);
            cPassword = findViewById(R.id.cPassword);
            String p1 = password.getText().toString();
            String p2 = cPassword.getText().toString();

            if (p1.isEmpty() && p2.isEmpty()) {
                Toast.makeText(Signup_Page.this, "Empty password", Toast.LENGTH_SHORT).show();
            }
            else{
                if (p1.equals(p2)) {
                    Intent intent = new Intent(Signup_Page.this, Login_Page.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Signup_Page.this, "Passwords are not same", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}