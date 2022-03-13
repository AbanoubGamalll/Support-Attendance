package com.example.supportattendance.Pages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.supportattendance.R;
import com.example.supportattendance.RecyclerView.RecyclerViewCommunity.CommunityAdapter;
import com.example.supportattendance.RecyclerView.RecyclerViewCommunity.CommunityModel;
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
        list.add(new CommunityModel("PR", db.DaysDOA().NumOfSessions("BR"), R.drawable.android_logo));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_firebase, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.download:
                connect(0);
                break;
            case R.id.upload:
                connect(1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void firebaseUpload() {
        Toast.makeText(this, "U", Toast.LENGTH_SHORT).show();
    }

    private void firebaseDownload() {
        Toast.makeText(this, "D", Toast.LENGTH_SHORT).show();
    }

    private void connect(int n) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Enter Password to Connect: ");
        EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (!input.getText().toString().equals("")) {
                            if (input.getText().toString().equals("0")) {
                                Toast.makeText(Community.this, "Password Correct", Toast.LENGTH_SHORT).show();
                                if (n == 0) {
                                    firebaseDownload();
                                } else if (n == 1) {
                                    firebaseUpload();
                                }
                            } else {
                                Toast.makeText(Community.this, "Password Not Correct", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Community.this, "Password is empty", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }


}