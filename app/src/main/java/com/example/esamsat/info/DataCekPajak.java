package com.example.esamsat.info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.esamsat.R;

public class DataCekPajak extends AppCompatActivity {
    TextView nopol,tahun,merk,warna,berlaku,biayap,sanksip,biayas,sanksis,admt,adms,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_cek_pajak);
        nopol= (TextView) findViewById(R.id.txtnoplat);
        tahun= (TextView) findViewById(R.id.txttahun);
        merk= (TextView) findViewById(R.id.txtmerk);
        warna= (TextView) findViewById(R.id.txtwarna);
        berlaku= (TextView) findViewById(R.id.txtberlaku);
        biayap= (TextView) findViewById(R.id.txtbiaya);
        sanksip= (TextView) findViewById(R.id.txtsanksipkb);
        biayas= (TextView) findViewById(R.id.txtbiayaswdkllj);
        sanksis= (TextView) findViewById(R.id.txtsanksiswd);
        biayas= (TextView) findViewById(R.id.txtbiayaswdkllj);
        adms= (TextView) findViewById(R.id.txtadmst);
        total=(TextView) findViewById(R.id.txttotal);

        Intent intent = getIntent();


    }
}