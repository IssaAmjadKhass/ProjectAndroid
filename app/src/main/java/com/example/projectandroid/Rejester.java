package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.example.projectandroid.databinding.ActivityRejesterBinding;

public class Rejester extends AppCompatActivity {
ActivityRejesterBinding binding;
boolean isinfo = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityRejesterBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = binding.et3.getText().toString();
                String email = binding.et4.getText().toString();
                String password = binding.et5.getText().toString();
                    isinfo = true;
                if (userName.length() == 0) {
                    binding.et3.setError(" not Empty ");
                         isinfo = false;  }


                if (email.length() == 0) {
                    binding.et4.setError("notEmpty");
                    isinfo = false;

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.et4.setError("Invalid Email address");
                    isinfo = false;

                }

                if (password.length() == 0) {

                    binding.et5.setError("notEmpty");
                    isinfo = false;
                }
                    if (isinfo)
                    {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }

            }
        });
    }
}