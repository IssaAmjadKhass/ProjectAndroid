package com.example.projectandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectandroid.Cutame.CustimAdapterSubject;
import com.example.projectandroid.databinding.ActivityHomeBinding;
import com.example.projectandroid.dpHelpr.DbHelper;
import com.example.projectandroid.modail.Supject;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ActivityHomeBinding binding;
    DbHelper dbHelper;
    RecyclerView recyclerView;
    CustimAdapterSubject adapterSubject;
    boolean info = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        recyclerView = findViewById(R.id.recaicle);
        binding.ShowStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowStudents.class);
                startActivity(intent);
            }
        });


        String userName = getIntent().getStringExtra("userName");
        String email = getIntent().getStringExtra("email");
        binding.username.setText(userName);
        binding.email.setText(email);

        dbHelper = new DbHelper(this);


        binding.ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditUser.class);
                startActivity(intent);
            }
        });

        binding.AddSupject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Add_Subject.class);

                startActivity(intent);
            }
        });

        binding.AddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Add_Student.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbHelper = new DbHelper(this);
        ArrayList<Supject> data = dbHelper.getAllSubject();
        adapterSubject = new CustimAdapterSubject(this, data, new CustimAdapterSubject.onItemClickListener() {
            @Override
            public void onItemDeleteClick(int id, int position) {

                if (info) {
                    AlertDialog.Builder daialog = new AlertDialog.Builder(Home.this);
                    daialog.setTitle("حذف الماده");
                    daialog.setMessage("هل انته متاكد من حذف الماده");
                    daialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (dbHelper.deleteSubject(String.valueOf(id))) {
                                data.remove(position);
                                adapterSubject.notifyItemRemoved(position);
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
            public void onClick(Supject supject) {

                Intent intent = new Intent(getApplicationContext(), Month.class);
                intent.putExtra("subjectId", supject.getId());
                startActivity(intent);
            }
        });
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterSubject);
    }


}