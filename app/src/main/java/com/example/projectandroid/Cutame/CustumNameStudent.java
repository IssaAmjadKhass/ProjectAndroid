package com.example.projectandroid.Cutame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.modail.Student;

import java.util.ArrayList;

public class CustumNameStudent extends RecyclerView.Adapter<CustumNameStudent.MyHolderName> {
    private Context context;
    private ArrayList<Student> data;
    private ArrayList<Integer> selectedStudents;

    public CustumNameStudent(Context context, ArrayList<Student> data) {
        this.context = context;
        this.data = data;
        this.selectedStudents = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyHolderName onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_namestudent, parent, false);
        return new MyHolderName(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderName holder, int position) {
        holder.box.setText(data.get(position).getName());
        holder.box.setChecked(selectedStudents.contains(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public ArrayList<Student> getSelectedStudents() {
        ArrayList<Student> selected = new ArrayList<>();
        for (int position : selectedStudents) {
            selected.add(data.get(position));
        }
        return selected;
    }

    class MyHolderName extends RecyclerView.ViewHolder {
        CheckBox box;

        public MyHolderName(@NonNull View itemView) {
            super(itemView);
            box = itemView.findViewById(R.id.checitemStudent);

            box.setOnCheckedChangeListener((buttonView, isChecked) -> {
                int position = getAdapterPosition();
                if (isChecked) {
                    selectedStudents.add(position);
                } else {
                    selectedStudents.remove(Integer.valueOf(position));
                }
            });
        }
    }
}