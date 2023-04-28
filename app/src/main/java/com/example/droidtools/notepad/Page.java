package com.example.droidtools.notepad;

import static com.example.droidtools.RoomDatabasePackage.QuickNotesContracts.databaseEntry.DATE_COL;
import static com.example.droidtools.RoomDatabasePackage.QuickNotesContracts.databaseEntry.DESCRIPTION_COL;
import static com.example.droidtools.RoomDatabasePackage.QuickNotesContracts.databaseEntry.PAGE_ID;
import static com.example.droidtools.RoomDatabasePackage.QuickNotesContracts.databaseEntry.TITLE_COL;

import android.content.ContentValues;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "page_entry")
public class Page implements Serializable {
    @ColumnInfo(name = TITLE_COL)
    private String title;
    @ColumnInfo(name = DESCRIPTION_COL)
    private String description;
    @ColumnInfo(name = DATE_COL)
    private long date;
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = PAGE_ID)
    private int id;


    public Page(String title, long date, String description, int id) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.id = id;
    }

    @Ignore
    public Page() {
    }

    public static Page fromContentValues(ContentValues values) {
        if (values == null) return null;
        final Page page = new Page();
        if (values.containsKey(PAGE_ID)) {
            page.id = values.getAsInteger(PAGE_ID);
        }
        if (values.containsKey(DATE_COL)) {
            page.date = values.getAsLong(DATE_COL);
        }
        if (values.containsKey(TITLE_COL)) {
            page.title = values.getAsString(TITLE_COL);
        }
        if (values.containsKey(DESCRIPTION_COL)) {
            page.description = values.getAsString(DESCRIPTION_COL);
        }
        return page;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public long getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }
}