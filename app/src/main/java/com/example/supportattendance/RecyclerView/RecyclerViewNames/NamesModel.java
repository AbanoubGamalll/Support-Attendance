package com.example.supportattendance.RecyclerView.RecyclerViewNames;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "Names", primaryKeys = {"Name", "Community"})
public class NamesModel {
    @NonNull
    private String Name;
    @NonNull
    private String Community;

    public NamesModel() {
    }

    public NamesModel(String name, String community) {
        Name = name;
        Community = community;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCommunity() {
        return Community;
    }

    public void setCommunity(String community) {
        Community = community;
    }
}
