package com.androidtutorial.sportsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Sports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
    }

    public void chooseSport(View view){
        Intent intent;

        switch(view.getId()){
            case R.id.nbaBtn:
                intent = new Intent();
                intent.putExtra("SPORT","NBA");
                setResult(2,intent);
                finish();
        }

    }
}
