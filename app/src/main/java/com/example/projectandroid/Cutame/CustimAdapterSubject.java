package com.example.projectandroid.Cutame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.R;
import com.example.projectandroid.modail.Supject;

import java.util.ArrayList;

public class CustimAdapterSubject extends RecyclerView.Adapter<CustimAdapterSubject.MyHolde> {
    Context context;
    ArrayList<Supject> data;
    onItemClickListener listener;

    public CustimAdapterSubject(Context context, ArrayList<Supject> data, onItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyHolde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itim_subject, parent, false);
        return new MyHolde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolde holder, int position) {
        holder.tv_55.setText(data.get(position).getSubject());
        holder.corner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(data.get(holder.getAdapterPosition()));
            }
        });
        holder.imj.setOnClickListener(new View.OnClickListener() {
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

    public class MyHolde extends RecyclerView.ViewHolder {
        TextView tv_55;

        ImageView imj;
        ConstraintLayout corner;


        public MyHolde(@NonNull View itemView) {
            super(itemView);
            tv_55 = itemView.findViewById(R.id.tv_55);

            imj = itemView.findViewById(R.id.imj);
            corner = itemView.findViewById(R.id.corner);

        }
    }

    interface onItemClickListener {


        void onItemDeleteClick(int id, int position);

        void onClick(Supject supject);
    }
}