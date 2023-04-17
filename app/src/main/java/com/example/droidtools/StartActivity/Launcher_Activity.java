package com.example.droidtools.StartActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.droidtools.R;
import com.example.droidtools.login_signups.Login_Or_Signup_Page;

import java.util.Objects;

public class Launcher_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                Intent intent = new Intent(Launcher_Activity.this, Login_Or_Signup_Page.class);
                startActivity(intent);
            }
        });
        thread.start();

    }
}