package com.sgs.studyhelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isFirstStart = false;

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("isFirstStart", true)) {
            setContentView(R.layout.activity_firststart);
            createButtonListeners();
            isFirstStart = true;
        }
        else
        {
            loadPickedLayout(sharedPreferences.getString("CurrentDesign", "White"));
        }

        if(!isFirstStart) {
            loadMenuActivity();
        }
    }

    protected  void loadMenuActivity()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void loadPickedLayout(String design) {
        switch(design)
        {
            case "White":
                setContentView(R.layout.activity_load_white);
                break;
            case "Green":
                setContentView(R.layout.activity_load_green);
                break;
            case "Dark":
                setContentView(R.layout.activity_load_dark);
                break;
            default:
                setContentView(R.layout.activity_load_white);
        }
    }

    protected void createButtonListeners()
    {
        RadioGroup radioGroup = findViewById(R.id.rg_design);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case 0:

                        break;
                    case 1:

                        break;
                    case 2:

                        break;
                    default:

                        break;
                }
            }
        });

    }

    protected void bt_GoToMenuPressed()
    {

    }
}
