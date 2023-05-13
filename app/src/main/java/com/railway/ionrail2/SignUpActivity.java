package com.railway.ionrail2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

import com.example.ionrail2.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    EditText signUpName, signUpEmail, signUpUsername, signUpPassword;
    TextView DirectLogin;
    Button SignUpButton;
    FirebaseDatabase database;
    DatabaseReference reference;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        signUpName = findViewById(R.id.signUpName);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpUsername = findViewById(R.id.signUpUsername);
        signUpPassword = findViewById(R.id.signUpPassword);
        SignUpButton = findViewById(R.id.SignUpButton);
        DirectLogin = findViewById(R.id.login);
        spinner = findViewById(R.id.spinner);



        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("USER");
        arrayList.add("ADMIN");
        arrayList.add("STAFF");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        AlertDialog.Builder Adminmydialog = new AlertDialog.Builder(SignUpActivity.this);
        Adminmydialog.setTitle("ENTER ADMIN CODE!");

        final EditText Admincode = new EditText(SignUpActivity.this);
        Admincode.setInputType(InputType.TYPE_CLASS_NUMBER);
        Admincode.setTransformationMethod(PasswordTransformationMethod.getInstance());
        Adminmydialog.setView(Admincode);

        Adminmydialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                double codeEnter = Double.parseDouble(Admincode.getText().toString());
                if (codeEnter == 12345) {
                    Toast.makeText(SignUpActivity.this, "Valid Code", Toast.LENGTH_SHORT).show();
                    SignUpButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (validateName() & validateEmail() & validateUsername() & validatePassword()) {
                            database = FirebaseDatabase.getInstance();
                            reference = database.getReference("users");


                            String name = signUpName.getText().toString();
                            String email = signUpEmail.getText().toString();
                            String username = signUpUsername.getText().toString();
                            String password = signUpPassword.getText().toString();


                            HelperClass helperClass = new HelperClass(name, email, username, password, 1);
                            reference.child(name).setValue(helperClass);

                            Toast.makeText(SignUpActivity.this, "Successfully created account", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignUpActivity.this, "Failed to created account", Toast.LENGTH_SHORT).show();
                        }
                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this, "Invalid Code", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        Adminmydialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        AlertDialog.Builder mydialogStaff = new AlertDialog.Builder(SignUpActivity.this);
        mydialogStaff.setTitle("ENTER STAFF CODE!");

        final EditText Staffcode = new EditText(SignUpActivity.this);
        Staffcode.setInputType(InputType.TYPE_CLASS_NUMBER);
        Staffcode.setTransformationMethod(PasswordTransformationMethod.getInstance());
        mydialogStaff.setView(Staffcode);

        mydialogStaff.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                double codeEnter = Double.parseDouble(Staffcode.getText().toString());
                if (codeEnter == 67890) {
                    Toast.makeText(SignUpActivity.this, "Valid Code", Toast.LENGTH_SHORT).show();
                    SignUpButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (validateName() & validateEmail() & validateUsername() & validatePassword()) {
                            database = FirebaseDatabase.getInstance();
                            reference = database.getReference("users");


                            String name = signUpName.getText().toString();
                            String email = signUpEmail.getText().toString();
                            String username = signUpUsername.getText().toString();
                            String password = signUpPassword.getText().toString();


                            HelperClass helperClass = new HelperClass(name, email, username, password, 2);
                            reference.child(name).setValue(helperClass);

                            Toast.makeText(SignUpActivity.this, "Successfully created account", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(intent);
                            } else {Toast.makeText(SignUpActivity.this, "Failed to created account", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this, "Invalid Code", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        mydialogStaff.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = spinner.getSelectedItem().toString();
                if (item == ("ADMIN")) {
                    Adminmydialog.show();
                }
                if (item == ("USER")) {

                    SignUpButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (validateName() & validateEmail() & validateUsername() & validatePassword()) {
                                database = FirebaseDatabase.getInstance();
                                reference = database.getReference("users");


                                String name = signUpName.getText().toString();
                                String email = signUpEmail.getText().toString();
                                String username = signUpUsername.getText().toString();
                                String password = signUpPassword.getText().toString();



                                HelperClass helperClass = new HelperClass(name, email, username, password, 3);
                                reference.child(username).setValue(helperClass);

                                Toast.makeText(SignUpActivity.this, "Successfully created account", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SignUpActivity.this, "Failed to created account", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

                if (item == ("STAFF")) {
                    mydialogStaff.show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        DirectLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    public boolean validateUsername() {
        String val = signUpUsername.getText().toString();
        if (val.isEmpty()) {
            signUpUsername.setError("Username cannot be empty");
            return false;
        } else {
            signUpUsername.setError(null);
            return true;
        }
    }

    public boolean validatePassword() {
        String val = signUpPassword.getText().toString();
        //final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        if (val.isEmpty()) {
            signUpPassword.setError("Password cannot be empty");
            return false;
        } else {
        signUpPassword.setError(null);
        return true;
    }}

    public boolean validateName() {
        String val = signUpName.getText().toString();

        if (val.isEmpty()) {
            signUpName.setError("Username cannot be empty");
            return false;
        } else {
            signUpName.setError(null);
            return true;
        }
    }

    public boolean validateEmail() {
        String val = signUpEmail.getText().toString();
        if (!val.isEmpty() & Patterns.EMAIL_ADDRESS.matcher(val).matches()) {
            signUpEmail.setError(null);
            return true;
        } else {
            signUpEmail.setError("Enter a valid Email!");
            return false;
        }

    }
}
