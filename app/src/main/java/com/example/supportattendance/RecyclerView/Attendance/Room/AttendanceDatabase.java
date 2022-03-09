package com.example.supportattendance.RecyclerView.Attendance.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.supportattendance.RecyclerView.Attendance.AttendanceModel;

@Database(entities = {AttendanceModel.class}, version = 1, exportSchema = false)
public abstract class AttendanceDatabase extends RoomDatabase {

    public abstract AttendanceDOA attendanceDOA();
}
