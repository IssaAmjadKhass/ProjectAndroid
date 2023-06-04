package com.example.projectandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.modail.Student;
import com.example.projectandroid.modail.Supject;

import java.util.ArrayList;

public class CustemShowStudent extends RecyclerView.Adapter<CustemShowStudent.MyHolderShow> {
    Context context;
    ArrayList<Student> data;
    onItemClickListener listener;

    public CustemShowStudent(Context context, ArrayList<Student> data, onItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyHolderShow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_showstudent, parent, false);

        return new MyHolderShow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolderShow holder, int position) {
        holder.TvshowStudent.setText(data.get(position).getName());
       Student student = new Student();
        String firstName = student.getName();
        String lastName = student.getFamily();
          holder.containerShowStudent.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  listener.onClick(data.get(holder.getAdapterPosition()));
              }
          });
          holder.imjDeletShow.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  listener.onItemDeleteClick(data.get(holder.getAdapterPosition()).getId(), holder.getAdapterPosition());

              }
          });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolderShow extends RecyclerView.ViewHolder {
        TextView TvshowStudent;
        ImageView imjDeletShow;
        ConstraintLayout containerShowStudent;

        public MyHolderShow(@NonNull View itemView) {
            super(itemView);
            TvshowStudent = itemView.findViewById(R.id.TvshowStudent);
            imjDeletShow = itemView.findViewById(R.id.imjDeletShow);
            containerShowStudent = itemView.findViewById(R.id.containerShowStudent);
        }
    }

    interface onItemClickListener {


        void onItemDeleteClick(int id, int position);

        void onClick(Student student);
    }
}
