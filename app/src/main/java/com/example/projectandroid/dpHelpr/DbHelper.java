package com.example.projectandroid.dpHelpr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.projectandroid.modail.Accounts;
import com.example.projectandroid.modail.Student;
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
        sqLiteDatabase.execSQL(Student.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Accounts.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Supject.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Student.TABLE_NAME);
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
public String getUserName() {
    SQLiteDatabase db = this.getReadableDatabase();
    String[] columns = {Accounts.COL_USERNAME};
    Cursor cursor = db.query(
            Accounts.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            null
    );
    String username = "";
    if (cursor.moveToFirst()) {
        username = cursor.getString(cursor.getColumnIndexOrThrow(Accounts.COL_USERNAME));
    }
    cursor.close();
    return username;
}

    public String getEmail() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {Accounts.COL_EMAIL};
        Cursor cursor = db.query(
                Accounts.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null
        );
        String email = "";
        if (cursor.moveToFirst()) {
            email = cursor.getString(cursor.getColumnIndexOrThrow(Accounts.COL_EMAIL));
        }
        cursor.close();
        return email;
    }

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



    public boolean insertStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Student.COL_NAME, student.getName());
        values.put(Student.COL_FAMILY, student.getFamily());
        values.put(Student.COL_DATAOFBIRTH, student.getDateofbirth());

        long rowId = db.insert(Student.TABLE_NAME, null, values);

        return rowId >0;
    }

    public ArrayList<Student> getAllStudents (String name1) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Student> students = new ArrayList<>();
        String query = "SELECT * FROM " + Student.TABLE_NAME +" WHERE " + Student.COL_NAME+ " LIKE '%' || ? || '%' ";
        Cursor cursor = db.rawQuery(query,  new String[]{name1});
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(Student.COL_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(Student.COL_NAME));
                String family = cursor.getString(cursor.getColumnIndexOrThrow(Student.COL_FAMILY));
                String dateOfBirth = cursor.getString(cursor.getColumnIndexOrThrow(Student.COL_DATAOFBIRTH));

                Student student = new Student(id, name, family, dateOfBirth);
                students.add(student);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return students;
    }
    public ArrayList<Student> displayAllStudents() {
        ArrayList<Student> students = getAllStudents("");

        for (Student student : students) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Family: " + student.getFamily());
            System.out.println("Date of Birth: " + student.getDateofbirth());
            System.out.println("-------------------------------------");
        }
        return students;
    }


    public boolean deleteStudent(int studentId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsAffected = db.delete(Student.TABLE_NAME, Student.COL_ID + " = ?", new String[]{String.valueOf(studentId)});
        return rowsAffected > 0;
    }




}
