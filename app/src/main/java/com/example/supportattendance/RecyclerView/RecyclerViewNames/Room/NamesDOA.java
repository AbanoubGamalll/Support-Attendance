package com.example.supportattendance.RecyclerView.RecyclerViewNames.Room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.supportattendance.RecyclerView.RecyclerViewNames.NamesModel;

import java.util.List;

@Dao
public interface NamesDOA {
    @Insert
    void InsertName(NamesModel namesModel);

    @Delete
    void DeleteName(NamesModel namesModel);

    @Query("delete from Names")
    void DeleteAll();

    @Update
    void UpdateDate(NamesModel namesModel);

    @Query("select * from Names where community=:comm")
    List<NamesModel> DBList(String comm);

    @Query("select * from Names")
    List<NamesModel> DBList();
}
