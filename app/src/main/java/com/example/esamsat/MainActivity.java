package com.example.esamsat;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.esamsat.ui.InfoActivity;
import com.example.esamsat.ui.GIS.MapsActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class  MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView  = findViewById(R.id.nav_view);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem){
                    switch (menuitem.getItemId()){
                        case R.id.home:

                            return true;
                         case R.id.info:
                        startActivity(new Intent(getApplicationContext()
                                , InfoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                        case R.id.lokasi:
                        startActivity(new Intent(getApplicationContext()
                                , MapsActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                }


                return false;
            }
        });
    }
}