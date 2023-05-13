package com.railway.ionrail2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ionrail2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AdminContactStaff extends AppCompatActivity {
    EditText date,time,instruction;
    //CalendarView date;
    Button btnSend;
    String Date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_contact_staff);

        date = findViewById(R.id.editDate);
        time = findViewById(R.id.editTime);
        instruction = findViewById(R.id.editInstruction);
        btnSend = findViewById(R.id.button);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadData2();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              showDate();
            }
        });


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showTimePicker();
            }
        });
    }

    private void showDate(){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void showTimePicker(){
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(AdminContactStaff.this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                String h = Integer.toString(selectedHour);
                String m = Integer.toString(selectedMinute);
                time.setText(h+":"+m);
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }
    public void uploadData2(){
        String date1 = date.getText().toString();
        String time1 = time.getText().toString();
        String instruction1 = instruction.getText().toString();

        DataClass2 dataClass2 = new DataClass2(date1,time1,instruction1);

        FirebaseDatabase.getInstance().getReference("Instruction").child(date1).setValue(dataClass2).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(AdminContactStaff.this,"Success!",Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AdminContactStaff.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}