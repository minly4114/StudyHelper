package com.sgs.studyhelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.zip.Inflater;

public class LoadActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    String pickedLanguage = "Russian";
    boolean isLangPicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isFirstStart = false;

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        if(sharedPreferences.getBoolean("isFirstStart", true)) {
            setContentView(R.layout.activity_firststart);
            createLangPickButtonListeners();
            createNextButtonListener();
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

    protected void createNextButtonListener() {
        Button nextBt = findViewById(R.id.bt_next);
        nextBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isLangPicked)
                {
                    // TODO Save design and load menu
                } else
                {
                    isLangPicked = true;
                    sharedPreferences.edit().
                            putString("Language", pickedLanguage).
                            apply();
                    // TODO Load next include activity (Design)
                }
            }
        });
    }

    protected void createLangPickButtonListeners()
    {
        RadioGroup rg = findViewById(R.id.rg_lang);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_russian)
                {
                    pickedLanguage = "Russian";
                } else if(checkedId == R.id.rb_english)
                {
                    pickedLanguage = "English";
                }
            }
        });
    }

    protected void createButtonListeners() {
        RadioGroup radioGroup = findViewById(R.id.rg_design);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case 0:
                        // TODO Setup current design
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
}
