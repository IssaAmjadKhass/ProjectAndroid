package com.example.projectandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.projectandroid.Cutame.CustemShowStudent;
import com.example.projectandroid.dpHelpr.DbHelper;
import com.example.projectandroid.modail.Student;
import com.example.projectandroid.modail.StudentSubject;

import java.util.ArrayList;

public class ShowStudents extends AppCompatActivity {
DbHelper dbHelper;
    boolean info =true;
    RecyclerView recyclerView;
CustemShowStudent custemShowStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);



        recyclerView = findViewById(R.id.recaicleShowStudent);
        dbHelper = new DbHelper(this);
        ArrayList<Student> data = dbHelper.displayAllStudents();
        custemShowStudent = new CustemShowStudent(this, data, new CustemShowStudent.onItemClickListener() {
            @Override
            public void onItemDeleteClick(int id, int position) {
                if (info) {
                    AlertDialog.Builder daialog = new AlertDialog.Builder(ShowStudents.this);
                    daialog.setTitle("حذف الطالب");
                    daialog.setMessage("هل انته متاكد من حذف الطالب");
                    daialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (dbHelper.deleteStudent(id)) {
                                data.remove(position);
                                custemShowStudent.notifyItemRemoved(position);
                            }
                        }
                    });
                    daialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    daialog.setCancelable(false);
                    daialog.show();
                }
            }

            @Override
            public void onClick(Student student) {
                int subjectId = student.getSubjectId();
                String subjectName = dbHelper.getSubjectName(subjectId);
                String studentName = student.getName(); // استلام اسم الطالب
                Intent intent = new Intent(getApplicationContext(), Detaies_Student.class);
                intent.putExtra("subjectName", subjectName); // إرسال اسم المادة
                intent.putExtra("studentName", studentName); // إرسال اسم الطالب
                startActivity(intent);
            }
        });
        GridLayoutManager manager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(custemShowStudent);
    }
}