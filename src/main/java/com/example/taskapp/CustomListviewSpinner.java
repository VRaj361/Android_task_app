package com.example.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomListviewSpinner extends AppCompatActivity {
    String str[]={"select the flag","India","United Kindom","Australia"};
    int strimg[]={R.color.black,R.drawable.indiaflag,R.drawable.ukflag,R.drawable.au};
    //drawable file which contain images
    //whole listview show in vertical format
//    Spinner spinner;
    Spinner spinner_ti;
    ArrayList<model> arr;//create file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview_spinner);
//        spinner=findViewById(R.id.spinner_basic);
        spinner_ti=findViewById(R.id.spinner_basic);
        arr=new ArrayList<model>();
        for (int i=0;i<str.length;i++){
            model mod=new model(str[i],strimg[i]);
            arr.add(mod);

        }

        BaseAdapter1 baseAdapter1=new BaseAdapter1(this,arr);
        spinner_ti.setAdapter(baseAdapter1);
        spinner_ti.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i!=0){
                    String strData=arr.get(i).getStr();
                int img=arr.get(i).getStrimg();

                Intent intent=new Intent(CustomListviewSpinner.this,data_display_listview.class);
                intent.putExtra("LISTTXTDATA",strData);
                intent.putExtra("LISTIMGDATA",img);
                startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );



//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String strData=arr.get(position).getStr();
//                int img=arr.get(position).getStrimg();
//
//                Intent intent=new Intent(CustomListviewSpinner.this,data_display_listview.class);
//                intent.putExtra("LISTTXTDATA",strData);
//                intent.putExtra("LISTIMGDATA",img);
//                startActivity(intent);
//
//                Toast.makeText(CustomListviewSpinner.this, strData, Toast.LENGTH_SHORT).show();
//            }




//        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,str);


    }
}