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
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+

            "("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            COL_SUBJECT+" TEXT,"+
            COL_TIME+" DATETIME DEFAULT CURRENT_TIMESTAMP)";








    public Supject(int id, String subject, String time) {
        this.id = id;
        this.subject = subject;
        this.time = time;
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
