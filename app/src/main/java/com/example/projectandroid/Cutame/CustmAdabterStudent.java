package com.example.projectandroid.Cutame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.modail.Supject;

import java.util.ArrayList;

public class CustmAdabterStudent extends RecyclerView.Adapter<CustmAdabterStudent.MyHolder> {

    Context context;
    ArrayList<Supject>data;

    public CustmAdabterStudent(Context context, ArrayList<Supject> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_studentsupject,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.checkBox.setText(data.get(position).getSubject());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.chicStudent);
        }
    }
}
