package com.example.supportattendance.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Toast;

import com.example.supportattendance.R;
import com.example.supportattendance.RecyclerView.Attendance.AttendanceModel;
import com.example.supportattendance.RecyclerView.Attendance.Room.AttendanceDatabase;
import com.example.supportattendance.RecyclerView.Attendance.AttendeanceAdapter;

import java.util.ArrayList;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AttendeanceAdapter adapter;
    List<AttendanceModel> list = new ArrayList<>();

    String comm;
    String day;
    AttendanceDatabase ADB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        //name in comm with date
        comm = getIntent().getExtras().getString("comm");
        day = getIntent().getExtras().getString("day");

        ///////////////// room
        ADB = Room.databaseBuilder(getApplicationContext(), AttendanceDatabase.class, "Attendance").allowMainThreadQueries().build();

        list = ADB.attendanceDOA().DBList(comm, day);
        ////////////////recyclerview
        recyclerView = findViewById(R.id.RecyclerViewNames);
        adapter = new AttendeanceAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}