package com.example.droidtools.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.droidtools.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class Notepad_Start_Interface extends AppCompatActivity {
    private FloatingActionButton add_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_notepad_start_interface);
        add_btn = (FloatingActionButton) findViewById(R.id.add_note_btn);
       add_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Notepad_Start_Interface.this, Quick_Note_Input_Page.class);
               startActivity(intent);
           }
       });
    }
}