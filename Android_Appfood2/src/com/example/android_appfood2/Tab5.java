package com.example.android_appfood2;



import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Tab5 extends Fragment implements OnItemClickListener {
	ListView lv;
	myadaptercustom3 adt;
	foody data=new foody();
   List<foodybinhluan> listview=new ArrayList<foodybinhluan>();
	
    public void nhandulieu(List<foodybinhluan> listview1){
    	this.listview=listview1;
    }
	
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_5,container,false);
        Bundle b=getArguments();
		 data=(foody) b.getSerializable("item");
		
		lv=(ListView)v.findViewById(R.id.listView1);
		ImageView img=(ImageView)v.findViewById(R.id.imageView1);
		TextView tieude=(TextView)v.findViewById(R.id.tieude);
		tieude.setText(data.getTieude());
		TextView diachi=(TextView)v.findViewById(R.id.diachi);
		diachi.setText(data.getDiachi());
		ImageView hinhanh=(ImageView)v.findViewById(R.id.hinhanh);
		Picasso.with(getContext()).load(data.getTesthinhanh()).into(hinhanh);
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
		lv=(ListView)v.findViewById(R.id.listView1);
		adt=new myadaptercustom3(getContext(), R.layout.tab_4, listview);
		lv.setAdapter(adt);
		lv.setOnItemClickListener(this);
		img.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if (data.getLatitude()==0 && data.getLongitude()==0 ){
					Toast.makeText(getContext(), "Chưa cập nhật tọa độ", Toast.LENGTH_SHORT).show();
				}else {
				Intent ii=new Intent(getActivity(),googlemap.class);
		    	Bundle bb=new Bundle();
		    	bb.putDouble("latitude", data.getLatitude());
		    	bb.putDouble("longitude", data.getLongitude());
		    	bb.putString("tieude", data.getTieude());
		    	bb.putString("diachi", data.getDiachi());
		    	ii.putExtras(bb);
		    	startActivity(ii);
				}
			}
		});
		
		
        return v;
    }



	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		foodybinhluan getbl=adt.getItem(position);
		Intent ii=new Intent(getActivity(),infobinhluan.class);
    	Bundle bb=new Bundle();
    	bb.putSerializable("info", getbl);
    	ii.putExtras(bb);
    	startActivity(ii);
		
	}
}