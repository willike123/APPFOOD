package com.example.android_appfood2;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;

import android.R.drawable;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class myadaptercustom3 extends ArrayAdapter<foodybinhluan>{
	//CheckBox check;
	 
	foodybinhluan person;
	// Bitmap myBitmap;
	 Context context;
	// boolean check1;
	  public myadaptercustom3(Context context, int textViewResourceId, List<foodybinhluan> objects) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		this.context=context;
         
	}

	@Override
      public View getView(int position, View convertView, ViewGroup parent) {
             // Get the data item for this position
		final int pos=position;
		person = getItem(position);
             // Check if an existing view is being reused, otherwise inflate the view
             if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(
                                          R.layout.itemcustombinhluan, parent, false);
             }
             // Lookup view for data population
          //   check=(CheckBox) convertView.findViewById(R.id.checkBox1);
             TextView ten = (TextView) convertView.findViewById(R.id.textView1);
             TextView mota = (TextView) convertView.findViewById(R.id.textView2);
     //        ImageView img=    (ImageView)convertView.findViewById(R.id.imageView1);
     //        TextView giamgia = (TextView)convertView.findViewById(R.id.textView3);
        //     ImageView img1=(ImageView) convertView.findViewById(R.id.imageView2);
             // Populate the data into the template view using the data object
             ten.setText(person.getUsername());
             mota.setText(person.getBinhluan());
    	//	  img.setImageBitmap(person.getHinhanh());
    	//	  giamgia.setText(person.getGiamgia()+"%");
    	//	  Picasso.with(context).load(person.getTesthinhanh()).into(img);
    	/*	  img1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Tab4 tab4=new Tab4();
					tab4.removelist(pos);
				}
			});*/
             
           //  check.setOnClickListener(this);
             // Return the completed view to render on screen
             return convertView;
      }

	


	

	

}
