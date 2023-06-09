package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.projectandroid.databinding.ActivityMainBinding;
import com.example.projectandroid.dpHelpr.DbHelper;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private DbHelper databaseHelper;
    private boolean rememberMe;

    SharedPreferences preferences;
    String userName;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DbHelper(this);
        preferences = getSharedPreferences("myPref", Context.MODE_PRIVATE);

        userName = preferences.getString("userName", "");
        email = preferences.getString("email", "");

        if (preferences.getBoolean("ddd", false) && !userName.isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), Home.class);
            intent.putExtra("userName", userName);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();
        }

        binding.tvRejester.setOnClickListener(new View.OnClickListener() {
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

                if (userName.isEmpty()) {
                    binding.et1.setError("Username cannot be empty");
                    return;
                }

                if (password.isEmpty()) {
                    binding.et2.setError("Password cannot be empty");
                    return;
                }

                boolean isCredentialsValid = databaseHelper.checkCredentials(userName, password);
                if (isCredentialsValid) {
                    rememberMe = binding.Rb1.isChecked();
                    preferences.edit().putBoolean("ddd", rememberMe).apply();

                    String email = databaseHelper.getEmail();


                    SharedPreferences.Editor editor = preferences.edit();


                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    intent.putExtra("userName", userName);
                    intent.putExtra("email", email);
                    startActivity(intent);
                    startActivity(intent);
                    finish();
                } else {
                    binding.et2.setError("Invalid credentials");
                }
            }
        });


        binding.Rb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                rememberMe = isChecked;
            }
        });
    }
}