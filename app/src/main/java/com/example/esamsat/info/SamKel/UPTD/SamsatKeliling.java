package com.example.esamsat.info.SamKel.UPTD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.esamsat.R;
import com.example.esamsat.info.SamKel.PERIODE.Periode;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SamsatKeliling extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;
    private Api apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samsat_keliling);


        recyclerView = findViewById(R.id.rv_data);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Get table form DB
        fetchData("uptd", "");
    }

    private void fetchData(String type, String key) {

        adapter = new Adapter(new ArrayList<>());
        apiInterface = ApiClient.getApiClient().create(Api.class);
        Call<Uptd> call = apiInterface.getUptd();
        call.enqueue(new Callback<Uptd>() {
            @Override
            public void onResponse(Call<Uptd> call, Response<Uptd> response) {
                Log.d("respons:", String.valueOf(response.body()));

                adapter.setData(response.body().result);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Uptd> call, Throwable t) {
                Log.d("response::", t.toString());
                Toast.makeText(SamsatKeliling.this, "Error\n" + t.toString(), Toast.LENGTH_LONG).show();
            }
        });



    }


    public void onClick(View view) {
        Intent intent = new Intent(SamsatKeliling.this, Periode.class);
        startActivity(intent);
    }
}
