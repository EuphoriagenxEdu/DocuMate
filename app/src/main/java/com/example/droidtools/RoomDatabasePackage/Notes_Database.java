package com.example.droidtools.RoomDatabasePackage;


import android.icu.text.SimpleDateFormat;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Entity
public class Notes_Database {
    @PrimaryKey(autoGenerate = true)
    int note_id;
    String note_title_name;
    String note_desc_content;
    String  currentDateAndTime;

    public Notes_Database(String note_title_name, String note_desc_content) {
        this.note_title_name = note_title_name;
        this.note_desc_content = note_desc_content;
        Date dateAndtime = Calendar.getInstance().getTime();
        SimpleDateFormat nowdate = new SimpleDateFormat("dd/mm/yyyy",Locale.getDefault());
        SimpleDateFormat nowtime = new SimpleDateFormat("hh:mm:ss",Locale.getDefault());
        String cdate = nowdate.format(dateAndtime);
        String ctime = nowtime.format(dateAndtime);
        currentDateAndTime = cdate+" "+ctime;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public String getNote_title_name() {
        return note_title_name;
    }

    public String getNote_desc_content() {
        return note_desc_content;
    }

    public void setNote_desc_content(String note_desc_content) {
        this.note_desc_content = note_desc_content;
    }

    public String getCurrentDateAndTime() {
        return currentDateAndTime;
    }

    public void setCurrentDateAndTime(String currentDateAndTime) {
        this.currentDateAndTime = currentDateAndTime;
    }
}
