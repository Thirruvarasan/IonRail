package com.railway.ionrail2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ionrail2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;


public class EComplaintUser extends AppCompatActivity {

    EditText name,phone,complaint;

    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecomplaint_user);

        name = findViewById(R.id.editName);
        phone = findViewById(R.id.editPhoneNumber);
        complaint = findViewById(R.id.editTextComplaint);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData();
            }
        });

    }
    public void uploadData(){
        String name1 = name.getText().toString();
        String phone1 = phone.getText().toString();
        String complaint1 = complaint.getText().toString();

        DataClass dataClass = new DataClass(name1,phone1,complaint1);

        FirebaseDatabase.getInstance().getReference("E-Complaints").child(name1).setValue(dataClass).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(EComplaintUser.this,"Success!",Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(EComplaintUser.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
