package com.example.tasklist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tasklist.Model.Tasks;

import java.util.ArrayList;

public class Dbhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TOLIST";    // Database Name
    private static final String TABLE_NAME = "Tasklist";   // Table Name
    private static final int DATABASE_Version = 1;
    private static final String Col1="Id";
    private static final String Col2="Task";
    private static final String Col3="Date";// Database Version
    private int Id;
    private String Task;
    private String Date;
    private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
    private static final  String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + Col1 +  " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " + Col2 + "  VARCHAR(255) ,"
            + Col3 + "DATETIME DEFAULT CURRENT_TIMESTAMP  "+ ");";
    public Dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       try{
           db.execSQL(CREATE_TABLE);
       }catch(Exception e) {



        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{

            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch(Exception e) {


        }
    }


    public long insertdata( String Task )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col2 , Task);
        long id = db.insert(TABLE_NAME, null,values);
        return id ;
    }

    public  ArrayList<Tasks> Viewdata()
    {
        ArrayList<Tasks> arrayList = new ArrayList<>();
     SQLiteDatabase db = this.getReadableDatabase();
     String query = "Select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        while(cursor.moveToNext())
        {
         int id=cursor.getInt(0);
         String task = cursor.getString(1);
         String Date = cursor.getString(2);
         Tasks task1 = new Tasks(id,task,Date);
         arrayList.add(task1);

        }
        return arrayList;
    }

    public void delete(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String ID=String.valueOf(id);
        db.delete(TABLE_NAME, Col1 + " = ?", new String[] { ID });
    }

    public void update(int id, String Task) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_NAME+" SET Col2='"+Task+"',   WHERE Id=" + id);
    }

}
