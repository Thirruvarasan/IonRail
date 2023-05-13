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

public class AlertFromAdmin extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataClass2> dataList2;
    DatabaseReference databaseReference;
    ValueEventListener eventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_from_admin);

        recyclerView = findViewById(R.id.recyclerView2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(AlertFromAdmin.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);

        dataList2 = new ArrayList<>();
        MyAdapter2 adapter = new MyAdapter2(AlertFromAdmin.this,dataList2);
        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Instruction");

        eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dataList2.clear();
                for (DataSnapshot itemSnapshot3 : snapshot.getChildren()){
                    DataClass2 dataClass2 = itemSnapshot3.getValue(DataClass2.class);
                    dataList2.add(dataClass2);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}