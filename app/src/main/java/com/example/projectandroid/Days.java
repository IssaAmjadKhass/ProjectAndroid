package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.projectandroid.Cutame.CustumAdapterDay;
import com.example.projectandroid.modail.Days1;

import java.util.ArrayList;

public class Days extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month2);
        TextView today = findViewById(R.id.today);

        RecyclerView recyclerView = findViewById(R.id.cornner2);
        ConstraintLayout layout = findViewById(R.id.recaicle22);

        int subjectId = getIntent().getIntExtra("subjectId", 0);
        String selectedMonth = getIntent().getStringExtra("monthName");

        today.setText(selectedMonth);

        // استرجاع نسبة الحضور من ال Intent
        float attendancePercentage = getIntent().getFloatExtra("attendancePercentage", 0.0f);

        TextView attendanceTextView = findViewById(R.id.avgStudent);
        attendanceTextView.setText(String.format("%.2f%%", attendancePercentage));

        ArrayList<Days1> data = new ArrayList<>();
        data.add(new Days1("1"));
        data.add(new Days1("2"));
        data.add(new Days1("3"));
        data.add(new Days1("4"));
        data.add(new Days1("5"));
        data.add(new Days1("6"));
        data.add(new Days1("7"));
        data.add(new Days1("8"));
        data.add(new Days1("9"));
        data.add(new Days1("10"));
        data.add(new Days1("11"));
        data.add(new Days1("12"));
        data.add(new Days1("13"));
        data.add(new Days1("14"));
        data.add(new Days1("15"));
        data.add(new Days1("16"));
        data.add(new Days1("17"));
        data.add(new Days1("18"));
        data.add(new Days1("19"));
        data.add(new Days1("20"));
        data.add(new Days1("21"));
        data.add(new Days1("22"));
        data.add(new Days1("23"));
        data.add(new Days1("24"));
        data.add(new Days1("25"));
        data.add(new Days1("26"));
        data.add(new Days1("27"));
        data.add(new Days1("28"));
        data.add(new Days1("29"));
        data.add(new Days1("30"));

        CustumAdapterDay day = new CustumAdapterDay(this, data, new CustumAdapterDay.linerLayout() {
            @Override
            public void onClick(String valueOf, int position) {
                Intent intent = new Intent(getApplicationContext(), StudetsName.class);
                intent.putExtra("monthName", selectedMonth);
                intent.putExtra("subjectId", subjectId);
                startActivity(intent);
            }
        });

        GridLayoutManager manager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(day);
    }
}