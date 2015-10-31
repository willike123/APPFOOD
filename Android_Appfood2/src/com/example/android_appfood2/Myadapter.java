package com.example.android_appfood2;

import java.util.ArrayList;
import java.util.List;

import com.squareup.picasso.Picasso;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Myadapter  extends RecyclerView.Adapter<Myadapter.myholder> {
  List<foody> phim;
  List<foody> listremove=new ArrayList<foody>();
  List<foody> menuremove=new ArrayList<foody>();
  List<foody> thanhphoremove=new ArrayList<foody>();
  ArrayList<String> add=new ArrayList<String>();
  ArrayList<String> addmenu=new ArrayList<String>();
  ArrayList<String> addthanhpho=new ArrayList<String>();
  Tab1 rc;
 
   Myadapter(Tab1 aa,List<foody> bb){
	   phim=bb;
	   rc=aa;
	 //  this.mcontext=context;
	  
   }
   
   public class myholder extends RecyclerView.ViewHolder {
	  Button rate;
	  TextView tieude,diachi,binhluan,dembinhluan,demhinhanh;
	  ImageView hinhanh,hinhanh1;
	
	public myholder(View arg0){
		super(arg0);
		rate=(Button)arg0.findViewById(R.id.rate);
		//luuid=(CheckBox)arg0.findViewById(R.id.checkbox10);
		tieude=(TextView)arg0.findViewById(R.id.tieude);		
		diachi=(TextView)arg0.findViewById(R.id.diachi);
		binhluan=(TextView)arg0.findViewById(R.id.binhluan);
		dembinhluan=(TextView)arg0.findViewById(R.id.dembinhluan);
		demhinhanh=(TextView)arg0.findViewById(R.id.demanh);
		hinhanh=(ImageView)arg0.findViewById(R.id.hinhanh);
		hinhanh1=(ImageView)arg0.findViewById(R.id.imageView2);
	
		
		
		/*luu.setOnClickListener(new View.OnClickListener() {
			   public void onClick(View v) {
			    CheckBox cb = (CheckBox) v;
		 //   foody contact = (foody) cb.getTag();

		//	   contact.setSele(cb.isChecked());
			    phim.get(getPosition()).setSele(cb.isChecked());
			    rc.luusqli(getPosition());
			    Toast.makeText(
			      v.getContext(),
			      "Clicked on Checkbox: " + getPosition() +" "+phim.get(getPosition()).getSele() + " is "
			        + cb.isChecked(), Toast.LENGTH_LONG).show();
			   }
			  });*/
		
		
		
		hinhanh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rc.infofull(v,getPosition());
			//	rc.vitriscroll(getPosition());
			}
		});
		
		tieude.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rc.infofull(v,getPosition());
			}
		});
	
	}
	
	

	
}
   
  
   
  /* public  void applyAndAnimateRemovals(List<foody> newModels) {
	   listremove=new ArrayList<foody>();
	   add=new ArrayList<String>();
	    for (int i = phim.size() - 1; i >= 0; i--) {
	         foody model = phim.get(i);
	        if (!newModels.contains(model)) {
	            removeItem(i);
	            listremove.add(model);
	            add.add(Integer.toString(i));
	        }
	    }
	}

   public void applyAndAnimateAdditions() {
	
	   if (!listremove.isEmpty()){
		   Log.v("2", add.size()+" "+listremove.size());
	   for (int i=listremove.size()-1;i>=0;i--){
		   phim.add(Integer.parseInt(add.get(i)),listremove.get(i));
		   notifyItemInserted(Integer.parseInt(add.get(i)));
	   }
	   }
   }
	   */
	   
   
   public  void removemenu(List<foody> newModels) {
	   menuremove=new ArrayList<foody>();
	   addmenu=new ArrayList<String>();
	    for (int i = phim.size() - 1; i >= 0; i--) {
	         foody model = phim.get(i);
	        if (!newModels.contains(model)) {
	            removeItem(i);
	            menuremove.add(model);
	            addmenu.add(Integer.toString(i));
	        }
	    }
	}

   public void addmenu() {
	
	   if (!menuremove.isEmpty()){
		   Log.v("3", addmenu.size()+" "+menuremove.size());
	   for (int i=menuremove.size()-1;i>=0;i--){
		   phim.add(Integer.parseInt(addmenu.get(i)),menuremove.get(i));
		   notifyItemInserted(Integer.parseInt(addmenu.get(i)));
	   }
	   }
   }
   
   
   
 /*  public  void removethanhpho(List<foody> newModels) {
	   thanhphoremove=new ArrayList<foody>();
	   addthanhpho=new ArrayList<String>();
	    for (int i = phim.size() - 1; i >= 0; i--) {
	         foody model = phim.get(i);
	        if (!newModels.contains(model)) {
	            removeItem(i);
	            thanhphoremove.add(model);
	            addthanhpho.add(Integer.toString(i));
	        }
	    }
	}

   public void addthanhpho() {
	
	   if (!thanhphoremove.isEmpty()){
		   Log.v("4", addthanhpho.size()+" "+thanhphoremove.size());
	   for (int i=thanhphoremove.size()-1;i>=0;i--){
		   phim.add(Integer.parseInt(addthanhpho.get(i)),thanhphoremove.get(i));
		   notifyItemInserted(Integer.parseInt(addthanhpho.get(i)));
	   }
	   }
   }
   
	   
	   
	 if (!newModels.isEmpty()){
	    for (int i = 0; i < listremove.size(); i++) {
	        final phim model = listremove.get(i);
	        Log.v("3", i+" "+model);
	        if (!newModels.contains(model)) {
	        	  phim.add(i, model);
	        	  Log.v("1", i+" "+model);
	        }
	    }
	   }*/
	

   
   
   
   
   
   
 /*  public void applyAndAnimateMovedItems(List<foody> newModels) {
	    for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
	        final foody model = newModels.get(toPosition);
	        final int fromPosition = phim.indexOf(model);
	        if (fromPosition >= 0 && fromPosition != toPosition) {
	            moveItem(fromPosition, toPosition);
	        }
	    }
	} */
	public void removeItem(int position) {
	    phim.remove(position);
	    notifyItemRemoved(position);
	    
	}

	

