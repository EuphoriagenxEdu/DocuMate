package com.example.droidtools.RoomDatabasePackage;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Notes_Database.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DAO dao();
}
