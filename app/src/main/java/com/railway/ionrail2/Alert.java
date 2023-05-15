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
    ArrayList<DataClass3> dataList3;
    DatabaseReference databaseReference;
//    ValueEventListener eventListener;
    MyAdapter3 myAdapter3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        recyclerView = findViewById(R.id.recyclerView3);
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(Alert.this,1);
//        recyclerView.setLayoutManager(gridLayoutManager);
//
//        dataList3 = new ArrayList<>();
//        MyAdapter3 adapter = new MyAdapter3(Alert.this,dataList3);
//        recyclerView.setAdapter(adapter);
         recyclerView.setHasFixedSize(true);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference("Traindata");

        dataList3 = new ArrayList<>();
        myAdapter3 = new MyAdapter3(this,dataList3);
        recyclerView.setAdapter(myAdapter3);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList3.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    DataClass3 dataClass = dataSnapshot.getValue(DataClass3.class);
                    dataList3.add(dataClass);
                }
                myAdapter3.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}