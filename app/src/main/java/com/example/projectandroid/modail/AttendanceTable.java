package com.example.projectandroid.modail;

public class AttendanceTable {


    private int id;
    private String name;
    private String data;



    public static final String TABLE_NAME = "attendance_table";
    public static final String COLUMN_ID = "id";
    private static final String COLUMN_STUDENT_NAME = "student_name";
    private static final String COLUMN_DATE = "date";


    private static final String COLUMN_ATTENDANCE_STATUS = "attendance_status";
    public  static final String COLUMN_ATTENDANCE_PERCENTAGE = "attendance_percentage";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_STUDENT_NAME + " TEXT,"
            + COLUMN_DATE + " TEXT,"
            + COLUMN_ATTENDANCE_STATUS + " INTEGER,"
            + COLUMN_ATTENDANCE_PERCENTAGE + " FLOAT DEFAULT 0.0)"; // إضافة العمود الجديد

    public AttendanceTable(int id, String name, String data) {
        this.id = id;
        this.name = name;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getData() {
        return data;
    }
}
