package com.railway.ionrail2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ionrail2.R;

public class DetailActivity extends AppCompatActivity {
    TextView txtName,txtPhone,txtDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtName = findViewById(R.id.detailName);
        txtPhone = findViewById(R.id.detailPhone);
        txtDesc = findViewById(R.id.detailDesc);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            txtName.setText(bundle.getString("Name"));
            txtPhone.setText(bundle.getString("Phone"));
            txtDesc.setText(bundle.getString("Desc"));
        }
    }
}
