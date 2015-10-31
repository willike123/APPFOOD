package com.example.android_appfood2;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<DrawerItem> {
       public MyArrayAdapter(Context context, int textViewResourceId, List<DrawerItem> objects) {
              super(context, textViewResourceId, objects);
       }

       @Override
       public View getView(int position, View convertView, ViewGroup parent) {
              DrawerItem drawitem = getItem(position);
             
              if (convertView == null) {
                     convertView = LayoutInflater.from(getContext()).inflate(R.layout.drawer_list_item, parent, false);
              }
             
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
       
        Log.i("hehe", drawitem.getTitle() + ",Hinh:" + drawitem.getIcon());
        imgIcon.setImageResource(drawitem.getIcon());       
        txtTitle.setText(drawitem.getTitle());
             
              return convertView;
       }
}
