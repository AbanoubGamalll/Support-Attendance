package com.example.supportattendance.RecyclerView.RecyclerViewShowAllNames;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.supportattendance.Common;
import com.example.supportattendance.R;
import com.example.supportattendance.RecyclerView.Attendance.OnClickNamesRecyclerView;
import com.example.supportattendance.RecyclerView.RecyclerViewNames.NamesModel;

import java.util.List;

public class ShowNamesAdapter extends RecyclerView.Adapter<ShowNamesAdapter.ViewHolder> {
    private List<NamesModel> list;
    private onclickNames clickRecyclerView;
    private float delay = 0;

    public ShowNamesAdapter(List<NamesModel> list, onclickNames clickRecyclerView) {
        this.list = list;
        this.clickRecyclerView = clickRecyclerView;
    }

    public ShowNamesAdapter(List<NamesModel> list, onclickNames clickRecyclerView,float delay) {
        this.list = list;
        this.delay=delay;
        this.clickRecyclerView = clickRecyclerView;
    }

    @NonNull
    @Override
    public ShowNamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShowNamesAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.shownamesmodel, parent, false), clickRecyclerView);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowNamesAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.onClickRecyclerView.onclick(holder.getAdapterPosition(), "Edit");
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.onClickRecyclerView.onclick(holder.getAdapterPosition(), "Delete");
            }
        });
      if (delay>=0)
        {
            Common.AnimationOnStart(holder.cardView, delay);
            delay += 0.1;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView name;
        ImageView edit, delete;
        CardView cardView;
        onclickNames onClickRecyclerView;

        public ViewHolder(@NonNull View itemView, onclickNames onClickRecyclerView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            edit = itemView.findViewById(R.id.Edit);
            delete = itemView.findViewById(R.id.Delete);
            cardView = itemView.findViewById(R.id.cardViewNames);
            this.onClickRecyclerView = onClickRecyclerView;
        }


    }

}
