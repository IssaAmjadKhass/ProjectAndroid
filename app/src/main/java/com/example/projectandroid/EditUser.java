package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import com.example.projectandroid.databinding.ActivityEditUserBinding;
import com.example.projectandroid.dpHelpr.DbHelper;

public class EditUser extends AppCompatActivity {
    boolean isinf = true;
    DbHelper dbHelper;
    ActivityEditUserBinding binding;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityEditUserBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        preferences = getSharedPreferences("myPref", Context.MODE_PRIVATE);

        String userName = preferences.getString("userName", "");
        String email = preferences.getString("email", "");

        binding.et1.setText(userName);
        binding.et2.setText(email);

        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newUserName = binding.et1.getText().toString();
                String newEmail = binding.et2.getText().toString();
                String newPassword = binding.et3.getText().toString();
                isinf = true;

                if (newUserName.length() == 0) {
                    binding.et1.setError("Username cannot be empty");
                    isinf = false;
                }

                if (newEmail.length() == 0) {
                    binding.et2.setError("Email cannot be empty");
                    isinf = false;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(newEmail).matches()) {
                    binding.et2.setError("Invalid email format");
                    isinf = false;
                }

                if (newPassword.length() == 0) {
                    binding.et3.setError("Password cannot be empty");
                    isinf = false;
                }

                if (isinf) {
                    DbHelper dbHelper = new DbHelper(getApplicationContext());
                    boolean isSuccess = dbHelper.createOrUpdateAccount(newUserName, newEmail, newPassword);
                    if (isSuccess) {
                        // تحديث قيم اسم المستخدم والبريد الإلكتروني في SharedPreferences
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("userName", newUserName);
                        editor.putString("email", newEmail);
                        editor.apply();

                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtra("userName", newUserName);
                        intent.putExtra("email", newEmail);
                        startActivity(intent);
                    } else {
                        // Handle account creation or update failure
                    }
                }
            }
        });
    }
}