package com.example.esamsat.info.SamKel.PERIODE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.esamsat.R;

import java.util.ArrayList;
import java.util.List;

public class PeriodeBulan extends AppCompatActivity {
    Spinner spin1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periode_bulan);
        spin1 = (Spinner) findViewById(R.id.spinner1);

        spinBulan();
        spinBulanSelected();
        Bulan();




    }



    private void spinBulan() {
        spin1 = (Spinner) findViewById(R.id.spinner1);
        List<String> ListStts = new ArrayList<String>();
        ListStts.add("=====Periode Bulan=====");
        ListStts.add("JANUARI");
        ListStts.add("FEBRUARI ");
        ListStts.add("MARET");
        ListStts.add("APRIL");
        ListStts.add("MEI");
        ListStts.add("JUNI");
        ListStts.add("JULI");
        ListStts.add("AGUSTUS");
        ListStts.add("SEPTEMBER");
        ListStts.add("OKTOBER");
        ListStts.add("NOVEMBER");
        ListStts.add("DESEMBER");
        ArrayAdapter<String> Status = new ArrayAdapter<String>(PeriodeBulan.this, android.R.layout.simple_spinner_item, ListStts);
        Status.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(Status);
    }


    private void spinBulanSelected() {
        spin1 =(Spinner) findViewById(R.id.spinner1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void Bulan() {
    }
}