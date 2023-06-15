package com.example.projectandroid.modail;

public class AttendanceTable {
    private int id;
    private int subjectId;
    private String studentName;
    private String date;
    private int attendanceStatus;
    private float attendancePercentage;

    public static final String TABLE_NAME = "attendance_table";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SUBJECT_ID = "subject_id";
    public static final String COLUMN_STUDENT_NAME = "student_name";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_ATTENDANCE_STATUS = "attendance_status";
    public static final String COLUMN_ATTENDANCE_PERCENTAGE = "attendance_percentage";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_SUBJECT_ID + " INTEGER,"
            + COLUMN_STUDENT_NAME + " TEXT,"
            + COLUMN_DATE + " TEXT,"
            + COLUMN_ATTENDANCE_STATUS + " INTEGER,"
            + COLUMN_ATTENDANCE_PERCENTAGE + " FLOAT DEFAULT 0.0)";

    public AttendanceTable(int id, int subjectId, String studentName, String date, int attendanceStatus, float attendancePercentage) {
        this.id = id;
        this.subjectId = subjectId;
        this.studentName = studentName;
        this.date = date;
        this.attendanceStatus = attendanceStatus;
        this.attendancePercentage = attendancePercentage;
    }

    public int getId() {
        return id;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDate() {
        return date;
    }

    public int getAttendanceStatus() {
        return attendanceStatus;
    }

    public float getAttendancePercentage() {
        return attendancePercentage;
    }
}