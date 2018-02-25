package com.sgs.studyhelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        /*
            Write your loading func
        */


        // Check for first start
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("isFirstStart", true)) {
            // TODO First start
        }
        // End loading

        // Load menu
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
