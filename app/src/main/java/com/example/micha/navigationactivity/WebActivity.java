package com.example.micha.navigationactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {

    private WebView web;
    private final static String URL = "https://www.youtube.com/";
    private WebViewClient client;
    private WebSettings settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        web = findViewById(R.id.web);
        settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        client = new WebViewClient();
        web.setWebViewClient(client);

        web.loadUrl(URL);

    }
}
