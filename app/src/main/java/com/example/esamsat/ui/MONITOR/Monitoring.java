package com.example.esamsat.ui.MONITOR;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.esamsat.R;
import com.example.esamsat.ui.GIS.MapsActivity;
import com.example.esamsat.ui.InfoActivity;
import com.example.esamsat.ui.SamkelToday.SamkelToday;
import com.example.esamsat.ui.home.HomeActivity;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.JsonObject;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Monitoring extends AppCompatActivity {
    PieChart pieChart;
    SimpleArcLoader simpleArcLoader,simpleArcLoader2;
    TextView tvTanggal,tvYa,tvTidak;
    ScrollView scrollView;
    List<PieEntry> yValues = new ArrayList<>();
    String  pola = "EEEE, dd MMMM YYYY";;
    String hasil = null;
    Date tanggal = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat(pola);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);
        pieChart = findViewById(R.id.pieChart);

        tvTanggal = findViewById(R.id.tanggal);
        hasil = formatter.format(tanggal);
        tvTanggal.setText(hasil);


        BottomNavigationView bottomNavigationView  = findViewById(R.id.nav_view);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuitem){
                switch (menuitem.getItemId()){

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext()
                                , HomeActivity.class));
                        overridePendingTransition(0,0);

                    case R.id.Samkel:
                        startActivity(new Intent(getApplicationContext()
                                , SamkelToday.class));
                        overridePendingTransition(0,0);

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

        PieChart pieChart = findViewById(R.id.pieChart);

        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(761019, "Taat Pajak"));
        visitors.add(new PieEntry(253673, "Tidak Taat Pajak"));





        PieDataSet pieDataSet = new PieDataSet(visitors, "Masyarakat Sadar Pajak");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText(" Data Masyarakat Sadar Pajak/Tidak");
        pieChart.animate();




    }

}
