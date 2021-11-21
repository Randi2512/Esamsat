package com.example.esamsat.info.Pembayaran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esamsat.R;
import com.example.esamsat.api.Api;
import com.example.esamsat.api.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PembayaranActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private Api apiInterface;
    ArrayList<pembayaran> pembayaranArrayList;
    AdapterPembayaran adapterPembayaran;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        TextView marque1 = (TextView) this.findViewById(R.id.txtbayar);
        marque1.setSelected(true);
        recyclerView = findViewById(R.id.rv_pembayaran);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);



        fetchData("cara_pembayaran","");
    }

    private void fetchData(String cara_pembayaran, String key) {
        adapterPembayaran = new AdapterPembayaran(new ArrayList<>());
        apiInterface = ApiService.endpoint();
        Call<pembayaran> call = apiInterface.getcara_pembayaran();
        call.enqueue(new Callback<pembayaran>() {
            @Override
            public void onResponse(Call<pembayaran> call, Response<pembayaran> response) {
                Log.d("respons:", String.valueOf(response.body()));
                adapterPembayaran.setData(response.body().result);
                recyclerView.setAdapter(adapterPembayaran);
                adapterPembayaran.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<pembayaran> call, Throwable t) {
                Log.d("response::", t.toString());
                Toast.makeText(PembayaranActivity.this, "Error\n" + t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }
}