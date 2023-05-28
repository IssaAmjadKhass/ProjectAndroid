package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.projectandroid.databinding.ActivityRejesterBinding;
import com.example.projectandroid.modail.DbHelper;

public class Rejester extends AppCompatActivity {
    ActivityRejesterBinding binding;
    private DbHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRejesterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DbHelper(this);

        binding.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.et1.getText().toString();
                String email = binding.et2.getText().toString();
                String password = binding.et3.getText().toString();

                if (userName.isEmpty()) {
                    binding.et1.setError("Username cannot be empty");
                    return;
                }

                if (email.isEmpty()) {
                    binding.et2.setError("Email cannot be empty");
                    return;
                }

                if (password.isEmpty()) {
                    binding.et3.setError("Password cannot be empty");
                    return;
                }

                boolean isAccountCreated = databaseHelper.createAccount(userName, email, password);
                if (isAccountCreated) {
                    finish();
                } else {
                    binding.et1.setError("Username already exists");
                }
            }
        });
    }
}