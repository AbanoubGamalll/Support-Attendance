package com.example.supportattendance.RecyclerView.Attendance;

import android.animation.ObjectAnimator;
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
        Common.AnimationOnStart(holder.cardView, (float) (delay));
        delay += 0.1;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CheckBox checkBox;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            checkBox = itemView.findViewById(R.id.checkBox);
            checkBox.setVisibility(View.GONE);
            cardView = itemView.findViewById(R.id.cardViewAttendance);
        }
    }


}
