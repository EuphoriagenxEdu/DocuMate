package com.example.droidtools.notepad;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.droidtools.R;

import java.util.Objects;

public class Quick_Note_Output_Page extends AppCompatActivity {
    TextView title;
    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_note_output_page);

        Objects.requireNonNull(getSupportActionBar()).hide();
        title = (TextView) findViewById(R.id.titleView);
        desc = (TextView) findViewById(R.id.descView);

        String titlev = getIntent().getStringExtra("title");
        String descv = getIntent().getStringExtra("desc");
        title.setText(titlev);
        desc.setText(descv);



    }
}