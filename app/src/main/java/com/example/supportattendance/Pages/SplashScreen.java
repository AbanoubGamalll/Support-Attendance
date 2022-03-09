package com.example.supportattendance.Pages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.supportattendance.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);

        YoYo.with(Techniques.Bounce).duration(700).repeat(5).playOn(findViewById(R.id.imageView2));
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Community.class);
                startActivity(intent);
                finish();
            }
        }, 3* 1000);


    }
}