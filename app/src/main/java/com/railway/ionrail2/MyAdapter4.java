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

import java.util.ArrayList;
import java.util.List;

public class MyAdapter4 extends RecyclerView.Adapter<MyViewHolder4> {

    private Context context4;
    private ArrayList<DataClass4> dataList4;

    public MyAdapter4(Context context, ArrayList<DataClass4> dataList4) {
        this.context4 = context;
        this.dataList4 = dataList4;
    }

    @NonNull
    @Override
    public MyViewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context4).inflate(R.layout.recycler_item4,parent,false);
        return new MyViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder4 holder, int position) {
        DataClass4 dataClass4 = dataList4.get(position);
        holder.rear.setText(dataClass4.getDataRear());
        holder.front.setText(dataClass4.getDataFront());
        holder.recTimestamp2.setText(dataClass4.getDataTimeStamp2());
//        holder.recServodoor1.setText(dataList3.get(position).getDataServodoor());
//        holder.recUsonic1.setText(dataList3.get(position).getDataUsonic());
//        holder.recTimestamp1.setText(dataList3.get(position).getDataTimeStamp());

        holder.recCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context4, DetailActivity4.class);
                intent.putExtra("front", dataList4.get(holder.getAdapterPosition()).getDataFront());
                intent.putExtra("rear", dataList4.get(holder.getAdapterPosition()).getDataRear());
                intent.putExtra("timestamp", dataList4.get(holder.getAdapterPosition()).getDataTimeStamp2());
                context4.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList4.size();
    }
}
class MyViewHolder4 extends RecyclerView.ViewHolder {
    TextView front, rear, recTimestamp2;
    CardView recCard4;

    public MyViewHolder4(@NonNull View itemView) {
        super(itemView);

        recCard4 = itemView.findViewById(R.id.recCard4);
        rear = itemView.findViewById(R.id.recRear);
        front = itemView.findViewById(R.id.recFront);
        recTimestamp2 = itemView.findViewById(R.id.recTimeStamp2);
    }
}
