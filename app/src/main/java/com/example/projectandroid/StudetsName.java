package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.projectandroid.Cutame.CustumNameStudent;
import com.example.projectandroid.dpHelpr.DbHelper;
import com.example.projectandroid.modail.Student;

import java.util.ArrayList;

public class StudetsName extends AppCompatActivity {
    ArrayList<Student> data;
    CustumNameStudent custumNameStudent;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studets_name);
        Button button = findViewById(R.id.btNameStudent);
        RecyclerView recyclerView = findViewById(R.id.recaicleNameStudents);
        dbHelper = new DbHelper(this);
     data  = dbHelper.displayAllStudents();
        custumNameStudent = new CustumNameStudent(this, data);
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(custumNameStudent);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAttendance();
                finish();

            }
        });
    }

    private void addAttendance() {

        // حساب نسبة الحضور
        int totalStudents = data.size();
        int presentStudents = custumNameStudent.getSelectedStudents().size();
        float attendancePercentage = (presentStudents / (float) totalStudents) * 100;

        // تخزين نسبة الحضور في قاعدة البيانات باستخدام دالة addAttendancePercentage() في dbHelper
        dbHelper.addAttendancePercentage(attendancePercentage);

        // انتقال إلى شاشة الأيام وتمرير نسبة الحضور كمعطى إضافي (extra) في ال Intent

        Intent intent = new Intent(getApplicationContext(), Days.class);
        intent.putExtra("attendancePercentage", attendancePercentage);
        startActivity(intent);


    }
}