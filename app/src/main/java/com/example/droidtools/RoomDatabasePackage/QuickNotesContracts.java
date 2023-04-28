package com.example.droidtools.RoomDatabasePackage;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class QuickNotesContracts {

    public QuickNotesContracts() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.dailynotes";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PAGES = "pages";

    public static final class databaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "PAGES";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PAGES);
        public static final String PAGE_ID = "ID";
        public static final String TITLE_COL = "TITLE";
        public static final String DESCRIPTION_COL = "DESCRITPION";
        public static final String DATE_COL = "DATE";
        public static Uri buildUri(int id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }
    }
}
