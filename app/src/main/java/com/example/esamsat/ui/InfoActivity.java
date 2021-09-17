package com.example.esamsat.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.esamsat.R;
import com.example.esamsat.info.CekPajakActivity;
import com.example.esamsat.info.Pembayaran.PembayaranActivity;
import com.example.esamsat.info.Pengaduan;
import com.example.esamsat.info.PengaduanMasyarakat;
import com.example.esamsat.info.Peraturan.PeraturanPajak;
import com.example.esamsat.info.Peraturan.PeraturanpajakActivity;
import com.example.esamsat.info.SamKel.SamsatKeliling;
import com.example.esamsat.info.faq.faq;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InfoActivity extends AppCompatActivity {
        ImageButton img1, img2, img3, img4, img5,img6;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_info);


                img1 = (ImageButton) findViewById(R.id.img1);
                img2 = (ImageButton) findViewById(R.id.img2);
                img3 = (ImageButton) findViewById(R.id.img3);
                img4 = (ImageButton) findViewById(R.id.img4);
                img5 = (ImageButton) findViewById(R.id.img5);
                img6 = (ImageButton) findViewById(R.id.img6);

                img1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(InfoActivity.this, CekPajakActivity.class);
                                startActivity(intent);
                        }
                });
                img2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(InfoActivity.this, PembayaranActivity.class);
                                startActivity(intent);
                        }
                });
                img3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(InfoActivity.this, SamsatKeliling.class);
                                startActivity(intent);
                        }
                });
                img4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(InfoActivity.this, PeraturanpajakActivity.class);
                                startActivity(intent);
                        }
                });
                img5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(InfoActivity.this, PengaduanMasyarakat.class);
                                startActivity(intent);
                        }
                });
                img6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(InfoActivity.this, faq.class);
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