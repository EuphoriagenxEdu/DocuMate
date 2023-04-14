package com.example.droidtools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.Objects;

public class Appmenu_Page extends AppCompatActivity {
    private ImageButton quickNoteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appmenu_page);
        Objects.requireNonNull(getSupportActionBar()).hide();

        quickNoteBtn = (ImageButton) findViewById(R.id.quiNoteBtn);
        quickNoteBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Appmenu_Page.this, Quick_Note_Input_Page.class);
            startActivity(intent);
        });


    }
}