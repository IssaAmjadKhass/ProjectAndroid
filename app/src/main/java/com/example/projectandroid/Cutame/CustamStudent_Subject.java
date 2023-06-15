package com.example.projectandroid.Cutame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.dpHelpr.DbHelper;
import com.example.projectandroid.modail.Supject;

import java.util.ArrayList;

public class CustamStudent_Subject extends RecyclerView.Adapter<CustamStudent_Subject.MyHolder> {
    Context context;
    ArrayList<Supject> data;

    public CustamStudent_Subject(Context context, ArrayList<Supject> data, DbHelper dbHelper) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_studentsupject, parent, false);
        return new MyHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Supject subject = data.get(position);
        holder.nameSubjects.setText(subject.getSubject());
        holder.presencePercentage.setText(subject.getPresencePercentage() + "%");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView nameSubjects;
        TextView presencePercentage;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            nameSubjects = itemView.findViewById(R.id.SubjectName);
            presencePercentage = itemView.findViewById(R.id.Presence);
        }
    }
}
