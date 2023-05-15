package com.railway.ionrail2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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

public class Alert extends AppCompatActivity {
    RecyclerView recyclerView;
    ValueEventListener eventListener;
    DatabaseReference databaseReference;
    ArrayList<DataClass3> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        recyclerView = findViewById(R.id.recyclerView3);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(Alert.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        dataList = new ArrayList<>();
        MyAdapter3 adapter = new MyAdapter3(Alert.this,dataList);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Traindata");

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList.clear();
                for (DataSnapshot itemSnapshot : snapshot.getChildren()){
                    DataClass3 dataClass = itemSnapshot.getValue(DataClass3.class);
                    dataList.add(dataClass);
                }
                adapter.notifyDataSetChanged();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
