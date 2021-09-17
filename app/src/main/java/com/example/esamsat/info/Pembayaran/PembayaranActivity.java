package com.example.esamsat.info.Pembayaran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.esamsat.R;

import java.util.ArrayList;

public class PembayaranActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<pembayaran> pembayaranArrayList;
    AdapterPembayaran adapterPembayaran;
    String[] heading;
    String[] detail;
    int[] ImageResourceId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        recyclerView = findViewById(R.id.rv_pembayaran);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        pembayaranArrayList = new ArrayList<>();

        heading = new String[]{
                "BANK BNI",
                "BANK MANDIRI",
                "BANK BRI",
                 "BANK PERMATA",
                "BANK BCA",
                "CIMB NIAGA",
                "BANK NAGARI"


        };

        detail = new String[]{
                getString(R.string.BNI),
                getString(R.string.mandiri),
                getString(R.string.BRI),
                getString(R.string.Permata),
                getString(R.string.BCA),
                getString(R.string.Cimb),
                getString(R.string.nagari)



        };

        ImageResourceId = new int[]{
                R.drawable.bni,
                R.drawable.mandiri,
                R.drawable.bri,
                R.drawable.bankpermata,
                R.drawable.bankbca,
                R.drawable.cimbniaga,
                R.drawable.banknagari


        };

        getData();

    }

    private void getData() {

        for (int i = 0; i < heading.length; i++) {
            pembayaran pembayaran = new pembayaran(heading[i], detail[i], ImageResourceId[i]);
            pembayaranArrayList.add(pembayaran);

        }
        adapterPembayaran = new AdapterPembayaran(this, pembayaranArrayList);
        recyclerView.setAdapter(adapterPembayaran);
        adapterPembayaran.notifyDataChanged();

    }

}