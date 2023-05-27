package com.example.projectandroid.modail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "SUBJECT", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Supject.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Supject.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }
    public  boolean insertSubject(String subject){
        SQLiteDatabase aa = getWritableDatabase();
        ContentValues dp = new ContentValues();

        dp.put(Supject.COL_SUBJECT, String.valueOf(subject));

        long rew =  aa.insert(Supject.TABLE_NAME,null , dp);


        return rew>0 ;
    }

    public  boolean updateSubject(String id , String subject ){
        SQLiteDatabase aa = getWritableDatabase();
        ContentValues dp = new ContentValues();
        dp.put(Supject.COL_SUBJECT, String.valueOf(subject));

        int rowId = aa.update(Supject.TABLE_NAME, dp , Supject.COL_ID +"=?" ,new String [] {id});
        return rowId>0;
    }
    public  boolean deleteSubject(String id)
    {
        SQLiteDatabase dp = getWritableDatabase();
        int rowId =  dp.delete(Supject.TABLE_NAME,Supject.COL_ID+"=?",new String[]{id});
        return rowId>0;
    }
    public ArrayList<Supject>getAllSubject() {
        SQLiteDatabase dp = getReadableDatabase();
        ArrayList<Supject>data=new ArrayList<>();
        String qouery = "SELECT * FROM "+Supject.TABLE_NAME+" ORDER BY "+Supject.COL_ID+" DESC";
        Cursor cursor = dp.rawQuery(qouery,null);
        if (cursor.moveToFirst()) {

            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Supject.COL_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(Supject.COL_SUBJECT));

                String time  = cursor.getString(cursor.getColumnIndexOrThrow(Supject.COL_TIME));
                Supject supject = new Supject(id,title,time);
                data.add(supject);
            }while (cursor.moveToNext());
            cursor.close();

        }
        return data;
    }
    public ArrayList<Supject>getAllSubjectByTitle(String titleText) {
        SQLiteDatabase dp = getReadableDatabase();
        ArrayList<Supject>data=new ArrayList<>();
        String qouery = "SELECT * FROM "+Supject.TABLE_NAME+" WHERE "+ Supject.COL_SUBJECT+" LIKE '%' || ? || '%' ";
        Cursor cursor = dp.rawQuery(qouery,new String[]{titleText});
        if (cursor.moveToFirst()) {

            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Supject.COL_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(Supject.COL_SUBJECT));

                String time  = cursor.getString(cursor.getColumnIndexOrThrow(Supject.COL_TIME));
                Supject notes = new Supject(id,title,time);
                data.add(notes);
            }while (cursor.moveToNext());
            cursor.close();

        }
        return data;
    }








}
