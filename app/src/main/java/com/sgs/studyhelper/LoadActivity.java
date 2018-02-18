package com.sgs.studyhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        // Start loading

        // End loading

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
