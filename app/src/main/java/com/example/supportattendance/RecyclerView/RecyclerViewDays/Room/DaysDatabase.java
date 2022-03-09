package com.example.supportattendance.RecyclerView.RecyclerViewDays.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.supportattendance.RecyclerView.RecyclerViewDays.DaysModel;

@Database(entities = {DaysModel.class}, version = 1, exportSchema = false)
public abstract class DaysDatabase extends RoomDatabase {
    public abstract DaysDOA DaysDOA();
}
