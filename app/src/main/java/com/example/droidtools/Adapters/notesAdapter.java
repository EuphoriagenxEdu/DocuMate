package com.example.droidtools.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.droidtools.R;
import com.example.droidtools.RoomDatabasePackage.Notes_Database;

public class notesAdapter extends RecyclerView.Adapter<notesAdapter.MyViewHolder> {
    private Cursor data;
    private final Context context;

    public notesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.page, parent, false);
        return new MyViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Notes_Database note = getNote(position);
        holder.titleView.setText(note.getNote_title_name());
        holder.descriptionView.setText(note.getNote_desc_content());
        holder.timeView.setText(note.getCurrentDateAndTime());
    }

    private Notes_Database getNote(int position) {
        data.moveToPosition(position);
        int titleColIndex = data.getColumnIndex("TITLE_COL");
        int descpColIndex = data.getColumnIndex("DESCRIPTION_COL");
        int dateColIndex = data.getColumnIndex("DATE_COL");
        String title = data.getString(titleColIndex);
        String description = data.getString(descpColIndex);
        return new Notes_Database(title, description);
    }

    @Override
    public int getItemCount() {
        if (null != data) return data.getCount();
        return 0;
    }

    public void swap(Cursor data) {
        this.data = data;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView, descriptionView, timeView;

        public MyViewHolder(View item) {
            super(item);
            titleView = item.findViewById(R.id.note_title);
            descriptionView = item.findViewById(R.id.note_desc);
            timeView = item.findViewById(R.id.note_time);
        }
    }
}
