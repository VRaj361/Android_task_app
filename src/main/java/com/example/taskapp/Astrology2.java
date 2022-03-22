package com.example.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Calendar;

public class Astrology2 extends AppCompatActivity {
    TextView astro2_fname,astro2_lname,astro2_email,astro2_number,astro2_gendera,astro2_dob,astro2_dot,astro2_seekval,astro2_ratingbar,astro2_city;
    RadioGroup astro2_gender;
//    Button astro1_dob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astrology2);
        astro2_fname=findViewById(R.id.astro2_fname);//firstname
        astro2_lname=findViewById(R.id.astro2_lname);//lastname
        astro2_email=findViewById(R.id.astro2_email);//email
        astro2_number=findViewById(R.id.astro2_number);//number
        astro2_dot=findViewById(R.id.astro2_dot);//date of today
        astro2_seekval=findViewById(R.id.astro2_seekval);//seekbarvalue price
        astro2_ratingbar=findViewById(R.id.astro2_ratingbar);//rating bar
        astro2_city=findViewById(R.id.astro2_city);//city
        astro2_gendera=findViewById(R.id.astro2_gendera);//gender

        Intent intent=getIntent();

        String fname=intent.getStringExtra("FNAME");
        astro2_fname.setText(fname);
        String lname=intent.getStringExtra("LNAME");
        astro2_lname.setText(lname);
        String email=intent.getStringExtra("EMAIL");
        astro2_email.setText(email);
        String number=intent.getStringExtra("NUMBER");
        astro2_number.setText(number);

        astro2_dob=findViewById(R.id.astro2_dob);//date of birth
        String dob=intent.getStringExtra("DOB");
        astro2_dob.setText(dob);

        String dot=intent.getStringExtra("DOT");
        astro2_dot.setText(dot);

        String seekval=intent.getStringExtra("PRICE");
        astro2_seekval.setText(seekval);

        String ratingval=intent.getStringExtra("RATING");
        astro2_ratingbar.setText(ratingval);

        String city=intent.getStringExtra("CITY");
        astro2_city.setText(city);

        String gender=intent.getStringExtra("GENDER");
        astro2_gendera.setText(gender);

//        astro2_gender=(RadioGroup) findViewById(R.id.astro1_gender);
//        astro2_gendera=findViewById(R.id.astro2_gendera);
//        astro2_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                int childCount=group.getChildCount();
//                String gender=null;
//                for(int i=0;i<childCount;i++){
//                    RadioButton btn=(RadioButton) group.getChildAt(i);
//                    if(btn.getId()==R.id.astro1_male){
//                        btn.setText("Male");
//                    }else{
//                        btn.setText("Female");
//                    }
//                    if(btn.getId()==checkedId){
//                        gender=btn.getText().toString();
//                        Log.e("gender", gender);
//                        astro2_gendera.setText(gender);
//                    }
//                }
//            }
//        });





    }

}