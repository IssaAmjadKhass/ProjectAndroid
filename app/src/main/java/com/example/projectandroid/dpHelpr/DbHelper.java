package com.example.projectandroid.dpHelpr;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.projectandroid.modail.Accounts;
import com.example.projectandroid.modail.Supject;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "DATABASE", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Supject.CREATE_TABLE);
        sqLiteDatabase.execSQL(Accounts.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Accounts.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Supject.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean createAccount(String username, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Accounts.COL_USERNAME, username);
        values.put(Accounts.COL_EMAIL, email);
        values.put(Accounts.COL_PASSWORD, password);
        long rowId = db.insert(Accounts.TABLE_NAME, null, values);
        return rowId > 0;
    }

    public boolean checkCredentials(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = Accounts.COL_USERNAME + " = ? AND " + Accounts.COL_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(
                Accounts.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        boolean hasValidCredentials = cursor.getCount() > 0;
        cursor.close();
        return hasValidCredentials;
    }


    public void updateRememberMeStatus(String username, boolean rememberMe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Accounts.COL_REMEMBER_ME, rememberMe ? 1 : 0);
        String selection = Accounts.COL_USERNAME + " = ?";
        String[] selectionArgs = {username};
        db.update(Accounts.TABLE_NAME, values, selection, selectionArgs);
    }

//    public boolean isRememberMeEnabled(String username) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        String[] columns = {Accounts.COL_REMEMBER_ME};
//        String selection = Accounts.COL_USERNAME + " = ?";
//        String[] selectionArgs = {username};
//        Cursor cursor = db.query(Accounts.TABLE_NAME, columns, selection, selectionArgs, null, null, null);
//        boolean result = false;
//        if (cursor.moveToFirst()) {
//            @SuppressLint("Range") int rememberMeValue = cursor.getInt(cursor.getColumnIndex(Accounts.COL_REMEMBER_ME));
//            result = (rememberMeValue == 1);
//        }
//        cursor.close();
//        return result;
//    }

    public boolean insertSubject(String subject) {
        SQLiteDatabase aa = getWritableDatabase();
        ContentValues dp = new ContentValues();

        dp.put(Supject.COL_SUBJECT, String.valueOf(subject));

        long rew = aa.insert(Supject.TABLE_NAME, null, dp);


        return rew > 0;
    }

    public boolean updateSubject(String id, String subject) {
        SQLiteDatabase aa = getWritableDatabase();
        ContentValues dp = new ContentValues();
        dp.put(Supject.COL_SUBJECT, String.valueOf(subject));

        int rowId = aa.update(Supject.TABLE_NAME, dp, Supject.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public boolean deleteSubject(String id) {
        SQLiteDatabase dp = getWritableDatabase();
        int rowId = dp.delete(Supject.TABLE_NAME, Supject.COL_ID + "=?", new String[]{id});
        return rowId > 0;
    }

    public ArrayList<Supject> getAllSubject() {
        SQLiteDatabase dp = getReadableDatabase();
        ArrayList<Supject> data = new ArrayList<>();
        String qouery = "SELECT * FROM " + Supject.TABLE_NAME + " ORDER BY " + Supject.COL_ID + " DESC";
        Cursor cursor = dp.rawQuery(qouery, null);
        if (cursor.moveToFirst()) {

            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Supject.COL_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(Supject.COL_SUBJECT));

                String time = cursor.getString(cursor.getColumnIndexOrThrow(Supject.COL_TIME));
                Supject supject = new Supject(id, title, time);
                data.add(supject);
            } while (cursor.moveToNext());
            cursor.close();

        }
        return data;
    }

    public ArrayList<Supject> getAllSubjectByTitle(String titleText) {
        SQLiteDatabase dp = getReadableDatabase();
        ArrayList<Supject> data = new ArrayList<>();
        String qouery = "SELECT * FROM " + Supject.TABLE_NAME + " WHERE " + Supject.COL_SUBJECT + " LIKE '%' || ? || '%' ";
        Cursor cursor = dp.rawQuery(qouery, new String[]{titleText});
        if (cursor.moveToFirst()) {

            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Supject.COL_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(Supject.COL_SUBJECT));

                String time = cursor.getString(cursor.getColumnIndexOrThrow(Supject.COL_TIME));
                Supject notes = new Supject(id, title, time);
                data.add(notes);
            } while (cursor.moveToNext());
            cursor.close();

        }
        return data;
    }


}
