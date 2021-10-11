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
        simpleArcLoader = findViewById(R.id.loader);
        simpleArcLoader2 = findViewById(R.id.loader2);
        tvTanggal = findViewById(R.id.tanggal);
        hasil = formatter.format(tanggal);
        tvTanggal.setText(hasil);
        tvYa = findViewById(R.id.tvTaat);
        tvTidak = findViewById(R.id.tvTidakTaat);
        scrollView = findViewById(R.id.scrollStats);

        BottomNavigationView bottomNavigationView  = findViewById(R.id.nav_view);

        bottomNavigationView.setSelectedItemId(R.id.monitoring);

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


                    case R.id.monitoring:

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

        fetchData();






    }

    private void fetchData() {
        String url  = "http://192.168.13.64/Esamsat/monitor.php/";

        simpleArcLoader.start();
        simpleArcLoader2.start();

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());

                            tvYa.setText(jsonObject.getString("keterangan"));
                            tvTidak.setText(jsonObject.getString("jumlah"));


                            yValues.add(new PieEntry(Integer.parseInt(tvYa.getText().toString()), "Taat Pajak"));
                            yValues.add(new PieEntry(Integer.parseInt(tvTidak.getText().toString()), "Tidak Taat Pajak"));

                            pieChart.getDescription().setEnabled(false);
                            pieChart.setExtraOffsets(5, 10, 5, 5);

                            pieChart.setDragDecelerationFrictionCoef(0.99f);

                            pieChart.setDrawHoleEnabled(true);
                            pieChart.setHoleColor(Color.WHITE);
                            pieChart.setTransparentCircleRadius(61f);
                            pieChart.setRotationAngle(320);

                            pieChart.animateY(1500, Easing.EaseInOutCubic);
                            PieDataSet dataSet = new PieDataSet(yValues, "sadarpajak");
                            dataSet.setSliceSpace(3f);
                            dataSet.setSelectionShift(5f);
                            ValueFormatter vf = new ValueFormatter() { //value format here, here is the overridden method
                                @Override
                                public String getFormattedValue(float value) {
                                    return ""+(int)value;
                                }
                            };
                            dataSet.setValueFormatter(vf);
                            dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                            PieData data = new PieData(dataSet);
                            data.setValueTextSize(10f);
                            data.setValueTextColor(Color.YELLOW);

                            pieChart.setData(data);

                            simpleArcLoader.stop();
                            simpleArcLoader2.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                            simpleArcLoader2.setVisibility(View.GONE);
                            scrollView.setVisibility(View.VISIBLE);
                            pieChart.setVisibility(View.VISIBLE);


                        } catch (JSONException e) {
                            e.printStackTrace();
                            simpleArcLoader.stop();
                            simpleArcLoader2.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                            scrollView.setVisibility(View.VISIBLE);
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(Monitoring.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);






    }

}
