package com.example.projectandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.modail.Days1;

import java.util.ArrayList;

public class CustumAdapterDay extends RecyclerView.Adapter<CustumAdapterDay.MyHolder> {
    private Context context;
    private ArrayList<Days1> data;
    private linerLayout layout;

    public CustumAdapterDay(Context context, ArrayList<Days1> data, linerLayout layout) {
        this.context = context;
        this.data = data;
        this.layout = layout;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_days, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Days1 days1 = data.get(position);
        holder.today.setText(String.valueOf(days1.getDays()));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (layout != null) {
                    layout.onClick(String.valueOf(days1.getDays()), position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView today;
        LinearLayout layout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            today = itemView.findViewById(R.id.today);
            layout = itemView.findViewById(R.id.layout_Days);
        }
    }

    public interface linerLayout {
        void onClick(String valueOf, int position);
    }
}