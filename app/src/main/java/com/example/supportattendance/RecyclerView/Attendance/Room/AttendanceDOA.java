package com.example.supportattendance.RecyclerView.Attendance.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.supportattendance.RecyclerView.Attendance.AttendanceModel;

import java.util.List;

@Dao
public interface AttendanceDOA {
    @Insert
    void InsertAttendance(AttendanceModel attendanceModel);

    @Delete
    void DeleteAttendance(AttendanceModel attendanceModel);

    @Query("delete from Attendance")
    void DeleteAll();

    @Query("delete from Attendance where name=:name and Date=:date and community= :comm")
    void DeleteAttendance(String name, String date, String comm);

    @Update
    void UpdateDate(AttendanceModel attendanceModel);

    @Query("select * from Attendance where community=:comm AND Date=:day")
    List<AttendanceModel> DBList(String comm, String day);

    @Query("select * from Attendance")
    List<AttendanceModel> DBList();

}
