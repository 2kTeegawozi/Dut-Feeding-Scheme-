package com.example.dutfeedingschemes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class bookingDatactivity extends AppCompatActivity {
    EditText campus, time ,location ;
    Button btnInsert, update, delete, view;
    regLoginDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_datactivity);
        campus = findViewById(R.id.campus);
        time = findViewById(R.id.time);
        location = findViewById(R.id.location);


        view = findViewById(R.id.btnView);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);


        btnInsert = findViewById(R.id.btnInsert);
        db = new regLoginDbHelper(this);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String campusNm = campus.getText().toString();
                String myTime = time.getText().toString();
                String locate = location.getText().toString();


                if (campusNm.equals("")||myTime.equals("") || locate.equals("")){
                    Toast.makeText(bookingDatactivity.this, "Please enter details!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean results = db.insertuserdata(campusNm,myTime,locate);
                if(results==true){
                    Toast.makeText(bookingDatactivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(bookingDatactivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }

                }
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String campusNm = campus.getText().toString();
                String myTime = time.getText().toString();
                String locate = location.getText().toString();

                Boolean checkupdatedata = db.updateuserdata(campusNm,myTime,locate);
                if(checkupdatedata==true)
                {


                    Toast.makeText(bookingDatactivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(bookingDatactivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();}
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String campusNM = campus.getText().toString();
                Boolean checkudeletedata = db.deletedata(campusNM);
                if(checkudeletedata==true) {
                    Toast.makeText(bookingDatactivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(bookingDatactivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getData();
                if(res.getCount()==0){
                    Toast.makeText(bookingDatactivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Campus :"+res.getString(0)+"\n");
                    buffer.append("Location :"+res.getString(1)+"\n");
                    buffer.append("Time :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(bookingDatactivity.this);
                builder.setCancelable(true);
                builder.setTitle("Parcel Collection Details");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
    }
}
