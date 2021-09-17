package com.example.esamsat.info.Peraturan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;

import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import com.example.esamsat.R;



public class DetailPeraturan extends AppCompatActivity {

    TextView txtisi;
    Button btnPdf;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_peraturan);
        txtisi = findViewById(R.id.txtIsi);
        btnPdf=findViewById(R.id.btnPdf);

        String isi = getIntent().getStringExtra("intent_isi");
        String pdf = getIntent().getStringExtra("intent_pdf");
        txtisi.setText(""+isi);



        btnPdf.setOnClickListener(view -> {
            Intent intent = new Intent(DetailPeraturan.this,PdfPeraturan.class);
            intent.putExtra("intent_pdf",pdf);
            startActivity(intent);
        });
    }
}