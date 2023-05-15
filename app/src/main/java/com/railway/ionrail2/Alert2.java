package com.railway.ionrail2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ionrail2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Alert2 extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<DataClass4> dataList4;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert2);

        recyclerView = findViewById(R.id.recyclerView4);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(Alert2.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        dataList4 = new ArrayList<>();
        MyAdapter4 adapter = new MyAdapter4(Alert2.this,dataList4);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Obstaclecheck");

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList4.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()){
                    DataClass4 dataClass = itemSnapshot.getValue(DataClass4.class);
                    dataList4.add(dataClass);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}