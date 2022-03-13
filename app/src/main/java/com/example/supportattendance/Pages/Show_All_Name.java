package com.example.supportattendance.Pages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.supportattendance.R;
import com.example.supportattendance.RecyclerView.RecyclerViewNames.NamesModel;
import com.example.supportattendance.RecyclerView.RecyclerViewNames.Room.NamesDatabase;
import com.example.supportattendance.RecyclerView.RecyclerViewShowAllNames.ShowNamesAdapter;
import com.example.supportattendance.RecyclerView.RecyclerViewShowAllNames.onclickNames;

import java.util.ArrayList;
import java.util.List;

public class Show_All_Name extends AppCompatActivity implements onclickNames {
    NamesDatabase Ndb;
    RecyclerView recyclerView;
    ShowNamesAdapter adapter;
    List<NamesModel> list = new ArrayList<>();
    TextView num;
    String comm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_name);
        num = findViewById(R.id.Number_Of_Names);
        comm = getIntent().getExtras().getString("comm");
        Ndb = Room.databaseBuilder(getApplicationContext(), NamesDatabase.class, "Names").allowMainThreadQueries().build();
        list = Ndb.namesDOA().DBList(comm);
        num.setText("" + list.size());
        ////////////////recyclerview
        recyclerView = findViewById(R.id.RecyclerViewShowNames);
        adapter = new ShowNamesAdapter(list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public void onclick(int position, String s) {
        if (s.equals("Edit")) {
           Edit(position);
        } else if (s.equals("Delete")) {
            Ndb.namesDOA().DeleteName(list.get(position));
        }
        list.clear();
        list= Ndb.namesDOA().DBList(comm);
        adapter = new ShowNamesAdapter(list, this,-1);
        recyclerView.setAdapter(adapter);
        num.setText("" + list.size());
    }

    private void Edit(int position) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("Edit Name: ");
        EditText input = new EditText(this);
        input.setText(list.get(position).getName());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setPositiveButton("Save",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (!input.getText().toString().equals("")) {
                            try {
                                Ndb.namesDOA().DeleteName(list.get(position));
                                Ndb.namesDOA().InsertName(new NamesModel(input.getText().toString(),comm));
                                list.clear();
                                list= Ndb.namesDOA().DBList(comm);
                                adapter = new ShowNamesAdapter(list, Show_All_Name.this,-1);
                                recyclerView.setAdapter(adapter);
                                num.setText("" + list.size());
                            }catch (Exception e)
                            {
                                Toast.makeText(Show_All_Name.this, "Name Already Exist", Toast.LENGTH_SHORT).show();
                                Ndb.namesDOA().InsertName(list.get(position));
                                list.clear();
                                list= Ndb.namesDOA().DBList(comm);
                                adapter = new ShowNamesAdapter(list, Show_All_Name.this,-1);
                                recyclerView.setAdapter(adapter);
                                num.setText("" + list.size());
                            }

                        } else {
                            Toast.makeText(Show_All_Name.this, "Write Name To Edit", Toast.LENGTH_SHORT).show();
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