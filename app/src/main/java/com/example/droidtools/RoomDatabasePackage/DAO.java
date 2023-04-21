package com.example.droidtools.RoomDatabasePackage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao public interface DAO {
    @Insert
    public void noteInsertion(Notes_Database datas);

    @Query("Select * from Notes_Database")
    List<Notes_Database>getNotedatabase();


}
