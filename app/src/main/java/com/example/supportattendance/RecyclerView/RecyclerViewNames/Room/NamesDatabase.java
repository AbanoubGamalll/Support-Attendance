package com.example.supportattendance.RecyclerView.RecyclerViewNames.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.supportattendance.RecyclerView.RecyclerViewNames.NamesModel;

@Database(entities = {NamesModel.class}, version = 1, exportSchema = false)
public abstract class NamesDatabase extends RoomDatabase {
    public abstract NamesDOA namesDOA();
}
