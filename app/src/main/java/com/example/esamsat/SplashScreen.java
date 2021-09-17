package com.example.esamsat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.esamsat.info.CekPajakActivity;
import com.example.esamsat.ui.HomeActivity;
import com.example.esamsat.ui.InfoActivity;

public class SplashScreen extends AppCompatActivity {
    Handler handler;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent on = new Intent(SplashScreen.this, HomeActivity.class);
                startActivity(on);
                finish();
            }
        }, 2000);
    }
}
