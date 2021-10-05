package com.example.esamsat.TentangAplikasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.esamsat.R;

public class LayananSamsat extends AppCompatActivity {
     CardView cd1,cd2,cd3,cd4,cd5,cd6,cd7,cd8,cd9,cd10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layanan_samsat);

        cd1 = (CardView) findViewById(R.id.cd1);
        cd2 = (CardView) findViewById(R.id.cd2);
        cd3 = (CardView) findViewById(R.id.cd3);
        cd4 = (CardView) findViewById(R.id.cd4);
        cd5 = (CardView) findViewById(R.id.cd5);
        cd6 = (CardView) findViewById(R.id.cd6);
        cd7 = (CardView) findViewById(R.id.cd7);
        cd8 = (CardView) findViewById(R.id.cd8);
        cd9 = (CardView) findViewById(R.id.cd9);
        cd10 = (CardView) findViewById(R.id.cd10);


        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/11g1BuTCP0iMVaOvK5sAoXi-20Ru6d-zb/view?usp=sharing");
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1zmA2p0JawHtlEtuw4lnZlB1tNcrABfxW/view?usp=sharing");
            }
        });
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1EXhmzxFchOwPWfbRokE7DHfwDGBqeelt/view?usp=sharing");
            }
        });

        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1Wnx4J-KTIu0SXwHa6hEMwFlPu2sqQO5W/view?usp=sharing");
            }
        });
        cd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1Aa_UUGun9EqZZhIetx7-SJiHrlngni0v/view?usp=sharing");
            }
        });

        cd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1pzpIbC1bI0ZM3wvMYZm-RteZv_cmcd0C/view?usp=sharing");
            }
        });
        cd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1LIWGY4su-o3Jf5pDLjN5DQopip647Xmw/view?usp=sharing");
            }
        });
        cd8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1D9wmwegyfJGb24KnL_PBZRmt7kKL58Ey/view?usp=sharing");
            }
        });
        cd9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1fFRhRCPMa3AZI7YD2uGG8zCPrNbZ9I6z/view?usp=sharing");
            }
        });
        cd10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://drive.google.com/file/d/1A0obYIQHn7t5PJhMIoJN2fWDCgDp-658/view?usp=sharing");
            }
        });




    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}