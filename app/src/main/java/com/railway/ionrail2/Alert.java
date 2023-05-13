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
    MyAdapter3 MyAdapter3;
    DatabaseReference database;
    ArrayList<DataClass3> list3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        recyclerView = findViewById(R.id.recyclerView3);
        database = FirebaseDatabase.getInstance().getReference("Traindata");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list3 = new ArrayList<>();
        MyAdapter3 = new MyAdapter3(this, list3);
        recyclerView.setAdapter(MyAdapter3);

        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1 : snapshot.getChildren()){
                    DataClass3 dataClass3 = snapshot1.getValue(DataClass3.class);
                    list3.add(dataClass3);
                }
                MyAdapter3.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}