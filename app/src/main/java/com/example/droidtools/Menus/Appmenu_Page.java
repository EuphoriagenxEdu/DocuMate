package com.example.droidtools.Menus;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.droidtools.ImageToPDF.ImageToPdf;
import com.example.droidtools.R;
import com.example.droidtools.login_signups.Login_Page;
import com.example.droidtools.notepad.Notepad_Start_Interface;
import com.example.droidtools.user_dashbord.User_Details_Show;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class Appmenu_Page extends AppCompatActivity {
    private ImageButton quickNoteBtn,imgToPdfBtn,txtToPdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appmenu_page);
        Objects.requireNonNull(getSupportActionBar()).hide();

        quickNoteBtn = (ImageButton) findViewById(R.id.quiNoteBtn);
        quickNoteBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Appmenu_Page.this, Notepad_Start_Interface.class);
            startActivity(intent);
        });

        imgToPdfBtn = (ImageButton) findViewById(R.id.imgToPdfBtn);
        imgToPdfBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Appmenu_Page.this, ImageToPdf.class);
            startActivity(intent);
        });

//        txtToPdf = (ImageButton) findViewById(R.id.txtToPdf);
//        txtToPdf.setOnClickListener(view -> {
//            Intent intent = new Intent(Appmenu_Page.this, TextToPdf.class);
//            startActivity(intent);
//        });



        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navbarmain);
        navigationView.setSelectedItemId(R.id.mainmenu);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        break;
                    case R.id.profile:
                        Intent intent = new Intent(Appmenu_Page.this, User_Details_Show.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.mainmenu:
                        Intent intent2 = new Intent(Appmenu_Page.this, Appmenu_Page.class);
                        startActivity(intent2);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.settings:
                        break;
                    case R.id.logout:
                        Intent intent3 = new Intent(Appmenu_Page.this, Login_Page.class);
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