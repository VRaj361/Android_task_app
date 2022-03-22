package com.example.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class Astrology_splash extends AppCompatActivity {
ImageView splash_astrology;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astrology_splash);
        splash_astrology=findViewById(R.id.splash_astrology);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Astrology_splash.this,Astrology.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}