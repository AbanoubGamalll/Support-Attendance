package com.example.supportattendance.RecyclerView.Attendance;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "Attendance", primaryKeys = {"name", "Date"})
public class AttendanceModel {
    @NonNull
    private String name;
    @NonNull
    private String Date;
    private String community;

    public AttendanceModel() {
    }

    public AttendanceModel(String name, String date, String community) {
        this.name = name;
        Date = date;
        this.community = community;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }
}
