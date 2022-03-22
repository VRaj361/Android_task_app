package com.example.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Astrology extends AppCompatActivity {
    Button astrology_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astrology);
        astrology_btn=findViewById(R.id.astrology_btn);
        astrology_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Astrology.this,Astrology1.class);
                startActivity(intent);
            }
        });
    }
}
