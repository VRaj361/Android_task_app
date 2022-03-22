package com.example.taskapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class Astrology1 extends AppCompatActivity {
    Button sign_btn;
    EditText astro1_fname,astro1_lname,astro1_email,astro1_number;
    Button astro1_dob,astro1_dot;
    TextView astro1_tdob,astro1_tdot,astro1_seekbart;
    SeekBar astro1_seekbar;
    String astro1_seekval,astro1_ratingval,strData_city,astro1_gendert;
    RatingBar astro1_ratingbar;
    Spinner astro1_city;

    private int date,month,year;
    RadioGroup astro1_gender;
    RadioButton astro1_genderb;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astrology1);
        sign_btn=findViewById(R.id.astrology_signbtn);//button
        astro1_fname=findViewById(R.id.astro1_fname);//firstname
        astro1_lname=findViewById(R.id.astro1_lname);//lastname
        astro1_email=findViewById(R.id.astro1_email);//email
        astro1_number=findViewById(R.id.astro1_number);//number
        astro1_tdob=findViewById(R.id.astro1_tdob);//date of birth textview
        astro1_dob=findViewById(R.id.astro1_dob);//dob button
        astro1_tdot=findViewById(R.id.astro1_tdot);//date of today textview
        astro1_dot=findViewById(R.id.astro1_dot);//date of today button
        astro1_seekbar=findViewById(R.id.astro1_seekbar);//seekbar
        astro1_seekbart=(TextView) findViewById(R.id.astro1_seekbart);//seekbartext
        astro1_ratingbar=findViewById(R.id.astro1_ratingbar);//rating bar
        astro1_city=findViewById(R.id.astro1_city);//city
        astro1_gender=(RadioGroup) findViewById(R.id.astro1_gender);//gender







        String city[]={"City","Ahmedabad","Benglore","Chennai","Delhi","NewYork"};


        final String[] dob = {"",""};
        Calendar calendar=Calendar.getInstance();
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        year=calendar.get(Calendar.YEAR);
        astro1_dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(Astrology1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        astro1_tdob.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                        dob[0] =(dayOfMonth+"/"+(month+1)+"/"+year).toString();
                    }
                },year,month,date);
                datePickerDialog.show();
            }
        });

        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());


        astro1_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                astro1_tdot.setText(currentDate);
                dob[1]=currentDate;
            }
        });

        //seekbar
        astro1_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                astro1_seekbart.setText(String.valueOf(progress));
                astro1_seekval=String.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //rating bar
        astro1_ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                astro1_ratingval=String.valueOf(rating);
            }
        });


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.city_spinner_simple,city);
        arrayAdapter.setDropDownViewResource(R.layout.city_dropdown_city);

////        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,city){
////
//            @Override
//            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//                TextView city_spinner=(TextView)super.getDropDownView(position, convertView, parent);
////                if(position==0){
////                    city_spinner.setTextColor(Color.rgb(187,134,252));
////                }else{
//
//                    city_spinner.setTextColor(Color.rgb(187,134,252));
////                }
//                return city_spinner;
//
//            }
//        };
        astro1_city.setAdapter(arrayAdapter);

        astro1_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str_city=parent.getItemAtPosition(position).toString();
                if(str_city.equals("select an language")){

                }else {
                    strData_city=str_city;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sign_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gender
                int selectedId = astro1_gender.getCheckedRadioButtonId();
                astro1_genderb = (RadioButton) findViewById(selectedId);
                astro1_gendert=astro1_genderb.getText().toString();

                Boolean is_check=false;

                String fname=astro1_fname.getText().toString();
                String lname=astro1_lname.getText().toString();
                String email=astro1_email.getText().toString();
                String number=astro1_number.getText().toString();

                //fname
                if(fname.length()<=2||!(fname.charAt(0)>=65)||!(fname.charAt(0)<=97)){
//                    Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_SHORT).show();
//                    is_check=false;
                    astro1_fname.setError("first Name Mininum length is 2 and first Name starts with capital letter");
                    is_check=true;
                }





                //lname
                if(lname.length()<=2||!(lname.charAt(0)>=65)||!(lname.charAt(0)<=97)){
//                    Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_SHORT).show();
//                    is_check=false;
                    astro1_lname.setError("last Name Mininum length is 2 and Last Name starts with capital letter");
                    is_check=true;
                }



                //email
//                if(email.length()<=2||!email.contains("@")||!email.contains(".")){
////                    Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_SHORT).show();
////                    is_check=false;
//                    astro1_email.setError("Email must contain @ and . symbol");
//                    is_check=true;
//                }
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";





                //number
                if(number.length()==10){
                    for(int i=0;i<10;i++) {
                        if (!Character.isDigit(number.charAt(i))) {
//                            Toast.makeText(getApplicationContext(), "sucess", Toast.LENGTH_SHORT).show();
//                            is_check=false;
                            astro1_number.setError("number must contain only digit");
                            is_check = true;
                            break;
                        }
                    }
                }else{
                    astro1_number.setError("Number must have 10 digits");
                    is_check=true;
                }

                //city
                if(strData_city==null||strData_city.equals("City")){
//                    astro1_city.setError("Number must have 10 digits");

                    is_check=true;
                }

                //dob and dot
                if(dob[0]=="") {
                    is_check = true;
                    astro1_tdob.setError("Please select the date ");
                }if(dob[1]=="") {
                    is_check = true;
                    astro1_tdot.setError("Please select the date ");
                }

                //price
                if(astro1_seekval==null){
                    is_check=true;
                    astro1_seekbart.setError("Please select Price");
                }

                //rating
                if(astro1_ratingval==null){
                    is_check=true;
                }



                if(is_check==false) {
                    Intent intent = new Intent(Astrology1.this, Astrology2.class);
                    intent.putExtra("FNAME", fname);
                    intent.putExtra("LNAME", lname);
                    intent.putExtra("EMAIL", email);
                    intent.putExtra("NUMBER", number);
                    intent.putExtra("DOB", dob[0]);
                    intent.putExtra("DOT", dob[1]);
                    intent.putExtra("PRICE", astro1_seekval);
                    intent.putExtra("RATING", astro1_ratingval);
                    intent.putExtra("CITY", strData_city);
                    intent.putExtra("GENDER", astro1_gendert);


                    startActivity(intent);
                }
            }
        });




    }
}