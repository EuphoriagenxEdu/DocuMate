package com.example.droidtools.user_dashbord;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.droidtools.Menus.Appmenu_Page;
import com.example.droidtools.Menus.MainActivity;
import com.example.droidtools.R;
import com.example.droidtools.login_signups.Login_Page;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class User_Details_Show extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details_show);
        Objects.requireNonNull(getSupportActionBar()).hide();
        BottomNavigationView navigationView;
        navigationView = (BottomNavigationView) findViewById(R.id.navbarmain);
        navigationView.setSelectedItemId(R.id.profile);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        break;
                    case R.id.profile:
                        Intent intent = new Intent(User_Details_Show.this,User_Details_Show.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.mainmenu:
                        Intent intent2 = new Intent(User_Details_Show.this,Appmenu_Page.class);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        break;
                    case R.id.logout:
                        Intent intent3 = new Intent(User_Details_Show.this,Login_Page.class);
                        startActivity(intent3);
                        overridePendingTransition(0,0);
                        return true;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                return false;
            }
        });
    }
}