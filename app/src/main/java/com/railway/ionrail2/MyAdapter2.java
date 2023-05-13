package com.railway.ionrail2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ionrail2.R;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyViewHolder2> {

    private Context context2;
    private List<DataClass2> dataList2;

    public MyAdapter2(Context context, List<DataClass2> dataList2) {
        this.context2 = context;
        this.dataList2 = dataList2;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item2,parent,false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        holder.recDate.setText(dataList2.get(position).getDataDate());
        holder.recTime.setText(dataList2.get(position).getDataTime());
        holder.recInstruction.setText(dataList2.get(position).getDataInstruction());

        holder.recCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context2, DetailActivity2.class);
                intent.putExtra("Date",dataList2.get(holder.getAdapterPosition()).getDataDate());
                intent.putExtra("Time",dataList2.get(holder.getAdapterPosition()).getDataTime());
                intent.putExtra("Instruction",dataList2.get(holder.getAdapterPosition()).getDataInstruction());
                context2.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList2.size();
    }
}

class MyViewHolder2 extends RecyclerView.ViewHolder{
    TextView recDate,recTime,recInstruction;
    CardView recCard2;

    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);

        recCard2 = itemView.findViewById(R.id.recCard2);
        recDate = itemView.findViewById(R.id.recDate);
        recTime = itemView.findViewById(R.id.recTime);
        recInstruction = itemView.findViewById(R.id.recInstruction);
    }
}