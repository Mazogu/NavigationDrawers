package com.example.micha.navigationactivity;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ListView list;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //toggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawerLayout);
        list = findViewById(R.id.drawer);
        addToDrawer();
        //toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open,R.string.drawer_closed);
        //drawer.addDrawerListener(toggle);
    }

    private void addToDrawer() {
        String[] names = getResources().getStringArray(R.array.activity_names);
        ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, names);
        list.setAdapter(nameAdapter);
    }
}
