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
    private Boolean Task;
    private Boolean Attendee;
    private String community;

    public AttendanceModel() {
    }

    public AttendanceModel(@NonNull String name, @NonNull String date, String community, Boolean attendee, Boolean task) {
        this.name = name;
        Date = date;
        Task = task;
        Attendee = attendee;
        this.community = community;
    }

    public Boolean getAttendee() {
        return Attendee;
    }

    public void setAttendee(Boolean attendee) {
        Attendee = attendee;
    }

    public Boolean getTask() {
        return Task;
    }

    public void setTask(Boolean task) {
        Task = task;
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
