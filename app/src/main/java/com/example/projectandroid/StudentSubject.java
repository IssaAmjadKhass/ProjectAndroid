package com.example.projectandroid;

import com.example.projectandroid.modail.Student;
import com.example.projectandroid.modail.Supject;

import java.io.Serializable;

import javax.security.auth.Subject;

public class StudentSubject  {
    private int id;
    private int Student_id;
    private int Subjects_id;


    public static final String TABLE_NAME = "Subject_Student";
    public static final String COL_ID = "id";
    public static final String COL_Student_id = "student_id";
    public static final String COL_Subjects_id = "subjects_id";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_Student_id + " INTEGER," +
            COL_Subjects_id + " INTEGER" +
            "FOREIGN KEY (" + COL_Student_id + ")" +
            " REFERENCES " + Student.TABLE_NAME + " (" + Student.COL_ID + ") ON DELETE CASCADE ON UPDATE NO ACTION,"
            + "FOREIGN KEY (" + COL_Subjects_id + ")" +
            " REFERENCES " + Supject.TABLE_NAME + " (" + Supject.COL_ID + ") ON DELETE CASCADE ON UPDATE NO ACTION)";


    public StudentSubject(int id, int student_id, int subjects_id) {
        this.id = id;
        Student_id = student_id;
        Subjects_id = subjects_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return Student_id;
    }

    public void setStudent_id(int student_id) {
        Student_id = student_id;
    }

    public int getSubjects_id() {
        return Subjects_id;
    }

    public void setSubjects_id(int subjects_id) {
        Subjects_id = subjects_id;
    }

}
