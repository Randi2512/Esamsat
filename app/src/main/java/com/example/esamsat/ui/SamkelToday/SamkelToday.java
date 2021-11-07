package com.example.esamsat.ui.SamkelToday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.esamsat.R;
import com.example.esamsat.api.Api;
import com.example.esamsat.api.ApiService;
import com.example.esamsat.ui.GIS.MapsActivity;
import com.example.esamsat.ui.InfoActivity;
import com.example.esamsat.ui.MONITOR.Monitoring;
import com.example.esamsat.ui.home.HomeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SamkelToday extends AppCompatActivity {

private RecyclerView recyclerView;
private RecyclerView.LayoutManager layoutManager;
private AdapterSToday adapterSToday;
private Api api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samkel_today);


        recyclerView = findViewById(R.id.rv_datasamkel);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        BottomNavigationView bottomNavigationView  = findViewById(R.id.nav_view);

        bottomNavigationView.setSelectedItemId(R.id.Samkel);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem){
                switch (menuitem.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                        ,HomeActivity.class));
                        overridePendingTransition(0,0);

                    case R.id.Samkel:

                        return true;

                    case R.id.info:
                        startActivity(new Intent(getApplicationContext()
                                , InfoActivity.class));
                        overridePendingTransition(0,0);
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



        fetchData("samkel","");
    }

    private void fetchData(String type, String key) {
        adapterSToday = new AdapterSToday(new ArrayList<>());
        api = ApiService.endpoint();
        Call<samkel_Today> call = api.getsamkel_Today();
        call.enqueue(new Callback<samkel_Today>() {
            @Override
            public void onResponse(Call<samkel_Today> call, Response<samkel_Today> response) {
                Log.d("respons:", String.valueOf(response.body()));

                adapterSToday.setData(response.body().result);
                recyclerView.setAdapter(adapterSToday);
                adapterSToday.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<samkel_Today> call, Throwable t) {
                Log.d("response::", t.toString());
                Toast.makeText(SamkelToday.this, "Tidak Ada SamKel Hari ini", Toast.LENGTH_LONG).show();
            }
        });
    }





}
