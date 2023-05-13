package com.railway.ionrail2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import com.example.ionrail2.R;
import com.google.android.material.navigation.NavigationView;

public class HomePageAdmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBar actionBar;
    Button btnAlert, btnContactStaff, btnEcomplaint;


   // @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_admin);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        btnAlert = findViewById(R.id.btnAlert);
        btnContactStaff = findViewById(R.id.btnContactStaff);
        btnEcomplaint = findViewById(R.id.btnEcomplaintAdminn);

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageAdmin.this, Alert.class);
                startActivity(intent);
            }
        });
        btnEcomplaint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageAdmin.this, AdminComplaint.class);
                startActivity(intent);
            }
        });
        btnContactStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageAdmin.this, AdminContactStaff.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("IonRAIL");
        }

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // navigationView.setNavigationItemSelectedListener(this);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(HomePageAdmin.this,HomePageAdmin.class);
                        startActivity(intent);
                        return  true;
                    case R.id.nav_ContactStaff:
                        Intent intent2 = new Intent(HomePageAdmin.this, AdminContactStaff.class);
                        startActivity(intent2);
                        return  true;
                    case R.id.nav_EComplaintAdmin:
                        Intent intent3 = new Intent(HomePageAdmin.this, AdminComplaint.class);
                        startActivity(intent3);
                        return true;
                    case R.id.nav_Alert:
                        Intent intent4  = new Intent(HomePageAdmin.this, Alert.class);
                        startActivity(intent4);
                        return  true;
                    case R.id.nav_logout:
                        finish();
                        /*intent = new Intent(HomePageAdmin.this, MainActivity.class);
                        startActivity(intent);*/
                        return  true;

                }
                return false;
            }
        });
    }

    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
    }
