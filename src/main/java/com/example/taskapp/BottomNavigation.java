package com.example.taskapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavigation extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        toolbar=findViewById(R.id.toolbar);
        bottomNavigationView=findViewById(R.id.nav_bar);
        setSupportActionBar(toolbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.nav_bar_home){
                    Toast.makeText(BottomNavigation.this, "Home" , Toast.LENGTH_SHORT).show();
                    toolbar.setTitle("Home");
                }else if(id==R.id.nav_bar_title){
                    Toast.makeText(BottomNavigation.this, "Title" , Toast.LENGTH_SHORT).show();
                    toolbar.setTitle("Title");
                }else if(id==R.id.nav_bar_exit){
                    Toast.makeText(BottomNavigation.this, "Exit" , Toast.LENGTH_SHORT).show();
                    toolbar.setTitle("Exit");
                }
                return true;
            }
        });
    }
}