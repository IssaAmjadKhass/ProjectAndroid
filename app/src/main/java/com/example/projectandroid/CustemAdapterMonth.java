package com.example.projectandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustemAdapterMonth extends BaseAdapter {
    Context context;
    ArrayList<Month1>data;

    public CustemAdapterMonth(Context context, ArrayList<Month1> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.item_manth,viewGroup,false);
       TextView  name = view1.findViewById(R.id.tv_month);
       name.setText(data.get(i).getMonth());
        return view1;
    }
}
