package com.railway.ionrail2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ionrail2.R;

public class DetailActivity2 extends AppCompatActivity {
    TextView date,time,instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        date = findViewById(R.id.detailDate);
        time = findViewById(R.id.detailTime);
        instruction = findViewById(R.id.detailInstruction);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            date.setText(bundle.getString("Date"));
            time.setText(bundle.getString("Time"));
            instruction.setText(bundle.getString("Instruction"));
        }
    }
}

