package com.example.supportattendance.RecyclerView.RecyclerViewDays.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.supportattendance.RecyclerView.RecyclerViewDays.DaysModel;

import java.util.List;

@Dao
public interface DaysDOA {

    @Insert
    void InsertDate(DaysModel daysModel);

    @Delete
    void DeleteDate(DaysModel daysModel);

    @Query("delete from Days")
    void DeleteAll();

    @Update
    void UpdateDate(DaysModel daysModel);

    @Query("select * from Days where community=:comm")
    List<DaysModel> DBList(String comm);

    @Query("select * from Days")
    List<DaysModel> DBList();

    @Query("select count(*) from Days where community=:comm")
    int NumOfSessions(String comm);

}
