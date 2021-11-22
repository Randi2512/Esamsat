package com.example.esamsat.info.SamKel.PERIODE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.esamsat.R;
import com.example.esamsat.api.Api;
import com.example.esamsat.api.ApiService;
import com.example.esamsat.info.SamKel.UPTD.Adapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeriodeBulan extends AppCompatActivity {
    Spinner spin1;
    Intent i;
    String nama_uptd;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterSBulanan adapterSBulanan;
    private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periode_bulan);
        spin1 = (Spinner) findViewById(R.id.spinner1);
        recyclerView = findViewById(R.id.rv_datasamkel);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);



        fetchData("samkel","");

        spinBulan();
        spinBulanSelected();
        Bulan();
        i = getIntent();
        nama_uptd = i.getStringExtra("nama");



    }

    private void fetchData(String type, String key) {

        adapterSBulanan = new AdapterSBulanan() ;
        api = ApiService.endpoint();
        Call<periode_Samkel> call = api.getperiode_Samkel();
        call.enqueue(new Callback<periode_Samkel>() {
            @Override
            public void onResponse(Call<periode_Samkel> call, Response<periode_Samkel> response) {
                Log.d("respons:", String.valueOf(response.body()));

                adapterSBulanan.setData(response.body().result);
                recyclerView.setAdapter(adapterSBulanan);

            }

            @Override
            public void onFailure(Call<periode_Samkel> call, Throwable t) {
                Log.d("response::", t.toString());
                Toast.makeText(PeriodeBulan.this, "Tidak Ada SamKel Bulan ini ini", Toast.LENGTH_LONG).show();

            }
        });


    }


    private void spinBulan() {
        spin1 = (Spinner) findViewById(R.id.spinner1);
        List<String> ListStts = new ArrayList<String>();
        ListStts.add("1. JANUARI");
        ListStts.add("2. FEBRUARI ");
        ListStts.add("3. MARET");
        ListStts.add("4. APRIL");
        ListStts.add("5. MEI");
        ListStts.add("6. JUNI");
        ListStts.add("7. JULI");
        ListStts.add("8. AGUSTUS");
        ListStts.add("9. SEPTEMBER");
        ListStts.add("10. OKTOBER");
        ListStts.add("11. NOVEMBER");
        ListStts.add("12. DESEMBER");
        ArrayAdapter<String> Status = new ArrayAdapter<String>(PeriodeBulan.this, android.R.layout.simple_spinner_item, ListStts);
        Status.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(Status);
    }


    private void spinBulanSelected() {
        spin1 =(Spinner) findViewById(R.id.spinner1);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String bulan = spin1.getSelectedItem().toString();
                String angkaBulan  = bulan.split(" " )[0].replace(".","");
                Api api = ApiService.endpoint();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void Bulan() {
    }


}