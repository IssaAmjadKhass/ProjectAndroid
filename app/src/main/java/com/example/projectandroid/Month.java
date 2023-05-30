package com.example.projectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.projectandroid.adapter.CustemAdapterMonth;

import java.util.ArrayList;

public class Month extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);
        ListView lest = findViewById(R.id.lv22);
        ArrayList<Month1> data = new ArrayList<>();
           Month1 month1 = new Month1("ياناير");
           data.add(month1);
           Month1 month2 = new Month1("فبراير");
        data.add(month2);
           Month1 month3 = new Month1("مارس");
        data.add(month3);
           Month1 month4 = new Month1("ابريل");
        data.add(month4);
           Month1 month5 = new Month1("مايو");
        data.add(month5);
           Month1 month6= new Month1("يونيو");
        data.add(month6);
           Month1 month7 = new Month1("يوليو");
        data.add(month7);
           Month1 month8 = new Month1("اغسطس");
        data.add(month8);
           Month1 month9 = new Month1("سبتمبر");
        data.add(month9);
           Month1 month10 = new Month1("اكتوبر");
        data.add(month10);
           Month1 month11 = new Month1("نوفمبر");
        data.add(month11);
           Month1 month12 = new Month1("ديسمبر");
        data.add(month12);
        CustemAdapterMonth custemAdapterMonth = new CustemAdapterMonth(this,data);
        lest.setAdapter(custemAdapterMonth);

    }
}