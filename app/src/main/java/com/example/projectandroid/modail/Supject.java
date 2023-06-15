package com.example.projectandroid.modail;

import java.io.Serializable;

public class Supject implements Serializable {

    private int id;
    private String subject;
    private String time;

    public static final String TABLE_NAME = "SUBJECT";
    public static final String COL_ID = "id";
    public static final String COL_SUBJECT = "subject";
    public static final String COL_TIME = "time";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +

            "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_SUBJECT + " TEXT," +
            COL_TIME + " DATETIME DEFAULT CURRENT_TIMESTAMP)";


    public Supject(int id, String subject, String time) {
        this.id = id;
        this.subject = subject;
        this.time = time;
    }
    public float getPresencePercentage() {
        // قم بتنفيذ العمليات اللازمة لحساب نسبة الحضور هنا
        // يمكنك استخدام قاعدة البيانات أو البيانات المتاحة لحساب النسبة
        // قم بإرجاع النسبة كقيمة من هذه الدالة
        return 0.0f;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Supject{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", time='" + time + '\'' +
                '}';
    }


}
