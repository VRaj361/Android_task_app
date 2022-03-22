package com.example.taskapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BaseAdapter1  extends BaseAdapter {
    Context context;
    ArrayList<model> arr;

    public BaseAdapter1(Context context,ArrayList<model> arr){
        this.context=context;
        this.arr=arr;
    }
    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater.inflate(R.layout.row_file,null);//create file
        CircleImageView circleimage=view.findViewById(R.id.image_data);
        TextView textView=view.findViewById(R.id.brower_date);
        model model=arr.get(i);
        circleimage.setImageResource(arr.get(i).getStrimg());
        textView.setText(model.getStr());
        return view;
    }
}
