package com.example.esamsat.CekPajak;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.example.esamsat.R;

public class DataCekPajak extends AppCompatActivity {
    TextView nopol, tahun, merk, warna, berlaku, biayap, sanksip, biayas, sanksis, admt, adms, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_cek_pajak);
        nopol = (TextView) findViewById(R.id.txtnoplat);
        tahun = (TextView) findViewById(R.id.txttahun);
        merk = (TextView) findViewById(R.id.txtmerk);
        warna = (TextView) findViewById(R.id.txtwarna);
        berlaku = (TextView) findViewById(R.id.txtberlaku);
        biayap = (TextView) findViewById(R.id.txtbiaya);
        sanksip = (TextView) findViewById(R.id.txtsanksipkb);
        biayas = (TextView) findViewById(R.id.txtbiayaswdkllj);
        sanksis = (TextView) findViewById(R.id.txtsanksiswd);
        biayas = (TextView) findViewById(R.id.txtbiayaswdkllj);
        admt=(TextView) findViewById(R.id.txtadmtn);
        adms = (TextView) findViewById(R.id.txtadmst);
        total= (TextView) findViewById(R.id.txttotal);


        Intent intentproses = getIntent();
        nopol.setText((String)intentproses.getSerializableExtra("NoKendaraan"));
        tahun.setText((String)intentproses.getSerializableExtra("TahunKendaraan"));
        merk.setText((String)intentproses.getSerializableExtra("MerkKendaraan"));
        warna.setText((String)intentproses.getSerializableExtra("WarnaKendaraan"));
        berlaku.setText((String)intentproses.getSerializableExtra("TglStnk"));
        biayap.setText((String)intentproses.getSerializableExtra("BiayaPKB"));
        sanksip.setText((String)intentproses.getSerializableExtra("SanksiPKB"));
        biayas.setText((String)intentproses.getSerializableExtra("BiayaSwdkllj"));
        sanksis.setText((String)intentproses.getSerializableExtra("SanksiSwdkllj"));
        admt.setText((String)intentproses.getSerializableExtra("ADMTnkb"));
        adms.setText((String)intentproses.getSerializableExtra("ADMStnk"));
        total.setText((String)intentproses.getSerializableExtra("Total"));

    }
    public boolean onCreateOptionMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}