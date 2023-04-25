package com.example.droidtools.RoomDatabasePackage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Notes_Database.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    private static final String DB_NAME = "Notes_Database";
    private static volatile MyDatabase instance;

    public static synchronized MyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static MyDatabase create(final Context context) {
        return Room.databaseBuilder(context, MyDatabase.class, DB_NAME).build();
    }

    public abstract NotesDao getNotesDao();
}
