package com.example.droidtools.notepad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.droidtools.Adapters.DataLoader;
import com.example.droidtools.Adapters.notesAdapter;
import com.example.droidtools.R;
import com.example.droidtools.RoomDatabasePackage.MyDatabase;
import com.example.droidtools.RoomDatabasePackage.NotesDao;
import com.example.droidtools.RoomDatabasePackage.Notes_Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Objects;

public class Notepad_Start_Interface extends AppCompatActivity {

    private FloatingActionButton addNotes;
    private notesAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_notepad_start_interface);
        init();

        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quick_Note_Input_Page.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
       loadRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadRecyclerView();
    }

    private void loadRecyclerView(){
        LoaderManager.getInstance(this).
                initLoader(0, null, new LoaderManager.LoaderCallbacks<Cursor>() {
                    @NonNull
                    @Override
                    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
                        return new DataLoader(Notepad_Start_Interface.this);
                    }

                    @Override
                    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
                        adapter.swap(data);
                    }

                    @Override
                    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

                    }
                });
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    private void init() {
        addNotes = (FloatingActionButton) findViewById(R.id.add_btn);
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        adapter=new notesAdapter();
    }


}