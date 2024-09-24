package com.example.dutfeedingschemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class homeactivity extends AppCompatActivity {
private RadioGroup radiogrp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        getSupportActionBar().setTitle("Food Parcel collecting");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        radiogrp=findViewById(R.id.radiogrp);



                radiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId== R.id.stevebiko){
                            Intent intent = new Intent(getApplicationContext(),crudactivity.class);
                            startActivity(intent);

                        }
                        else if(checkedId==R.id.sultan)
                        {
                            Intent intent = new Intent(getApplicationContext(),sultan.class);
                            startActivity(intent);
                        }
                        else if (checkedId == R.id.cityc)
                        {
                            Intent intent = new Intent(getApplicationContext(),cityactivity.class);
                            startActivity(intent);
                        }
                        else if (checkedId == R.id.ritson)
                        {
                            Intent intent = new Intent(getApplicationContext(),ritsonactivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }




}