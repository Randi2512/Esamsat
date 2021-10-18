package com.example.esamsat.info.Peraturan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.esamsat.R;
import com.example.esamsat.api.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class PeraturanPajak extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PeraturanAdapter peraturanAdapter;
    private final String TAG = "PeraturanPajak";
    private List<Peraturan.Result> results = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peraturan_pajak);
        getDataFromApi();
        setupView();
        setupRecyclerView();
    }




    private void setupView() {
        recyclerView = findViewById(R.id.rv_data);

    }
    private void setupRecyclerView() {
        peraturanAdapter = new PeraturanAdapter(results, new PeraturanAdapter.OnAdapterListener() {
            @Override
            public void onClick(Peraturan.Result result) {
                Intent intent = new Intent(PeraturanPajak.this, DetailPeraturan.class);
                intent.putExtra("intent_nama",result.getNama());
                intent.putExtra("intent_isi",result.getIsi());
                intent.putExtra("intent_pdf",result.getUrl());

                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(peraturanAdapter);
    }
    private void getDataFromApi() {

        ApiService.endpoint().getPeraturan()
                .enqueue(new Callback<Peraturan>() {
                    @Override
                    public void onResponse(Call<Peraturan> call, Response<Peraturan> response) {
//                        Log.d( TAG, response.toString());
                        if (response.isSuccessful()) {
                            List<Peraturan.Result> results = response.body().getResult();
                            Log.d(TAG, results.toString());
                            peraturanAdapter.setData(results);
                        }
                    }

                    @Override
                    public void onFailure(Call<Peraturan> call, Throwable t) {
                        Log.d( TAG, t.toString());

                    }
                });

    }


}