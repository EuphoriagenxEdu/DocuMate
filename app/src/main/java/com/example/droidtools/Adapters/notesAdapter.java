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
import com.example.droidtools.RoomDatabasePackage.QuickNotesContracts;
import com.example.droidtools.notepad.Page;

public class notesAdapter extends RecyclerView.Adapter<notesAdapter.MyViewHolder>{
    Cursor data;
    private Context context;
    private onPageClickListener listener;

    public notesAdapter(Cursor data) {
        this.data = data;
    }

    public notesAdapter() {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.page,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Page tempPage = getPage(position);
        holder.bind(tempPage);

    }
    private Page getPage(int position) {
        data.moveToPosition(position);
        int titleIndex = data.getColumnIndex(QuickNotesContracts.databaseEntry.TITLE_COL);
        int descIndex = data.getColumnIndex(QuickNotesContracts.databaseEntry.DESCRIPTION_COL);
        int idIndex = data.getColumnIndex(QuickNotesContracts.databaseEntry.PAGE_ID);
        int dateIndex = data.getColumnIndex(QuickNotesContracts.databaseEntry.DATE_COL);
        String title = data.getString(titleIndex);
        String description = data.getString(descIndex);
        int id = data.getInt(idIndex);
        long date = data.getLong(dateIndex);
        return new Page(title, date, description, id);
    }
    @Override
    public int getItemCount() {
        if (null == data) return 0;
        return data.getCount();
    }
    public void swap(Cursor data) {
        this.data = data;
        notifyDataSetChanged();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
        TextView title;
        TextView desc;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.note_title);
            desc = itemView.findViewById(R.id.note_desc);

        }
        @Override
        public void onClick(View view) {
            Page tempPage = getPage(getAdapterPosition());
            listener.onPageClick(tempPage.getId());
        }

        @Override
        public boolean onLongClick(View view) {
            return listener.onLongPageClick(getPage(getAdapterPosition()).getId());
        }

        public void bind(Page page) {
            String description = page.getDescription();
            description = description.replace("\n", "");
            long time = page.getDate();
            title.setText(page.getTitle());
            if (description.isEmpty())
                descp.setVisibility(View.GONE);
            else {
                descp.setVisibility(View.VISIBLE);
                if (description.length() < 50)
                    descp.setText(description);
                else descp.setText(description.substring(0, 50) + "........");
            }
            date.setText(DateExtraction.generateDateString(time));
        }


    }
}
