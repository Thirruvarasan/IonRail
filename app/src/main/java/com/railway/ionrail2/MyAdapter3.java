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

public class MyAdapter3 extends RecyclerView.Adapter<MyViewHolder3> {

    private Context context3;
    private ArrayList<DataClass3> dataList3;

    public MyAdapter3(Context context, ArrayList<DataClass3> dataList3) {
        this.context3 = context;
        this.dataList3 = dataList3;
    }

    @NonNull
    @Override
    public MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context3).inflate(R.layout.recycler_item3,parent,false);
        return new MyViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder3 holder, int position) {
        DataClass3 dataClass3 = dataList3.get(position);
        holder.recServodoor1.setText(dataClass3.getDataServodoor());
        holder.recUsonic1.setText(dataClass3.getDataUsonic());
        holder.recTimestamp1.setText(dataClass3.getDataTimeStamp());
//        holder.recServodoor1.setText(dataList3.get(position).getDataServodoor());
//        holder.recUsonic1.setText(dataList3.get(position).getDataUsonic());
//        holder.recTimestamp1.setText(dataList3.get(position).getDataTimeStamp());

        holder.recCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context3, DetailActivity3.class);
                intent.putExtra("servodoor", dataList3.get(holder.getAdapterPosition()).getDataServodoor());
                intent.putExtra("usonic", dataList3.get(holder.getAdapterPosition()).getDataUsonic());
                intent.putExtra("timestamp", dataList3.get(holder.getAdapterPosition()).getDataTimeStamp());
                context3.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList3.size();
    }
}
class MyViewHolder3 extends RecyclerView.ViewHolder {
    TextView recServodoor1, recUsonic1, recTimestamp1;
    CardView recCard3;

    public MyViewHolder3(@NonNull View itemView) {
        super(itemView);

        recCard3 = itemView.findViewById(R.id.recCard3);
        recServodoor1 = itemView.findViewById(R.id.recAlert);
        recUsonic1 = itemView.findViewById(R.id.recUsonic);
        recTimestamp1 = itemView.findViewById(R.id.recTimeStamp);
    }
}
