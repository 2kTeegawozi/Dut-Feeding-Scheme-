package com.example.dutfeedingschemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminLogin extends AppCompatActivity {
EditText Studentnoadmin,passwdlogin2;
Button logindirectory2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        Studentnoadmin = findViewById(R.id.Studentnoadmin);
        passwdlogin2 = findViewById(R.id.passwdlogin2);
        logindirectory2=findViewById(R.id.logindirectory2);

        logindirectory2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adminID= Studentnoadmin.getText().toString();
                String aDPwd= passwdlogin2.getText().toString();
                if (adminID.equals("")||aDPwd.equals("")){
                    Toast.makeText(adminLogin.this, "Please enter credentials!", Toast.LENGTH_SHORT).show();
                }
                else if (adminID.equals("Administer") && aDPwd.equals("BookingAdmin"))
                {
                    Intent intent = new Intent(getApplicationContext(), bookingDatactivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(adminLogin.this, "Incorrect  credentials!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}