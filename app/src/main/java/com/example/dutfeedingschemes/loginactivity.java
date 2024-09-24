package com.example.dutfeedingschemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {
    EditText passwdlogin,Studentno;
    Button logindirectory;
    regLoginDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        getSupportActionBar().setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        passwdlogin = (EditText)  findViewById(R.id.passwdlogin);
        Studentno = (EditText)  findViewById(R.id.Studentno);

        logindirectory =(Button)  findViewById(R.id.logindirectory);
        db= new regLoginDbHelper(this);
        logindirectory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer studNo= Studentno.getText().length();
                String pwd= passwdlogin.getText().toString();
                if (studNo.equals("")||pwd.equals("")){
                    Toast.makeText(loginactivity.this, "Please enter credentials!", Toast.LENGTH_SHORT).show();
                }

                else {

                        Boolean results = db.checkEntries(studNo, pwd);

                         if (results == true) {
                            Intent intent = new Intent(getApplicationContext(), homeactivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(loginactivity.this, "Invalid Credentials \n Check Student number & Password", Toast.LENGTH_SHORT).show();
                        }

                }

            }
        });

    }
}