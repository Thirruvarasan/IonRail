package com.railway.ionrail2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ionrail2.R;

public class DetailActivity3 extends AppCompatActivity {
    TextView timestamp,usonic,servodoor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail3);

            timestamp = findViewById(R.id.detailTimestamp);
            usonic = findViewById(R.id.detailUsonic);
            servodoor = findViewById(R.id.detailAlert);

            Bundle bundle = getIntent().getExtras();
            if (bundle != null){
                timestamp.setText(bundle.getString("dataDate"));
                usonic.setText(bundle.getString("dataInstruction"));
                servodoor.setText(bundle.getString("dataTime"));
            }
        }
    }