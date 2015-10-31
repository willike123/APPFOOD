package com.example.android_appfood2;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab4v0 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_4v0,container,false);
        FragmentManager	fm=getFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		ft.replace(R.id.frg4, new Tab4()); ////R.id.frame1_1 chi thay doi 1 cai id frame duy nhat	
		//ft.addToBackStack("1");
		ft.commit();
        return v;
    }
}