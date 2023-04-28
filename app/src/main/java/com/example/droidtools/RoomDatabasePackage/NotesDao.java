package com.example.droidtools.RoomDatabasePackage;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface NotesDao {
    @Query("SELECT *FROM Notes_Database ORDER BY note_id")
    Cursor loadAllPages();
    @Insert
    long insert(Notes_Database database);
}
