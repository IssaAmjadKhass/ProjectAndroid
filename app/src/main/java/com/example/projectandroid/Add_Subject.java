package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projectandroid.databinding.ActivityAddSubjectBinding;
import com.example.projectandroid.dpHelpr.DbHelper;
import com.example.projectandroid.modail.Supject;

public class Add_Subject extends AppCompatActivity {
    ActivityAddSubjectBinding binding;
    Supject supject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityAddSubjectBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        DbHelper dbHelper = new DbHelper(getApplicationContext());
        binding.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String addSubject = binding.et1.getText().toString();


                if (supject!=null){
                    String id= String.valueOf(supject.getId());
                    boolean isSuccesfulyUpdate= dbHelper.updateSubject(id, addSubject);
                    if (isSuccesfulyUpdate){
                        finish();
                    }else {
                        Toast.makeText(Add_Subject.this, "يرجى إدخال قيم صحيحة", Toast.LENGTH_SHORT).show();
                    }
                }else {


                    boolean isSucssefly=dbHelper.insertSubject(addSubject);
                    if (isSucssefly){
                        finish();
                    }else {
                        Toast.makeText(Add_Subject.this, "يرجى إدخال قيم صحيحة", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}