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
            if (title.isEmpty()){
                Toast.makeText(this, "Title is empty", Toast.LENGTH_SHORT).show();
            }
            else if (desc.isEmpty()) {
                Toast.makeText(this, "Description is empty", Toast.LENGTH_SHORT).show();
            }
            else {
                Notes_Database datas = new Notes_Database(title,desc);
                MyDatabase myDatabase = Room.databaseBuilder(Quick_Note_Input_Page.this,MyDatabase.class,"NoteDatabase")
                        .allowMainThreadQueries().build();

                myDatabase.dao().noteInsertion(datas);
//            Intent intent = new Intent(Quick_Note_Input_Page.this, Quick_Note_Output_Page.class);
//            intent.putExtra("title",title);
//            intent.putExtra("desc",desc);
//            startActivity(intent);
            }


        }


        return true;
    }
}