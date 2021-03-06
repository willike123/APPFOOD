package com.example.android_appfood2;



import com.squareup.picasso.Picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Tab5v1 extends Fragment {
	
	

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_5v1,container,false);
        Bundle b=getArguments();
		foody data=(foody) b.getSerializable("item");
		TextView tieude=(TextView)v.findViewById(R.id.tieude);
		tieude.setText(data.getTieude());
		TextView diachi=(TextView)v.findViewById(R.id.diachi);
		diachi.setText(data.getDiachi());
		ImageView hinhanh=(ImageView)v.findViewById(R.id.hinhanh);
		
		  byte[] decodedString = Base64.decode(data.getTesthinhanh(), Base64.DEFAULT);
          Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
          hinhanh.setImageBitmap(decodedByte);
		
		
	//	Picasso.with(getContext()).load(data.getTesthinhanh()).into(hinhanh);
	//	hinhanh.setImageBitmap(data.getHinhanh());
		TextView rate=(TextView)v.findViewById(R.id.rate);
		rate.setText(Float.toString(data.getRate()));
		TextView menu=(TextView)v.findViewById(R.id.menu);
		menu.setText((data.getMenu()));
		TextView diachi1=(TextView)v.findViewById(R.id.diachi1);
		diachi1.setText((data.getDiachi()));
		TextView thanhpho=(TextView)v.findViewById(R.id.thanhpho);
		thanhpho.setText(data.getThanhpho());
		TextView des=(TextView)v.findViewById(R.id.des);
		des.setText(data.getDes());
		TextView gia=(TextView)v.findViewById(R.id.gia);
		gia.setText(data.getGia());
		TextView sdt=(TextView)v.findViewById(R.id.sdt);
		sdt.setText(data.getSdt());
		
        return v;
    }
}