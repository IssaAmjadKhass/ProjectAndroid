package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        final DbHelper[] dbHelper = {new DbHelper(this)};
        ArrayList<Supject> data = dbHelper[0].getAllSubject();
        CustmAdabterStudent student1 =new CustmAdabterStudent(this, data);
        GridLayoutManager manager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(student1);

        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name1.getText().toString();
                String family = name2.getText().toString();
                String dateOfBirth = datat.getText().toString();

                // التحقق من صحة إدخال البيانات
                if (name.isEmpty() || family.isEmpty() || dateOfBirth.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "يرجى إدخال جميع البيانات", Toast.LENGTH_SHORT).show();
                } else {
                    Student student = new Student(0, name, family, dateOfBirth);

                  DbHelper  dbHelper = new DbHelper(getApplicationContext());
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