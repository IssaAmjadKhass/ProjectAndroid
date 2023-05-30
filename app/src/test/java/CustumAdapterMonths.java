import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectandroid.CustemAdapterMonth;
import com.example.projectandroid.CustimAdapterSubject;
import com.example.projectandroid.R;
import com.example.projectandroid.modail.Months;

import org.junit.runner.manipulation.Ordering;

import java.util.ArrayList;

public class CustumAdapterMonths extends RecyclerView.Adapter<CustumAdapterMonths.MyHolder> {
    Context context;
ArrayList<Months>data;
    onboutton onboutton;

    public CustumAdapterMonths(Context context, ArrayList<Months> data, CustumAdapterMonths.onboutton onboutton) {
        this.context = context;
        this.data = data;
        this.onboutton = onboutton;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_month2, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
holder.today.setText(data.get(position).getMonths());
holder.btMonths.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        onboutton.onClick(data.get(holder.getAdapterPosition()));
    }
});
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView today;
        Button btMonths;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
          today=  itemView.findViewById(R.id.today);
            btMonths=itemView.findViewById(R.id.btMonths);


        }
    }
    interface  onboutton
    {
        void onClick(Months months);
    }
}
