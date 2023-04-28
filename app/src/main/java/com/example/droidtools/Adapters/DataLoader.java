package com.example.droidtools.Adapters;

import android.content.Context;
import android.database.Cursor;

import androidx.loader.content.CursorLoader;

import com.example.droidtools.RoomDatabasePackage.MyDatabase;
import com.example.droidtools.RoomDatabasePackage.NotesDao;

public class DataLoader extends CursorLoader {

    private NotesDao dao;

    public DataLoader(Context context) {
        super(context);
        dao = MyDatabase.getInstance(getContext()).getNotesDao();
    }

    @Override
    public Cursor loadInBackground() {
        return dao.loadAllPages();

    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
