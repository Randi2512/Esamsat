package com.example.esamsat.info.SamKel.PERIODE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.esamsat.R;
import com.example.esamsat.api.Api;
import com.example.esamsat.api.ApiService;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Periode extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private AdapterPeriode adapter;
    private Api apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periode);


        recyclerView = findViewById(R.id.rv_data1);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Get table form DB
        fetchData("periode", "");
    }

    private void fetchData(String type, String key) {

        adapter = new AdapterPeriode(new ArrayList<>());
        apiInterface = ApiService.endpoint();
        Call<periode_Samkel> call = apiInterface.getperiode_Samkel();
        call.enqueue(new Callback<periode_Samkel>() {
            @Override
            public void onResponse(Call<periode_Samkel> call, Response<periode_Samkel> response) {
                Log.d("respons:", String.valueOf(response.body()));

                adapter.setData(response.body().result);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<periode_Samkel> call, Throwable t) {
                Log.d("response::", t.toString());
                Toast.makeText(Periode.this, "Error\n" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });



    }


}