/*	public void moveItem(int fromPosition, int toPosition) {
	    final foody model = phim.remove(fromPosition);
	    phim.add(toPosition, model);
	    notifyItemMoved(fromPosition, toPosition);
	} */
@Override
public int getItemCount() {
	// TODO Auto-generated method stub
	return phim.size();
}

@Override
public void onBindViewHolder(myholder arg0, int arg1) {
	 final int pos = arg1;
	 final foody objIncome = phim.get(arg1);
	// TODO Auto-generated method stub
	arg0.rate.setText(Float.toString(phim.get(arg1).getRate()));
	arg0.tieude.setText(phim.get(arg1).getTieude());
	arg0.diachi.setText(phim.get(arg1).getDiachi());
	arg0.dembinhluan.setText(phim.get(arg1).getDembinhluan());
	arg0.demhinhanh.setText(phim.get(arg1).getDemhinhanh());
	Picasso.with(rc.getContext()).load(phim.get(arg1).getTesthinhanh().replace(" ", "%20")).resize(310, 156).into(arg0.hinhanh);
	//arg0.luu.setChecked(phim.get(arg1).getSele());
	

 arg0.hinhanh1.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 
		 rc.luusqli(pos);
		
	}
});

	arg0.binhluan.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			rc.binhluan(v, pos);
			
			
		}
	}); 
	
	
	//arg0.hinhanh.setImageBitmap(phim.get(arg1).getHinhanh());
/*	arg0.luuid.setTag(phim.get(arg1));
	
arg0.luuid.setTag(phim.get(arg1));
	 arg0.luuid.setOnClickListener(new View.OnClickListener() {
		   public void onClick(View v) {
		    CheckBox cb = (CheckBox) v;
		    foody contact = (foody) cb.getTag();
		    contact.setSele(cb.isChecked());
		    phim.get(pos).setSele(cb.isChecked());
		    rc.luusqli(pos);
		   
		    Toast.makeText(
		      v.getContext(),
		      "Clicked on Checkbox: " + cb.getText() + " is "
		        + cb.isChecked(), Toast.LENGTH_LONG).show();
		   }
		  });  */
}

@Override
public myholder onCreateViewHolder(ViewGroup arg0, int arg1) {
	// TODO Auto-generated method stub
	LayoutInflater lf=LayoutInflater.from(arg0.getContext());
	View v=lf.inflate(R.layout.listrow,arg0,false);
//	/v.setOnClickListener(MainActivity.listen);
	myholder m=new myholder(v);
	return m;
}







}