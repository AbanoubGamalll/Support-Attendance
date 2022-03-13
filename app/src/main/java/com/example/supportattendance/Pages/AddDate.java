package com.example.supportattendance.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.supportattendance.R;
import com.example.supportattendance.RecyclerView.Attendance.AttendanceModel;
import com.example.supportattendance.RecyclerView.Attendance.OnClickNamesRecyclerView;
import com.example.supportattendance.RecyclerView.Attendance.Room.AttendanceDatabase;
import com.example.supportattendance.RecyclerView.RecyclerViewNames.NamesAdapter;
import com.example.supportattendance.RecyclerView.RecyclerViewNames.NamesModel;
import com.example.supportattendance.RecyclerView.RecyclerViewNames.Room.NamesDatabase;

import java.util.ArrayList;
import java.util.List;

public class AddDate extends AppCompatActivity implements OnClickNamesRecyclerView {
    RecyclerView recyclerView;
    NamesAdapter adapter;
    List<NamesModel> list = new ArrayList<>();
    String comm;
    String day;
    NamesDatabase Ndb;
    AttendanceDatabase Adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_date);

        comm = getIntent().getExtras().getString("comm");
        day = getIntent().getExtras().getString("day");
        /////////
        Ndb = Room.databaseBuilder(getApplicationContext(), NamesDatabase.class, "Names").allowMainThreadQueries().build();
        Adb = Room.databaseBuilder(getApplicationContext(), AttendanceDatabase.class, "Attendance").allowMainThreadQueries().build();

        list = Ndb.namesDOA().DBList(comm);
        ////////////////recyclerview
        recyclerView = findViewById(R.id.RecyclerViewShow);
        adapter = new NamesAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public void onclick(int position, Boolean Attendee, Boolean Task) {
        try {
            Adb.attendanceDOA().InsertAttendance(new AttendanceModel(list.get(position).getName(), day, comm, Attendee, Task));
        } catch (Exception e) {
            Adb.attendanceDOA().UpdateDate(new AttendanceModel(list.get(position).getName(), day, comm, Attendee, Task));
        }
        if (!Attendee && !Task) {
            Adb.attendanceDOA().DeleteAttendance(new AttendanceModel(list.get(position).getName(), day, comm, Attendee, Task));
        }
    }

    public void Done(View view) {
        Intent intent = new Intent(this, Community.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        Toast.makeText(this, "Session is saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Done(null);
    }
}