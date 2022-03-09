package com.example.supportattendance.RecyclerView.RecyclerViewDays;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(tableName = "Days", primaryKeys = {"community", "date"})
public class DaysModel {
    @NonNull
    private String date;
    @NonNull
    private String community;

    public DaysModel(Date date, String community) {
        this.date = getStringTime(date);
        this.community = community;
    }

    public DaysModel() {
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static String getStringTime(Date t) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE   d/M/y");
        String strDate = formatter.format(t);
        return strDate;
    }

}
