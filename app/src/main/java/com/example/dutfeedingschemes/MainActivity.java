package com.example.dutfeedingschemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button1;
    private Button Button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.registerbtn);
        button1=(Button) findViewById(R.id.login);
        Button2= (Button)  findViewById(R.id.admin);

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdmin();
            }
        });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                openLogin();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistry();
            }
        });

    }

    private void openLogin() {
        Intent intent1=  new Intent(this, loginactivity.class);
        startActivity(intent1);
    }

    public void openRegistry(){
        Intent intent = new Intent(this, activityregister.class);
        startActivity(intent);


    }
    public  void openAdmin(){
        Intent intent = new Intent(this, adminLogin.class);
        startActivity(intent);

    }
}