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

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass>dataList;

    public MyAdapter(Context context, List<DataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.recName.setText(dataList.get(position).getDataName());
        holder.recPhone.setText(dataList.get(position).getDataPhoneNumber());
        holder.recDesc.setText(dataList.get(position).getDataComplaint());

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Name",dataList.get(holder.getAdapterPosition()).getDataName());
                intent.putExtra("Phone",dataList.get(holder.getAdapterPosition()).getDataPhoneNumber());
                intent.putExtra("Desc",dataList.get(holder.getAdapterPosition()).getDataComplaint());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{
    TextView recPhone,recDesc,recName;
    CardView recCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        recCard = itemView.findViewById(R.id.recCard);
        recPhone = itemView.findViewById(R.id.recPhone);
        recName = itemView.findViewById(R.id.recName);
        recDesc = itemView.findViewById(R.id.recDesc);
    }
}
