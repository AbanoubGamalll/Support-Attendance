package com.example.supportattendance.Pages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.supportattendance.R;
import com.example.supportattendance.RecyclerView.RecyclerViewCommunity.CommunityAdapter;
import com.example.supportattendance.RecyclerView.RecyclerViewCommunity.CommunityModel;
import com.example.supportattendance.RecyclerView.RecyclerViewDays.Room.DaysDOA;
import com.example.supportattendance.RecyclerView.RecyclerViewDays.Room.DaysDatabase;

import java.util.ArrayList;
import java.util.List;

public class Community extends AppCompatActivity {


    RecyclerView recyclerView;
    CommunityAdapter adapter;
    List<CommunityModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        /////////////////
        DaysDatabase db = Room.databaseBuilder(getApplicationContext(), DaysDatabase.class, "Days").allowMainThreadQueries().build();

        list.add(new CommunityModel("Android", db.DaysDOA().NumOfSessions("Android"), R.drawable.android_logo));
        list.add(new CommunityModel("Game", db.DaysDOA().NumOfSessions("Game"), R.drawable.android_logo));
        list.add(new CommunityModel("Media", db.DaysDOA().NumOfSessions("Media"), R.drawable.android_logo));
        list.add(new CommunityModel("Network", db.DaysDOA().NumOfSessions("Network"), R.drawable.android_logo));
        list.add(new CommunityModel("Cyber Security", db.DaysDOA().NumOfSessions("Cyber Security"), R.drawable.android_logo));
        list.add(new CommunityModel("HR", db.DaysDOA().NumOfSessions("HR"), R.drawable.android_logo));
        list.add(new CommunityModel("BR", db.DaysDOA().NumOfSessions("BR"), R.drawable.android_logo));
        list.add(new CommunityModel("Software Testing", db.DaysDOA().NumOfSessions("Software Testing"), R.drawable.android_logo));
        list.add(new CommunityModel("Web", db.DaysDOA().NumOfSessions("Web"), R.drawable.android_logo));


        ////////////////

        recyclerView = findViewById(R.id.recyclerviewCommunity);
        adapter = new CommunityAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder ad1 = new AlertDialog.Builder(this);
        ad1.setMessage("Are you sure you want to exit? ");
        ad1.setIcon(R.drawable.support_logo);
        ad1.setTitle(R.string.app_name);

        ad1.setCancelable(false);
        ad1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        ad1.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(Community.this, "See You Again!", Toast.LENGTH_SHORT).show();
                finishAffinity();
            }
        });
        AlertDialog alert = ad1.create();
        alert.show();
    }


    @Override
    protected void onPause() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        super.onPause();
    }


}