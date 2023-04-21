package com.example.droidtools.notepad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.droidtools.R;
import com.example.droidtools.RoomDatabasePackage.DAO;
import com.example.droidtools.RoomDatabasePackage.MyDatabase;
import com.example.droidtools.RoomDatabasePackage.Notes_Database;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Notepad_Start_Interface extends AppCompatActivity {
    private FloatingActionButton add_btn;
    private MyDatabase myDatabase;
    RecyclerView rv;
    TextView title;
    TextView desc;
    TextView note_time;
    ScrollView content;
    CardView card;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_notepad_start_interface);


        rv = (RecyclerView) findViewById(R.id.recycleviewr);
        rv.setLayoutManager(new LinearLayoutManager(this));



        title = (TextView)findViewById(R.id.note_title);
        desc = (TextView) findViewById(R.id.note_desc);
        note_time = (TextView) findViewById(R.id.note_time);
        add_btn = (FloatingActionButton) findViewById(R.id.add_btn);
        content = (ScrollView) findViewById(R.id.content);
        card = (CardView) findViewById(R.id.card);


//
//        setDB();
//        List<Notes_Database> datas = myDatabase.dao().getNotedatabase();
//
//
//        int size_arr = datas.size();
////        String title_list[] = new String[size_arr];
////        String desc_list[] = new String[size_arr];
//
//        for (int i = 0; i < size_arr; i++) {
//            String title_list = datas.get(i).getNote_title_name().toString();
//            String desc_list = datas.get(i).getNote_desc_content().toString();
////                   String time_list = datas.get(0).getCurrentDateAndTime().toString();
//
//            title.setText(title_list);
//            desc.setText(desc_list);
////                   note_time.setText(time_list);
//        }
//
////
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vis = (content.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
                TransitionManager.beginDelayedTransition(card,new AutoTransition());
                content.setVisibility(vis);
            }
        });


       add_btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(Notepad_Start_Interface.this, Quick_Note_Input_Page.class);
               startActivity(intent);

           }
       });
    }


    public void getRooomData(){
        myDatabase = Room.databaseBuilder(Notepad_Start_Interface.this,MyDatabase.class,"NoteDatabase")
                .allowMainThreadQueries().build();
        DAO dao = myDatabase.dao();
        List<Notes_Database> datas =  dao.getNotedatabase();
        MyAdapter adapter = new MyAdapter(datas);
        rv.setAdapter(adapter);
    }

    private void setDB(){
         myDatabase = Room.databaseBuilder(Notepad_Start_Interface.this,MyDatabase.class,"NoteDatabase")
                .allowMainThreadQueries().build();
    }



}