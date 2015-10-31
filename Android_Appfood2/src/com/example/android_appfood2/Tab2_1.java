package com.example.android_appfood2;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Tab2_1 extends Fragment implements OnItemClickListener, OnRefreshListener {
	static ArrayList<foody> dataluu1;
	static myadaptercustom2 adt1;
	 SwipeRefreshLayout swipeLayout;
	foody goi;
	int pause=0;
	 ListView lv;
	  EditText ed;
	 Spinner sp;
	static TextView tv;
	static List<String> thanhpho;
	 ArrayAdapter<String> dataAdapter;
	 static ArrayList<foody> datalist;
	 List<foodybinhluan> arraybl=new ArrayList<foodybinhluan>();
	 String thanhphosearch="";
	 String text="";
		@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v("frag2-1", "onCreate :"+savedInstanceState);
		super.onCreate(savedInstanceState);
	
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.v("frag2-1", "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		Log.v("frag2-1", "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		Log.v("frag2-1", "onDetach");
		super.onDetach();
	}





@Override
public void onPause() {
	// TODO Auto-generated method stub
	Log.v("frag2-1", "onPause");
	pause=1;
	

	super.onPause(); 
}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		Log.v("frag2-1 ", "onResume");
	
		super.onResume();
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Log.v("frag2-1", "onStart  ");
		
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		Log.v("frag2-1", "onStop aaa");
		super.onStop();
	}
	
	public void nhandulieu(foody a) {
		
		
			if (!dataluu1.contains(a)){
				dataluu1.add(a);
				datalist.add(a);
			}
		
	//	i=10;
	//	Log.v("3", ""+i);
		}
	
	public void binhluangiamgia(List<foodybinhluan> foodybladd){
		
		this.arraybl=foodybladd;
	}
	
	public void menu(String a) {
		
		
		if (!thanhpho.contains(a)){
			thanhpho.add(a);
			
		}
	
//	i=10;
//	Log.v("3", ""+i);
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_2,container,false);
       
      
        
        Log.v("tab4", " "+container);
        tv=(TextView)v.findViewById(R.id.textView1);
        ed=(EditText)v.findViewById(R.id.editText1);
        sp=(Spinner)v.findViewById(R.id.spinner1);
        if (pause==1){
        	tv.setVisibility(View.GONE);
        }else {
        	  datalist=new ArrayList<foody>();
              dataluu1=new ArrayList<foody>();
              thanhpho=new ArrayList<String>();
        	ed.setVisibility(View.GONE);
        	sp.setVisibility(View.GONE);
              thanhpho.add("Thành Phố");
        }
       
        swipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_container1);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright, 
                android.R.color.holo_green_light, 
                android.R.color.holo_orange_light, 
                android.R.color.holo_red_light);
    //   Button bt=(Button) v.findViewById(R.id.button1);
        
        dataAdapter = new ArrayAdapter<String>(getActivity(),
        		R.layout.spinner_item, thanhpho);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);
  	  lv=(ListView)v.findViewById(R.id.listView1);  
  	adt1=new myadaptercustom2(getContext(), R.layout.tab_2, dataluu1);
	lv.setAdapter(adt1);
	lv.setOnItemClickListener(this);
      
	ed.addTextChangedListener(new TextWatcher() {
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			//String text = ed.getText().toString().toLowerCase(Locale.getDefault());
		//	adt1.getFilter().filter(s.toString());
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			// TODO Auto-generated method stub
		
			
		}
		
		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			 text = ed.getText().toString().toLowerCase();
			filter(text,thanhphosearch);
		
			
		}
	});
	
	sp.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			// TODO Auto-generated method stub
			if (position!=0){
				thanhphosearch=dataAdapter.getItem(position);
			}else {
				thanhphosearch="";
			}
			filter(text,thanhphosearch);
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
	});
	
	
        return v;
    }
    
    
   
    
    

	@Override 
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {   	
                swipeLayout.setRefreshing(false);   
                if (dataluu1.isEmpty()){
            		tv.setText("Hiện Tại Chưa Có Khuyến Mãi");
            		tv.setVisibility(View.VISIBLE);
            		sp.setVisibility(View.GONE);
            		ed.setVisibility(View.GONE);
            	}else {
            		
            	tv.setVisibility(View.GONE);
                sp.setVisibility(View.VISIBLE);
                ed.setVisibility(View.VISIBLE);
                adt1.notifyDataSetChanged();
                dataAdapter.notifyDataSetChanged();
            	}
            }
        }, 2000);
    }
    
    public void filter(String edittext,String thanhpho ) {
    	edittext = removeAccent(edittext.toLowerCase()).replace("đ", "d");
    	thanhpho = removeAccent(thanhpho.toLowerCase()).replace("đ", "d");
    	
    	
		dataluu1.clear();
		if (edittext.length() == 0 && thanhpho.length()==0 ) {
			dataluu1.addAll(datalist);
		} 
		else 
		{
			for (foody wp : datalist) 
			{
				if (removeAccent(wp.getTieude().toLowerCase()).replace("đ", "d").contains(edittext) && removeAccent(wp.getThanhpho().toLowerCase()).replace("đ", "d").contains(thanhpho)) 
				{
					dataluu1.add(wp);
					continue;
				}
				if (removeAccent(wp.getDiachi().toLowerCase()).replace("đ", "d").contains(edittext) && removeAccent(wp.getThanhpho().toLowerCase()).replace("đ", "d").contains(thanhpho)) 
				{
					dataluu1.add(wp);
					continue;
				}
				if (removeAccent(wp.getMenu().toLowerCase()).replace("đ", "d").contains(edittext) && removeAccent(wp.getThanhpho().toLowerCase()).replace("đ", "d").contains(thanhpho)) 
				{
					dataluu1.add(wp);
					continue;
				}
				
			}
		}
	
		adt1.notifyDataSetChanged();
	
	}
    
    
    @SuppressLint("NewApi")
	public static String removeAccent(String s) 
	{
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("");
		
	}
    
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		foody getdata=adt1.getItem(position);
		FragmentManager	fm=getFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		Tab5v2 ff=new Tab5v2();
		Bundle b=new Bundle();
		b.putSerializable("item",getdata);
		ff.setArguments(b);	
		ft.replace(R.id.frg2_0, ff); ////R.id.frame1_1 chi thay doi 1 cai id frame duy nhat
		ft.addToBackStack("3");
		ft.commit(); 
		
	}
}