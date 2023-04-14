package com.example.droidtools;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class Quick_Note_Input_Page extends AppCompatActivity {
    private EditText noteTitle,noteDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_note_input_page);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_for_quick_notes,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if (item_id == R.id.save){
            noteTitle = (EditText) findViewById(R.id.note_title);
            noteDesc = (EditText) findViewById(R.id.noteDesc);

            String title = noteTitle.getText().toString();
            String desc = noteDesc.getText().toString();
            Intent intent = new Intent(Quick_Note_Input_Page.this,Quick_Note_Output_Page.class);
            intent.putExtra("title",title);
            intent.putExtra("desc",desc);
            startActivity(intent);
        }


        return true;
    }
}