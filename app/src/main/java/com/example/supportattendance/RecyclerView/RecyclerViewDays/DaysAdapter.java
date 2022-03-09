package com.example.supportattendance.RecyclerView.RecyclerViewDays;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supportattendance.R;

import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.ViewHolder> {

    private List<DaysModel> list;
    private OnClickDaysRecyclerView clickRecyclerView;

    public DaysAdapter(List<DaysModel> list, OnClickDaysRecyclerView clickRecyclerView) {
        this.list = list;
        this.clickRecyclerView = clickRecyclerView;
    }

    @NonNull
    @Override
    public DaysAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DaysAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.daysmodel, parent, false), clickRecyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull DaysAdapter.ViewHolder holder, int position) {
        holder.date.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView date;
        OnClickDaysRecyclerView onClickRecyclerView;

        public ViewHolder(@NonNull View itemView, OnClickDaysRecyclerView onClickRecyclerView) {
            super(itemView);
            date = itemView.findViewById(R.id.txtDate);

            this.onClickRecyclerView = onClickRecyclerView;
            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            onClickRecyclerView.onclick(getAdapterPosition());
        }
    }

}
