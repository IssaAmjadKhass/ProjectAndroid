package com.example.projectandroid.modail;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private  String name;
    private  String family;
    private String dateofbirth;


    public static final String TABLE_NAME = "STUDENT";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_FAMILY = "family";
    public static final String COL_DATAOFBIRTH= "dataofbirth";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
            "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_NAME + " TEXT," +
            COL_FAMILY + " TEXT," +
            COL_DATAOFBIRTH + " TEXT)";


    public Student(int id, String name, String family, String dateofbirth) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.dateofbirth = dateofbirth;

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

                '}';
    }
}
