package com.railway.ionrail2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.ionrail2.R;
import com.google.android.material.navigation.NavigationView;

public class StaffHomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBar actionBar;
    Button btnContactAdmin, btnAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_home_page);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        btnAlert = findViewById(R.id.btnAlertt);
        btnContactAdmin = findViewById(R.id.btnContactAdmin);

        btnContactAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffHomePage.this,AlertFromAdmin.class);
                startActivity(intent);
            }
        });

        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaffHomePage.this,Alert.class);
                startActivity(intent);
            }
        });


        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setTitle("IonRAIL");
        }

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_home:
                        Intent intent = new Intent(StaffHomePage.this,StaffHomePage.class);
                        startActivity(intent);
                        return  true;
                    case R.id.nav_AlertFromAdmin:
                        intent = new Intent(StaffHomePage.this, AlertFromAdmin.class);
                        startActivity(intent);
                        return  true;
                    case R.id.nav_logout:
                        finish();
//                        intent = new Intent(StaffHomePage.this, MainActivity.class);
//                        startActivity(intent);
                        return  true;
                    case R.id.nav_StaffAlert:
                        intent = new Intent(StaffHomePage.this, Alert.class);
                        startActivity(intent);
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
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}