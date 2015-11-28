package com.androidtutorial.sportsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    public static final int CHOOSE_SPORT = 2;
    public ArrayList<String> sports = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,sports);
        ListView lv  = (ListView) findViewById(R.id.sportsListView);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.addSportItem:
                Intent chooseSport = new Intent(this,Sports.class);
                startActivityForResult(chooseSport,CHOOSE_SPORT);
            case R.id.deleteSportItem:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(sports.contains(data.getExtras().getString("SPORT")))
            Toast.makeText(MainActivity.this, "This League Is Already On The List", Toast.LENGTH_SHORT).show();
        else
        sports.add(data.getExtras().getString("SPORT"));

        adapter.notifyDataSetChanged();
    }
}
