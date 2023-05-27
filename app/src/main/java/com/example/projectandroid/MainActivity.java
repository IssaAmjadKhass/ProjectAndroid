package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;

import com.example.projectandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    boolean isinf = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());



        binding.tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rejester.class);
                startActivity(intent);
            }
        });

        binding.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.et1.getText().toString();
                String password = binding.et2.getText().toString();
                String email = binding.et3.getText().toString();
                isinf = true;
                if (userName.length() == 0) {
                    binding.et1.setError(" not Empty ");
                    isinf = false;

                }



                if (email.length() == 0) {
                    binding.et3.setError("notEmpty");
                    isinf = false;

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    binding.et3.setError("اكتب صيغة الايميل بشكل صحيح");
                    isinf = false;
                }

                    if (password.length() == 0) {
                        binding.et2.setError("notEmpty");
                        isinf = false;
                    }


                    if (isinf) {
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("userName", userName);
                        intent.putExtra("email",email);
                        startActivity(intent);
                    }
                }
        });
            }

}
