package com.example.esamsat.TentangAplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.esamsat.R;
import com.github.barteksc.pdfviewer.PDFView;

public class Panduan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan);

        PDFView pdfView = (PDFView) findViewById(R.id.pdfView);

        pdfView.fromAsset("manual.pdf").load();
    }
}