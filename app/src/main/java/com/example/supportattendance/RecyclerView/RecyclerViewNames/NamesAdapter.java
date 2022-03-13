package com.example.supportattendance.RecyclerView.RecyclerViewNames;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supportattendance.Common;
import com.example.supportattendance.R;
import com.example.supportattendance.RecyclerView.Attendance.OnClickNamesRecyclerView;

import java.util.List;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.ViewHolder> {
    private List<NamesModel> list;
    private OnClickNamesRecyclerView clickRecyclerView;
    private float delay = 0;

    public NamesAdapter(List<NamesModel> list, OnClickNamesRecyclerView clickRecyclerView) {
        this.list = list;
        this.clickRecyclerView = clickRecyclerView;
    }


    @NonNull
    @Override
    public NamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NamesAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.attendenance_model, parent, false), clickRecyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull NamesAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.ch_Attendee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.onClickRecyclerView.onclick(holder.getAdapterPosition(), holder.ch_Attendee.isChecked(), holder.ch_task.isChecked());
            }
        });
        holder.ch_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.onClickRecyclerView.onclick(holder.getAdapterPosition(), holder.ch_Attendee.isChecked(), holder.ch_task.isChecked());
            }
        });
        Common.AnimationOnStart(holder.cardView, delay);
        delay += 0.1;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView name;
        CheckBox ch_Attendee;
        CheckBox ch_task;
        CardView cardView;
        OnClickNamesRecyclerView onClickRecyclerView;

        public ViewHolder(@NonNull View itemView, OnClickNamesRecyclerView onClickRecyclerView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            ch_Attendee = itemView.findViewById(R.id.Edit);
            ch_task = itemView.findViewById(R.id.Delete);
            cardView = itemView.findViewById(R.id.cardViewAttendance);
            this.onClickRecyclerView = onClickRecyclerView;
        }
    }

}
