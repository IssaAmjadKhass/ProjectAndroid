package com.example.projectandroid.modail;

public class Months {
    private int id;
    private String months;


    public static final String TABLE_NAME = "months";
    public static final String COL_ID = "id";
    public static final String COL_MONTHS = "months";
    public static final String COL_TIME = "time";
    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +

            "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_MONTHS + " TEXT,"
            +COL_TIME + " DATETIME DEFAULT CURRENT_TIMESTAMP)";

    public Months(int id, String months) {
        this.id = id;
        this.months = months;
    }

    public int getId() {
        return id;
    }

    public String getMonths() {
        return months;
    }
}
