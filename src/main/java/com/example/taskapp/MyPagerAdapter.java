package com.example.taskapp;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {


    int tabcount;
    public MyPagerAdapter(FragmentManager supportFragmentManager, int tabCount) {
        super(supportFragmentManager);
        this.tabcount=tabCount;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                WhatsappChat whatsappChat=new WhatsappChat();
                return whatsappChat;


            case 1:
                WhatsappChat whatsappChat2=new WhatsappChat();
                return whatsappChat2;



            case 2:
                WhatsappChat whatsappChat1=new WhatsappChat();
                return whatsappChat1;
        }


        return null;
    }


    @Override
    public int getCount() {
        return tabcount;
    }
}
