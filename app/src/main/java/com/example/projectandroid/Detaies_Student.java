package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projectandroid.Cutame.CustamStudent_Subject;
import com.example.projectandroid.dpHelpr.DbHelper;
import com.example.projectandroid.modail.Supject;

import java.util.ArrayList;

public class Detaies_Student extends AppCompatActivity {
    private DbHelper dbHelper;
    private CustamStudent_Subject adapter;
    TextView textViewStudentName;
    TextView textViewStudentDate;
    TextView textViewStudentAge;
    RecyclerView recyclerViewStudentSubjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaies_student);

        textViewStudentName = findViewById(R.id.textViewStudentName);
        textViewStudentDate = findViewById(R.id.textViewStudentDate);
        textViewStudentAge = findViewById(R.id.textViewStudentAge);
        recyclerViewStudentSubjects = findViewById(R.id.recyclerViewStudentSubjects);

        Intent intent = getIntent();
        String subjectName = intent.getStringExtra("subjectName");
        String studentName = intent.getStringExtra("studentName");

        textViewStudentName.setText(studentName);



        dbHelper = new DbHelper(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewStudentSubjects);

        ArrayList<Supject> subjectList = new ArrayList<>();
        adapter = new CustamStudent_Subject(this, subjectList, dbHelper);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}