package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projectandroid.Cutame.CustmAdabterStudent;
import com.example.projectandroid.dpHelpr.DbHelper;
import com.example.projectandroid.modail.Student;
import com.example.projectandroid.modail.Supject;

import java.util.ArrayList;

public class Add_Student extends AppCompatActivity {
    Student student;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        ConstraintLayout layout = findViewById(R.id.cornerStudent);
        Button addStudent = findViewById(R.id.btStudent);
        EditText name1 = findViewById(R.id.name1);
        EditText name2 = findViewById(R.id.name2);
        EditText datat = findViewById(R.id.datat);
        RecyclerView recyclerView = findViewById(R.id.recaicleaddStudent);

        dbHelper = new DbHelper(this);
        ArrayList<Supject> data = dbHelper.getAllSubject();
        CustmAdabterStudent studentAdapter = new CustmAdabterStudent(this, data);
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(studentAdapter);

        Spinner subjectSpinner = findViewById(R.id.subjectSpinner);
        subjectSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, data));

// قم بتهيئة الـ Spinner وتعيين قائمة المواد المتاحة للاختيار

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // قم بالحصول على القيمة المختارة من حقل الاختيار
                Supject selectedSubject = (Supject) subjectSpinner.getSelectedItem();

                String name = name1.getText().toString();
                String family = name2.getText().toString();
                String dateOfBirth = datat.getText().toString();

                if (name.isEmpty() || family.isEmpty() || dateOfBirth.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "يرجى إدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                } else {
                    Student student = new Student(0, name, family, dateOfBirth, selectedSubject.getId());

                    dbHelper = new DbHelper(getApplicationContext());
                    boolean success = dbHelper.insertStudent(student);
                    if (success) {
                        Toast.makeText(getApplicationContext(), "تمت إضافة الطالب بنجاح", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "فشل في إضافة الطالب", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}