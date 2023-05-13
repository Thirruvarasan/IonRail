package com.railway.ionrail2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ionrail2.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText loginUsername, loginPassword;
    Button loginButton;
    TextView directSignUp;
    private ProgressDialog mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        loginButton = findViewById(R.id.LoginButton);
        loginUsername = findViewById(R.id.LoginUsername);
        loginPassword = findViewById(R.id.LoginPassword);
        directSignUp = findViewById(R.id.signUp);


        mProgress = new ProgressDialog(this);
        mProgress.setTitle("Processing...");
        mProgress.setMessage("Please wait...");
        mProgress.setCancelable(false);
        mProgress.setIndeterminate(true);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgress.show();
                if (!validateUsername() | !validatePassword()) {
                    mProgress.dismiss();
                } else {
                    checkUser();
                    loginUsername.setText("");
                    loginPassword.setText("");
                    loginUsername.requestFocus();
                }
            }
        });
        directSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }


    public boolean validateUsername() {
        String val = loginUsername.getText().toString();
        if (val.isEmpty()) {
            loginUsername.setError("Username cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }

    public boolean validatePassword() {
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }




    public void checkUser() {
        String userUsername = loginUsername.getText().toString();
        String userPassword = loginPassword.getText().toString();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
        //FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
       // firebaseDatabase.getReference().child("users").child(userUsername).child("userType").addListenerForSingleValueEvent(new ValueEventListener(){
         checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mProgress.dismiss();
                if (snapshot.exists()) {
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    if (passwordFromDB.equals(userPassword)){
                        mProgress.dismiss();
                        loginUsername.setError(null);

                        for( DataSnapshot snapshot1 : snapshot.getChildren()) {
                            int userType = snapshot1.child("userType").getValue(Integer.class);

                            if (userType == 1) {
                                Intent intent = new Intent(LoginActivity.this, HomePageAdmin.class);
                                startActivity(intent);
                            } else if (userType == 2) {
                                Intent intent = new Intent(LoginActivity.this, StaffHomePage.class);
                                startActivity(intent);
                            } else if (userType == 3) {
                                Intent intent = new Intent(LoginActivity.this, UserHomePage.class);
                                startActivity(intent);
                            }
                        }


                    } else {
                        mProgress.dismiss();
                        loginPassword.setError("Invalid Credentials!");
                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError("User doesn't exist!");
                    loginUsername.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
