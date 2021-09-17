package com.example.esamsat.info;

import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Bundle;

import com.example.esamsat.R;

public class Pengaduan extends AppCompatActivity {


    WebView webView;
    WebSettings websettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaduan);

        webView= (WebView)findViewById(R.id.webView);
        websettings= webView.getSettings();
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://dpkd.sumbarprov.go.id/complain-handling.html");
    }
}