package com.example.esamsat.info.Peraturan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.esamsat.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class  PdfPeraturan extends AppCompatActivity {
    private final String TAG = "PdfPeraturan";
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_peraturan);

        String url = getIntent().getStringExtra("intent_pdf");
        Log.d(TAG, url);

        pdfView = findViewById(R.id.pdfView);

        new PdfDownload().execute(url);
    }
    public class PdfDownload extends AsyncTask<String, Void, InputStream>{

        protected InputStream doInBackground(String... strings){
            InputStream inputStream = null;

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                if (httpURLConnection.getResponseCode() == 200){
                    inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                }
            }catch (IOException ex){
                ex.printStackTrace();
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }

    }
}