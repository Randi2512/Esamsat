package com.example.esamsat.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.esamsat.R;

public class CekPajakActivity extends AppCompatActivity{
    Button btnproses;
    EditText nopol;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_pajak);
        nopol = (EditText) findViewById(R.id.edtNopol);
        addProsesAction();

    }

    private void addProsesAction() {
        btnproses = (Button) findViewById(R.id.btnproses);
        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String no = nopol.getText().toString();
                Intent intent = new Intent(CekPajakActivity.this ,DataCekPajak.class);
                startActivity(intent);
                finish();
            }
        });
    }
}