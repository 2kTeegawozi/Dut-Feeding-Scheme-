package com.example.dutfeedingschemes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activityregister extends AppCompatActivity {
EditText passwd,confirmpasswd,Fistname,Studentno,eMail;
Button registersubmit,login;

regLoginDbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityregister);
        getSupportActionBar().setTitle("Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        passwd= (EditText) findViewById(R.id.passwd);
        confirmpasswd= (EditText) findViewById(R.id.confirmpasswd);
        Fistname= (EditText) findViewById(R.id.Fistname);
        Studentno= (EditText) findViewById(R.id.Studentno);
        eMail= (EditText) findViewById(R.id.eMail);
        login= (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),loginactivity.class);
                startActivity(intent);

            }
        });

        registersubmit= (Button)findViewById(R.id.registersubmit);
        db = new regLoginDbHelper(this);
        registersubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd=passwd.getText().toString();
                String cnfpwd= confirmpasswd.getText().toString();
                String mYname= Fistname.getText().toString();
                Integer studNo= Studentno.getText().length();
                String email= eMail.getText().toString();


                if(pwd.equals("")||cnfpwd.equals("")||mYname.equals("")||
                        studNo.equals("")||email.equals("")){
                    Toast.makeText(activityregister.this, "Fill all the fields!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(pwd.equals(cnfpwd))
                    {
                      Boolean checkResult = db.checkStudNo(studNo);
                      if(checkResult== false){

                          Boolean regReslts= db.insertData(studNo,mYname,pwd);
                          if(regReslts==true){
                              Intent intent = new Intent(getApplicationContext(),loginactivity.class);
                              startActivity(intent);
                          }

                          }
                      else{
                          Toast.makeText(activityregister.this, "Student Number Already exist.\n Please Login", Toast.LENGTH_SHORT).show();
                      }
                    }
                    else {
                        Toast.makeText(activityregister.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();

                    }
            }  }
        });
    }
}