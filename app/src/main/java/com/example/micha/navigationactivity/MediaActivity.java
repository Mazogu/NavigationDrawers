package com.example.micha.navigationactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

public class MediaActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup view = (ViewGroup) findViewById(R.id.content);
        getLayoutInflater().inflate(R.layout.activity_media,view);
    }
}
