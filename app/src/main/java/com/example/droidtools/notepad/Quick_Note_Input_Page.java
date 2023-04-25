package com.example.droidtools.notepad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.droidtools.R;
import com.example.droidtools.RoomDatabasePackage.MyDatabase;
import com.example.droidtools.RoomDatabasePackage.Notes_Database;

import java.util.Date;

public class Quick_Note_Input_Page extends AppCompatActivity {
    private EditText noteTitle,noteDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_note_input_page);
        init();
    }
    private void init(){
        noteTitle= (EditText) findViewById(R.id.note_title);
        noteDesc= (EditText) findViewById(R.id.note_desc);
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
           String title=noteTitle.getText().toString();
           String description=noteDesc.getText().toString();
           if(!title.isEmpty() || description.isEmpty()){
               Notes_Database database=new Notes_Database(title,description);
               long id =MyDatabase.getInstance(this).getNotesDao().insert(database);
               if(id==-1) Toast.makeText(this, "Error occured while inserting", Toast.LENGTH_SHORT).show();
                else Toast.makeText(this, "Note Inserted", Toast.LENGTH_SHORT).show();
           }

        }
        return true;
    }
}