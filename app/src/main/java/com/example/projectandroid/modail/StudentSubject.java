package com.example.projectandroid.modail;

import com.example.projectandroid.modail.Student;
import com.example.projectandroid.modail.Supject;

import java.io.Serializable;

import javax.security.auth.Subject;
public class StudentSubject implements Serializable {
    private int id;
    private int studentId;
    private int subjectId;

    public static final String TABLE_NAME = "STUDENT_SUBJECT";
    public static final String COL_ID = "id";
    public static final String COL_STUDENT_ID = "student_id";
    public static final String COL_SUBJECT_ID = "subject_id";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_STUDENT_ID + " INTEGER," +
            COL_SUBJECT_ID + " INTEGER," +
            "FOREIGN KEY(" + COL_STUDENT_ID + ") REFERENCES " + Student.TABLE_NAME + "(" + Student.COL_ID + ")," +
            "FOREIGN KEY(" + COL_SUBJECT_ID + ") REFERENCES " + Supject.TABLE_NAME + "(" + Supject.COL_ID + "))";

    public StudentSubject(int id, int studentId, int subjectId) {
        this.id = id;
        this.studentId = studentId;
        this.subjectId = subjectId;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    @Override
    public String toString() {
        return "StudentSubject{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", subjectId=" + subjectId +
                '}';
    }
}