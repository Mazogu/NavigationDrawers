package com.example.micha.navigationactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.micha.navigationactivity.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() ;
    protected DrawerLayout drawer;
    protected ListView list;
    protected ActionBarDrawerToggle toggle;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        final String activityTitle = getTitle().toString();

        drawer = findViewById(R.id.drawerLayout);
        list = findViewById(R.id.drawer);
        addToDrawer();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selection = ((TextView) view).getText().toString();
                if(selection.equals(getResources().getString(Constants.StringIDs.MAINID))){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else if(selection.equals(getResources().getString(Constants.StringIDs.POWERID))){
                    Intent intent = new Intent(getApplicationContext(),NumberActivity.class);
                    startActivity(intent);
                }
                else if(selection.equals(getResources().getString(Constants.StringIDs.CAMERAID))){
                    Intent intent = new Intent(getApplicationContext(),CameraActivity.class);
                    startActivity(intent);
                }
                else if(selection.equals(getResources().getString(Constants.StringIDs.MEDIAID))){
                    Intent intent = new Intent(getApplicationContext(),MediaActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(selection.equals(getResources().getString(Constants.StringIDs.WEBID))){
                    Intent intent = new Intent(getApplicationContext(),WebActivity.class);
                    startActivity(intent);
                }
            }
        });
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open,R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(R.string.Nav);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(activityTitle);
                invalidateOptionsMenu();
            }
        };
        toggle.setDrawerIndicatorEnabled(true);
        drawer.addDrawerListener(toggle);
    }

    private void addToDrawer() {
        String[] names = getResources().getStringArray(R.array.activity_names);
        ArrayAdapter<String> nameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, names);
        list.setAdapter(nameAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);
        return true;
    }
}
