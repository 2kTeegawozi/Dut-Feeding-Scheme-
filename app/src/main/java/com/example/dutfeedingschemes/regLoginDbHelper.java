package com.example.dutfeedingschemes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class regLoginDbHelper extends SQLiteOpenHelper {

    public regLoginDbHelper(Context context) {
        super(context,"login.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(studentNum int primary key,username Text, password Text)");
        db.execSQL("create Table Admin( campus Text primary key, location Text, time Text)");

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("drop Table if exists users");
db.execSQL("drop Table if exists Admin");

    }
    public Boolean insertuserdata( String campus,String time,  String location )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("campus", campus);
        contentValues.put("time", time);
        contentValues.put("location", location);

        long result=db.insert("Admin", null, contentValues);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean updateuserdata(String campus,String time,  String location ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", time);
        contentValues.put("location", location);

        Cursor cursor = db.rawQuery("Select * from Admin where campus = ? ", new String[]{campus});

        if (cursor.getCount() > 0 ) {
            long result = db.update("Admin", contentValues, "campus=?", new String[]{campus});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }}

    public Boolean deletedata (String campus)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Admin where campus = ?", new String[]{campus});
        if (cursor.getCount() > 0) {
            long result = db.delete("Admin", "campus=?", new String[]{campus});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public Cursor getData ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Admin", null);
        return cursor;

    }

    public  Boolean insertData ( Integer studentNum, String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("studentNum",studentNum);
        long result = db.insert("users",null,contentValues);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkStudNo(Integer studentNum){
        SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.rawQuery("select*from users where studentNum =?", new String[]{String.valueOf(studentNum)});
         if (cursor.getCount()>0){
             return true;
         }
         else {
             return false;
         }

    }
    public Boolean checkEntries (Integer studentNum, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select*from users where studentNum =?" , new String[]{String.valueOf(studentNum)});
        Cursor cursor1 = db.rawQuery("select*from users where password =?" ,new String[]{password});
        if (cursor.getCount()>0 && cursor1.getCount()>0) {
            return true;
        }
        else if(cursor.getCount()>0 || cursor1.getCount()>0){
            return false;
        }

        else {
            return false;
        }


    }
    public Boolean checkLoginEntry(Integer studentNum,String password){
        SQLiteDatabase db =this.getWritableDatabase();

        if (studentNum==87654320 && password=="Admin01") {
            return true;
        }
        else {
            return false;
        }


}
    public Cursor getDataStud ( String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select*from users where username =?" ,new String[]{username});

        return cursor;

    }
}
