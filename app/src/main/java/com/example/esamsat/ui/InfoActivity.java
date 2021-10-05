package com.example.esamsat.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.esamsat.R;
import com.example.esamsat.TentangAplikasi.LayananSamsat;
import com.example.esamsat.TentangAplikasi.Panduan;
import com.example.esamsat.ui.home.HomeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InfoActivity extends AppCompatActivity {

   ImageView cardservice,cardpanduan;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_info);

                cardservice = (ImageView) findViewById(R.id.cardservice);
                cardpanduan = (ImageView) findViewById(R.id.cardpanduan);


                cardservice.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Intent intent = new Intent(InfoActivity.this, LayananSamsat.class);
                                startActivity(intent);

                        }
                });


                cardpanduan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Intent intent = new Intent(InfoActivity.this, Panduan.class);
                                startActivity(intent);
                        }
                });




                BottomNavigationView bottomNavigationView  = findViewById(R.id.nav_view);

                bottomNavigationView.setSelectedItemId(R.id.info);

                bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem menuitem){
                                switch (menuitem.getItemId()){
                                        case R.id.home:
                                                startActivity(new Intent(getApplicationContext()
                                                        , HomeActivity.class));
                                                overridePendingTransition(0,0);
                                                return true;
                                        case R.id.info:

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