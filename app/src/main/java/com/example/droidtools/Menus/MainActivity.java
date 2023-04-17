package com.example.droidtools.Menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.droidtools.R;
import com.example.droidtools.login_signups.Login_Page;
import com.example.droidtools.user_dashbord.User_Details_Show;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navbarmain);
        navigationView.setSelectedItemId(R.id.home);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        break;
                    case R.id.profile:
                        Intent intent = new Intent(MainActivity.this,User_Details_Show.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.mainmenu:
                       startActivity(new Intent(getApplicationContext(), Appmenu_Page.class));
                       overridePendingTransition(0,0);
                       return true;
                    case R.id.settings:
                        break;
                    case R.id.logout:
                        startActivity(new Intent(getApplicationContext(), Login_Page.class));
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