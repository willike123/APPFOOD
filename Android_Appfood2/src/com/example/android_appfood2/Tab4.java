package com.example.android_appfood2;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Tab4 extends Fragment implements OnItemClickListener, OnRefreshListener {
	static List<foody> dataluu;
	static myadaptercustom adt;
	 SwipeRefreshLayout swipeLayout;
	foody goi;
	int pause=0;
	 ListView lv;
	static TextView tv;
	static DatabaseHandler db ;
		@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v("frag2", "onCreate :"+savedInstanceState);
		super.onCreate(savedInstanceState);
	
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.v("frag2", "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		Log.v("frag2", "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		Log.v("frag2", "onDetach");
		super.onDetach();
	}





@Override
public void onPause() {
	// TODO Auto-generated method stub
	Log.v("frag2", "onPause");
	pause=1;
	

	super.onPause(); 
}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		Log.v("frag2", "onResume");
		
		super.onResume();
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Log.v("frag2", "onStart  ");
		
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		Log.v("frag2", "onStop aaa");
		super.onStop();
	}
	
	public void nhandulieu(foody a) {
		
		
			if (!dataluu.contains(a)){
			//	dataluu.add(a);
			}
		
	//	i=10;
	//	Log.v("3", ""+i);
		}
	
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_4,container,false);
        Log.v("tab4", " "+container);
        tv=(TextView)v.findViewById(R.id.textView1);
        if (pause==1){
        	tv.setVisibility(View.GONE);
        }
           db = new DatabaseHandler(getActivity());
         dataluu = db.getAllContacts();
     
        swipeLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(this);
        swipeLayout.setColorScheme(android.R.color.holo_blue_bright, 
                android.R.color.holo_green_light, 
                android.R.color.holo_orange_light, 
                android.R.color.holo_red_light);
    //   Button bt=(Button) v.findViewById(R.id.button1);
  	  lv=(ListView)v.findViewById(R.id.listView1);
  	 adt=new myadaptercustom(getContext(), R.layout.tab_4, dataluu);
  	lv.setAdapter(adt);
	lv.setOnItemClickListener(this);
      
        return v;
    }
   

	@Override 
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {   	
                swipeLayout.setRefreshing(false);
                
            //     db = new DatabaseHandler(getContext());
            	dataluu = db.getAllContacts();	
                if (dataluu.isEmpty()){
            		tv.setText("Data lưu đã hết vui lòng lưu và kéo lại");
            		tv.setVisibility(View.VISIBLE);
            	}else {
            	
            	Log.v("1111", Integer.toString(dataluu.size()));
                tv.setVisibility(View.GONE);
                adt=new myadaptercustom(getContext(), R.layout.tab_4, dataluu);
            	lv.setAdapter(adt);
            	}
            }
        }, 2000);
    }
    
    public void removelist(int pos){
    //	   db = new DatabaseHandler(getContext());
    	  
    	  Log.v("remove", ""+dataluu.get(pos).getId());
    	  db.removeluu(dataluu.get(pos).getId());
    	dataluu.remove(pos);
    	if (dataluu.isEmpty()){
    		tv.setText("Bạn đã xóa hết data");
    		tv.setVisibility(View.VISIBLE);
    	}
    	adt.notifyDataSetChanged();
    	
    }
    
       	
    
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		foody getdata=adt.getItem(position);
		FragmentManager	fm=getFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		Tab5v1 ff=new Tab5v1();
		Bundle b=new Bundle();
		b.putSerializable("item",getdata);
		ff.setArguments(b);	
		ft.replace(R.id.frg4, ff); ////R.id.frame1_1 chi thay doi 1 cai id frame duy nhat
		ft.addToBackStack("3");
		ft.commit(); 
		
	}
}