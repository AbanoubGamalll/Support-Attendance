package com.example.supportattendance.RecyclerView.Attendance;

import android.content.Context;
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

import java.util.List;

public class AttendeanceAdapter extends RecyclerView.Adapter<AttendeanceAdapter.ViewHolder> {
    private List<AttendanceModel> list;
    private Context context;
    private float delay = 0;

    public AttendeanceAdapter(List<AttendanceModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public AttendeanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AttendeanceAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.attendenance_model, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AttendeanceAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());

        holder.ch_Attendee.setChecked(list.get(position).getAttendee());
        holder.ch_task.setChecked(list.get(position).getTask());

        Common.AnimationOnStart(holder.cardView, (float) (delay));
        delay += 0.1;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView txt_task;
        TextView txt_attendee;
        CheckBox ch_Attendee;
        CheckBox ch_task;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            ch_Attendee = itemView.findViewById(R.id.Edit);
            ch_Attendee.setClickable(false);
            ch_task = itemView.findViewById(R.id.Delete);
            ch_task.setClickable(false);
            txt_attendee = itemView.findViewById(R.id.txt_attendee);
            txt_task = itemView.findViewById(R.id.txt_task);
            cardView = itemView.findViewById(R.id.cardViewAttendance);
        }
    }


}
