package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.projectandroid.dpHelpr.DbHelper;
import com.example.projectandroid.modail.Supject;

import java.util.ArrayList;

public class Add_Student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
       ConstraintLayout layout = findViewById(R.id.cornerStudent);
        RecyclerView recyclerView = findViewById(R.id.recaicleaddStudent);

        DbHelper dbHelper=new DbHelper(this);
        ArrayList<Supject> data = dbHelper.getAllSubject();
        CustmAdabterStudent student =new CustmAdabterStudent(this, data);
        GridLayoutManager manager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(student);
    }
}