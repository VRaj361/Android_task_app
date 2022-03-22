package com.example.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class data_display_listview extends AppCompatActivity {
    ImageView img;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_display_listview);
        text=findViewById(R.id.data_custom_view_redirect_text);
        img=findViewById(R.id.data_custom_view_redirect_img);
        Intent intent=getIntent();
        String str=intent.getStringExtra("LISTTXTDATA");
        int img1=intent.getIntExtra("LISTIMGDATA",0);
        img.setImageResource(img1);



        text.setText(str);


    }
}