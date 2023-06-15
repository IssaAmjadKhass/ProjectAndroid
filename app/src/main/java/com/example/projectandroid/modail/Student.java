package com.example.projectandroid.modail;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String family;
    private String dateofbirth;
    private int subjectId; // حقل يحمل معرف المادة

    public static final String TABLE_NAME = "STUDENT";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_DATAOFBIRTH = "dateofbirth";
    public static final String COL_FAMILY = "family";
    public static final String COL_SUBJECT_ID = "subject_id"; // اسم حقل معرف المادة

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_NAME + " TEXT," +
            COL_FAMILY + " TEXT," +
            COL_DATAOFBIRTH + " TEXT," +
            COL_SUBJECT_ID + " INTEGER)"; // تضمين حقل معرف المادة في إعلان الجدول

    public Student(int id, String name, String family, String dateofbirth, int subjectId) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.dateofbirth = dateofbirth;
        this.subjectId = subjectId; // تعيين قيمة معرف المادة
    }

    // ... الدوال الأخرى والوصول إلى معرف المادة

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
    public Student(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", dateofbirth='" + dateofbirth + '\'' +
                ", subjectId=" + subjectId +
                '}';
    }
}