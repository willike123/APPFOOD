package com.example.android_appfood2;

import java.util.ArrayList;

import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class infobinhluan extends Activity{
	TextView tv1,tv2;
	GridView gr1;
	String[] hinhanh;
	foodybinhluan data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infobinhluan);
		tv1=(TextView)findViewById(R.id.textView1);
		tv2=(TextView)findViewById(R.id.textView2);
		Intent i=getIntent();
		Bundle b=i.getExtras();
		 data=(foodybinhluan) b.getSerializable("info");
		 tv1.setText(data.getUsername().toString());
		 tv2.setText(data.getBinhluan().toString());
		 hinhanh=data.getHinhanh().replace(" ", "%20").split("\\|");
		gr1=(GridView)findViewById(R.id.gr);
		gr1.setAdapter(new ImageAdapter(this));
		gr1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				dialogfrag diag=new dialogfrag();
				
				diag.nhandulieu(hinhanh[position]);
				diag.show(getFragmentManager(),"dialog");
			}
		});
		
	}
	
	
	public class ImageAdapter extends BaseAdapter {
	    private Context mContext;

	    public ImageAdapter(Context c) {
	        mContext = c;
	    }

	    public int getCount() {
	        return hinhanh.length;
	    }

	    public Object getItem(int position) {
	        return null;
	    }

	    public long getItemId(int position) {
	        return 0;
	    }

	    // create a new ImageView for each item referenced by the Adapter
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView;
	        if (convertView == null) {
	            // if it's not recycled, initialize some attributes
	            imageView = new ImageView(mContext);
	            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
	            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	           
	        } else {
	            imageView = (ImageView) convertView;
	        }
	        
	        Picasso.with(mContext).load("http://ddl-mediafire.com/Spam/upload2/uploads/"+hinhanh[position]).into(imageView);
	        return imageView;
	    }

		

	    // references to our images
	  
	}

}
