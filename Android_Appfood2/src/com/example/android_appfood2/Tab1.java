package com.example.android_appfood2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import android.support.v7.widget.LinearLayoutManager;

import android.widget.SearchView;

import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




import android.support.annotation.Nullable;
/**
 * Created by Edwin on 15/02/2015.
 */
public class Tab1 extends Fragment  {
	RecyclerView rc;
	Myadapter ma;
	List<foody> phim;
	List<foodybinhluan> foodybladd;
	Bitmap myBitmap;
	EditText ed;
	String query="";
	Button bt;
	SearchView search;
	int pause=0,thanhphopause=0;
	 int menuseach=0,seach=0;
	int vitri=0;
	int menuadd=0;
	int thanhphoadd=0;
	 Spinner s,s1;
	 List<String> menu;
	 List<String> thanhpho;
	 String stringmenu="";
	 String stringthanhpho="";
	 ArrayAdapter<String> dataAdapter,dataAdapter1;
	 DatabaseHandler db;
	 static Bitmap hinhanh123;
	 TextView tv;
	    // Connection detector class
	 ConnectionDetector cd;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v("frag1", "onCreate :"+savedInstanceState);
		super.onCreate(savedInstanceState);
	
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.v("frag1", "onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		Log.v("frag1", "onDestroyView");
		super.onDestroyView();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		Log.v("frag1", "onDetach");
		super.onDetach();
	}






	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		Log.v("frag1", "onResume");
		
		super.onResume();
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Log.v("frag1", "onStart  ");
		
		super.onStart();
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		Log.v("frag1", "onStop aaa");
		super.onStop();
	}
	
	
	
	
	@Override
	public void onPause() {
		// TODO Auto-generated method stub		
		pause=1;
		menuseach=1;
		thanhphopause=1;
		Log.v("frag1", "onPause :"+menuseach);
		super.onPause();
	}
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_1,container,false);
     //   ed=(EditText)v.findViewById(R.id.editText1);
   //   bt=(Button)v.findViewById(R.id.button1);
       
 /*       search=(SearchView) v.findViewById(R.id.searchView1);
        search.setQueryHint("Search"); */
         db = new DatabaseHandler(getActivity());
        
        s  = (Spinner) v.findViewById(R.id.spinner1);
        s1 = (Spinner) v.findViewById(R.id.spinner2);
        tv=(TextView) v.findViewById(R.id.textView1);
      
	//	rc=(RecyclerView)v.findViewById(R.id.recycler); 
        
	//	LinearLayoutManager l=new LinearLayoutManager(getActivity());
	//	l.setOrientation(LinearLayoutManager.VERTICAL);
	//	rc.setLayoutManager(l);		
	//	ma=new Myadapter(this, phim);
		
		
		
		
//		rc.setAdapter(ma);
//		rc.setHasFixedSize(true);
		
//		rc.setItemAnimator(new DefaultItemAnimator());
        
        
        
        return v;
    }
  
 
    
  
    private List<foody> filterfull(List<foody> models, String menu123,String thanhpho123) {
    	menu123 = menu123.toLowerCase();
    	thanhpho123=thanhpho123.toLowerCase();
        final List<foody> filteredModelList = new ArrayList<>();
        for (foody model : models) {
            final String text = model.getThanhpho().toLowerCase();
            final String text1 = model.getMenu().toLowerCase();
            if (text.contains(thanhpho123) && text1.contains(menu123)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
    
    
    public int vitriscroll(int pos){
    	vitri=pos;
    	return vitri;
    }
    @Override  
    public void onActivityCreated(Bundle savedInstanceState) {  
        super.onActivityCreated(savedInstanceState); 
        cd = new ConnectionDetector(getActivity());
        
      
        if (cd.isConnectingToInternet()) {
            // Internet Connection is Present
            // make HTTP requests
           tv.setVisibility(View.GONE);
        } else {
            // Internet connection is not present
            // Ask user to connect to Internet
        	 tv.setVisibility(View.VISIBLE);
        }
        rc = (RecyclerView) getView().findViewById(R.id.recycler);  
        if (pause!=1){
        	
        	 menu  =new ArrayList<String>();
             menu.add("Menu");
             thanhpho  =new ArrayList<String>();
             thanhpho.add("Thành Phố");
        phim=new ArrayList<foody>(); 
        foodybladd=new ArrayList<foodybinhluan>();
   	 menu menu = new menu();
	 menu.execute("http://ddl-mediafire.com/Spam/jsonmenu.php");
	 thanhpho thanhpho = new thanhpho();
	 thanhpho.execute("http://ddl-mediafire.com/Spam/jsonthanhpho.php");
        ImageLoadTask myasynctask1 = new ImageLoadTask();
		 myasynctask1.execute("http://ddl-mediafire.com/Spam/jsontest.php","http://ddl-mediafire.com/Spam/jsonbinhluan.php");	
        }
        dataAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_item, menu);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);
     
        dataAdapter1 = new ArrayAdapter<String>(getActivity(),
            R.layout.spinner_item, thanhpho);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(dataAdapter1);
        
        rc.setHasFixedSize(true);  
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());  
        llm.setOrientation(LinearLayoutManager.VERTICAL);  
        rc.setLayoutManager(llm); 
        ma = new Myadapter(this,phim);
        rc.setAdapter(ma);
     //   rc.scrollToPosition(vitri);
        
        if (pause==1){
        	
			final List<foody> filteredModelList = filterfull(phim,stringmenu,stringthanhpho);
	        ma.removemenu(filteredModelList);
	     //   ma.notifyDataSetChanged();
	 //       rc.scrollToPosition(0);	
        }
        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
   			
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {				 
				// TODO Auto-generated method stub
				if (position==0){
			
					stringthanhpho="";
				}else {	
				stringthanhpho=dataAdapter1.getItem(position);
				}
				
				ma.addmenu();
				final List<foody> filteredModelList = filterfull(phim,stringmenu,stringthanhpho);
		        ma.removemenu(filteredModelList);
		    //    ma.notifyDataSetChanged();
	//	        rc.scrollToPosition(0);	
			/*	final int a2=thanhphopause;
				thanhphoadd=menuadd+1;
				Log.v("a2", ""+a2);
				if (position==0) {										
					Log.v("a", ""+a2);
					Log.v("a5", "ssss");
					ma.addthanhpho();				
	    			final List<foody> filteredModelList = filterthanhpho(phim, "");
			        ma.removethanhpho(filteredModelList);
			    //    ma.notifyDataSetChanged();
			        rc.scrollToPosition(0);		       	
				} else {	
					if (a2==0){											
					Log.v("a2", ""+a2);
					String stv=dataAdapter1.getItem(position);
					Log.v("a4", ""+stv);
						ma.addthanhpho();
		    			final List<foody> filteredModelList = filterthanhpho(phim, stv);
				        ma.removethanhpho(filteredModelList);
				    //    ma.notifyDataSetChanged();
				        rc.scrollToPosition(0);		
					}else {
						thanhphopause=thanhphopause-1;
					
					}
				}*/
				
				
			} 

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
       s.setOnItemSelectedListener(new OnItemSelectedListener() {
    	   			
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				if (position==0){
					stringmenu="";
				}else {
				stringmenu=dataAdapter.getItem(position);
				}
				
				ma.addmenu();
				final List<foody> filteredModelList = filterfull(phim,stringmenu,stringthanhpho);
		        ma.removemenu(filteredModelList);
		    //    ma.notifyDataSetChanged();
		//        rc.scrollToPosition(0);	
			/*	final int a=pause;
				menuadd=thanhphoadd+1;
				Log.v("a2", ""+a);
				if (position==0) {
					
					Log.v("a", ""+a);
					Log.v("a5", "ssss");
					
				
					ma.addmenu();				
	    			final List<foody> filteredModelList = filtermenu(phim, "");
			        ma.removemenu(filteredModelList);
			    //    ma.notifyDataSetChanged();
			        rc.scrollToPosition(0);		       	
				} else {	
					if (a==0){
					Log.v("a1", ""+a);
					String stv=dataAdapter.getItem(position);
					Log.v("a4", ""+stv);
					
						ma.addmenu();
		    			final List<foody> filteredModelList = filtermenu(phim, stv);
				        ma.removemenu(filteredModelList);
				    //    ma.notifyDataSetChanged();
				        rc.scrollToPosition(0);		
					}else {
						pause=pause-1;
					
					}
				} */
				
				
			} 

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        
    /*   bt.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			ma.addmenu();
			final List<foody> filteredModelList = filterfull(phim,stringmenu,stringthanhpho);
	        ma.removemenu(filteredModelList);
	    //    ma.notifyDataSetChanged();
	        rc.scrollToPosition(0);	
		}
	}); */
       
       
  /*      
        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
    		
    		@Override
    		public void onFocusChange(View v, boolean hasFocus) {
    			// TODO Auto-generated method stub
    				
    			//Toast.makeText(getContext(), String.valueOf(hasFocus),Toast.LENGTH_SHORT).show();
    				
    		}
    	});
            
            //*** setOnQueryTextListener ***
            search.setOnQueryTextListener(new OnQueryTextListener() {
    			
    		@Override
    		public boolean onQueryTextSubmit(String query) {
    			// TODO Auto-generated method stub
    			Toast.makeText(getContext(),"Our word : "+query,Toast.LENGTH_SHORT).show();
    		//	Toast.makeText(getContext(), query+"1", Toast.LENGTH_LONG).show();
    				
    			
    			return false;
    		}
    		
    		@Override
    		public boolean onQueryTextChange(String newText) {
    			// TODO Auto-generated method stub
    			final int a1=menuseach;
    		if(newText.length()<=0){
    			s.setEnabled(true);
    			s1.setEnabled(true);
    		}else {
    			s.setEnabled(false);
    			s1.setEnabled(false);
    		}
    		if (a1!=1){
    			ma.applyAndAnimateAdditions();	
    			final List<foody> filteredModelList = filter(phim, newText);
		        ma.applyAndAnimateRemovals(filteredModelList);
		    //    ma.notifyDataSetChanged();
		        rc.scrollToPosition(0);
    		} else {
    			menuseach=0;
    		}
    			
    			
		       Toast.makeText(getContext(), newText, Toast.LENGTH_LONG).show();
    			return false;
    		}
    	});
           
        */
        
     /*   bt.setOnClickListener(new OnClickListener() {		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				query=ed.getText().toString().toLowerCase();
				ma.applyAndAnimateAdditions();	
					final List<phim> filteredModelList = filter(phim, query);
			        ma.applyAndAnimateRemovals(filteredModelList);
			        rc.scrollToPosition(0);
				Toast.makeText(getContext(), query, Toast.LENGTH_LONG).show();
				
			}
		}); */
        
      
     /*   SwipeableRecyclerViewTouchListener swipeTouchListener =
	            new SwipeableRecyclerViewTouchListener(rc,
	                    new SwipeableRecyclerViewTouchListener.SwipeListener() {
	                        @Override
	                        public boolean canSwipe(int position) {
	                            return true;
	                        }

	                        @Override
	                        public void onDismissedBySwipeLeft(RecyclerView recyclerView, int[] reverseSortedPositions) {
	                        	
	                            for (int position : reverseSortedPositions) {
	                            	//open();
	                                phim posremove=phim.remove(position);
	                               // remove.add(posremove);
	                                ma.notifyItemRemoved(position);
	                            }
	                            ma.notifyDataSetChanged();
	                        }

	                        @Override
	                        public void onDismissedBySwipeRight(RecyclerView recyclerView, int[] reverseSortedPositions) {
	                            for (int position : reverseSortedPositions) {
	                            	  phim posremove=phim.remove(position);
		                               // remove.add(posremove);
		                                ma.notifyItemRemoved(position);
	                            }
	                            ma.notifyDataSetChanged();
	                        }
	                    });

	    rc.addOnItemTouchListener(swipeTouchListener); */
       
    }
    
    
	public class ImageLoadTask extends AsyncTask<String, String, Bitmap> {

	    
	    ProgressDialog dialog;
	  
	    public ImageLoadTask() {
	        dialog=new ProgressDialog(getContext());
		    dialog.setTitle("Đang tải thông tin ...");
		    dialog.setMessage("Vui lòng chờ...");
		    dialog.setCancelable(false);
		   
	    }
	    protected void onPreExecute() {
	    	super.onPreExecute();
	    	this.dialog.show();
	    	}

	    @Override
	    protected Bitmap doInBackground(String... url) {
	    	
	    
	    	
	    	  String chuoi1=GetStringFromURL(url[0]);
	    	  String chuoi2=GetStringFromURL(url[1]);

	 		 try {
	 			 
	 			 
	 				JSONObject jsonRootObject = new JSONObject(chuoi1);
	 				JSONObject jsonRootObject2 = new JSONObject(chuoi2);
	 				JSONArray jsonArray = jsonRootObject.optJSONArray("fullinfo");
	 				JSONArray jsonArray2 = jsonRootObject2.optJSONArray("binhluan");
	 				
	 				for(int i= jsonArray2.length()-1;i>=0;i--){
	 				 	JSONObject jsonObject2 = jsonArray2.getJSONObject(i);	 
				        	int idbl = jsonObject2.optInt("id");
				        	int idthongtin = jsonObject2.optInt("idthongtin");
				        	int iduser = jsonObject2.optInt("iduser");
				        	 String  username = jsonObject2.optString("username");
				        	String  binhluan = jsonObject2.optString("binhluan");
				        	 String  blhinhanh = jsonObject2.optString("hinhanh");
				        	 foodybinhluan foodybl=new foodybinhluan();
				        	foodybl.setId(idbl);
				        	foodybl.setIdthongtin(idthongtin);
				        	foodybl.setIduser(iduser);
				        	foodybl.setUsername(username);
				        	foodybl.setBinhluan(binhluan);
				        	foodybl.setHinhanh(blhinhanh);
				        	foodybladd.add(foodybl);
	 				}
	 				
	 				Tab2_1 ff1=new Tab2_1();
	 				ff1.binhluangiamgia(foodybladd);
	 				
	 				
	 				for(int i = jsonArray.length()-1; i >=0; i--) {
	 					int dem=0;
	 					int intanh=0;
	 					
	 					  JSONObject jsonObject = jsonArray.getJSONObject(i);//lấy từng đối tượng ra
	 					                int id = jsonObject.optInt("id");//
	 					                String tieude = jsonObject.optString("tieude").toString();
	 					                String des = jsonObject.optString("des").toString();
	 					             //  Bitmap hinhanh = chuyendoibitmap(jsonObject.optString("hinhanh"));
	 					             String  hinhanh = jsonObject.optString("hinhanh");
	 					              String thanhpho = jsonObject.optString("thanhpho").toString();
	 					             String menu = jsonObject.optString("menu").toString();
	 					            String diadiem = jsonObject.optString("diadiem").toString();
	 					           String sdt = jsonObject.optString("sdt").toString();
	 					           float rate=jsonObject.optInt("rate");
	 					          String gia = jsonObject.optString("gia").toString();
	 					         String diachi = jsonObject.optString("diachi").toString();
	 					        int giamgia = jsonObject.optInt("giamgia");
	 					        double latitude=jsonObject.optDouble("latitude");
	 					       double longitude=jsonObject.optDouble("longitude");
	 					         foody customphim=new foody();
	 					         for (int j=0;j<jsonArray2.length();j++){
	 					        	JSONObject jsonObject2 = jsonArray2.getJSONObject(j);	 
	 					        	int idthongtin = jsonObject2.optInt("idthongtin");
	 					        	String  blhinhanh = jsonObject2.optString("hinhanh");
	 					        	 if (id==idthongtin){	 					        		 
	 					        		 dem=dem+1;
	 					        		String[] demanh=blhinhanh.split("\\|");	 					        		
	 					        		intanh=intanh+demanh.length;	 					        		
	 					        	 }
	 					        	 
	 					         }
	 					         
	 					         
	 					         
	 					        customphim.setLatitude(latitude);
	 					       customphim.setLongitude(longitude);
	 					        customphim.setDemhinhanh(Integer.toString(intanh));
	 					        customphim.setDembinhluan(Integer.toString(dem));
	 					        customphim.setGiamgia(giamgia);
	 					        customphim.setGia(gia);
	 					         customphim.setId(id);
	 					        customphim.setTieude(tieude);
	 					       customphim.setDes(des);
	 					      customphim.setDiachi(diachi);;
	 					      customphim.setTesthinhanh(hinhanh);
	 					     customphim.setThanhpho(thanhpho);
	 					    customphim.setMenu(menu);
	 					   customphim.setDiadiem(diadiem);
	 					  customphim.setSdt(sdt);
	 					 customphim.setRate(rate);
	 					 
	 					 if (giamgia>0){
	 						Tab2_1 ff=new Tab2_1();
	 						ff.nhandulieu(customphim);
	 					 }
	 					 
	 					 
	 					 phim.add(customphim);
	 					  
	 					 }
	 						         
	 			} catch (JSONException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	    	
	        return null;
	    }
	    @Override
	    protected void onPostExecute(Bitmap result) {
	        super.onPostExecute(result);
	        ma.notifyDataSetChanged();
	        this.dialog.dismiss();
	        
	    }

}
	
	
public class menu extends AsyncTask<String, String, Bitmap> {

	    
	    ProgressDialog dialog;
	  
	    public menu() {
	        dialog=new ProgressDialog(getContext());
		    dialog.setTitle("Đang tải thông tin ...");
		    dialog.setMessage("Vui lòng chờ...");
		    dialog.setCancelable(false);
		   
	    }
	    protected void onPreExecute() {
	    	super.onPreExecute();
	    	this.dialog.show();
	    	}

	    @Override
	    protected Bitmap doInBackground(String... url) {
	    	
	    
	    	
	    	  String chuoi1=GetStringFromURL(url[0]);

	 		 try {
	 				JSONObject jsonRootObject = new JSONObject(chuoi1);
	 				JSONArray jsonArray = jsonRootObject.optJSONArray("menu");
	 				for(int i = 0; i < jsonArray.length(); i++) {
	 					  JSONObject jsonObject = jsonArray.getJSONObject(i);//lấy từng đối tượng ra
	 					                int id = jsonObject.optInt("id");//
	 					                String ten = jsonObject.optString("ten").toString();
	 					               menu.add(ten);
	 					  
	 					 }
	 						         
	 			} catch (JSONException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	    	
	        return null;
	    }
	    @Override
	    protected void onPostExecute(Bitmap result) {
	        super.onPostExecute(result);
	        dataAdapter.notifyDataSetChanged();
	        postbai postmenu=new postbai();
	        postmenu.menu(menu);
	        this.dialog.dismiss();
	        
	    }

}
	
	
public class thanhpho extends AsyncTask<String, String, Bitmap> {

    
    ProgressDialog dialog;
  
    public thanhpho() {
        dialog=new ProgressDialog(getContext());
	    dialog.setTitle("Đang tải thông tin ...");
	    dialog.setMessage("Vui lòng chờ...");
	    dialog.setCancelable(false);
	   
    }
    protected void onPreExecute() {
    	super.onPreExecute();
    	this.dialog.show();
    	}

    @Override
    protected Bitmap doInBackground(String... url) {
    	
    
    	
    	  String chuoi1=GetStringFromURL(url[0]);

 		 try {
 				JSONObject jsonRootObject = new JSONObject(chuoi1);
 				JSONArray jsonArray = jsonRootObject.optJSONArray("chontinh");
 				for(int i = 0; i < jsonArray.length(); i++) {
 					  JSONObject jsonObject = jsonArray.getJSONObject(i);//lấy từng đối tượng ra
 					                int id = jsonObject.optInt("id");//
 					                String thanhpho1 = jsonObject.optString("thanhpho").toString();
 					                Tab2_1 tab2_1=new Tab2_1();
 					                tab2_1.menu(thanhpho1);
 					              
 					               thanhpho.add(thanhpho1);
 					  
 					 }
 						         
 			} catch (JSONException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
    	
        return null;
    }
    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);
        dataAdapter1.notifyDataSetChanged();
        postbai postthanhpho=new postbai();
        postthanhpho.thanhpho(thanhpho);
        this.dialog.dismiss();
        
    }

}
	
	
	public Bitmap chuyendoibitmap(String url){
		try {
            URL urlConnection = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlConnection
                    .openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            myBitmap = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return myBitmap;
	}
	
	
	public String GetStringFromURL(String url){
	     InputStream inputStream = null;
	     String result = "";
	     
	     try {
	         // create HttpClient
	         HttpClient httpclient = new DefaultHttpClient();       
	         // make GET request to the given URL
	         HttpResponse httpResponse = httpclient.execute(new HttpGet(url));    
	         // receive response as inputStream
	         inputStream = httpResponse.getEntity().getContent();   
	         // convert inputstream to string
	         if(inputStream != null) {
	              result = convertInputStreamToString(inputStream);
	             
	         } else {
	              result = "Did not work!";
	         }
	      } catch (Exception e) {
	          Log.d("InputStream", e.getLocalizedMessage());
	      }
	      
	 
	    return result;
	}
	   
	private String convertInputStreamToString(InputStream inputStream){
	     BufferedReader bufferedReader = 
	              new BufferedReader( new InputStreamReader(inputStream));
	     String line = "", result = "";
	    
	     try {
	          while((line = bufferedReader.readLine()) != null) {
	                result += line;
	          }
	                 
	         inputStream.close();
	     } catch (IOException e) {
	         e.printStackTrace();
	     }       
	     return result;
	 }
    
    
    public void remove(int pos) {
		// TODO Auto-generated method stub
    	  foody posremove=phim.remove(pos);
          // remove.add(posremove);
           ma.notifyItemRemoved(pos);
		
	}
    
    public void luu(int pos) {
		// TODO Auto-generated method stub
    	if (phim.get(pos).getSele()){
    		Log.v("2", ""+phim.get(pos).getSele());	
    	Tab4 ff=new Tab4();
		ff.nhandulieu(phim.get(pos));
    	}
		
	}
    
    public void infofull(View v,int pos){
    	Log.v("info", ""+pos);
    	List<foodybinhluan> getaddbl=new ArrayList<foodybinhluan>();
    	for (int i=0;i<foodybladd.size();i++){
    		if (phim.get(pos).getId()==foodybladd.get(i).getIdthongtin()){
    			getaddbl.add(foodybladd.get(i));
    		}
    	}
    	
    	
		FragmentManager	fm=getFragmentManager();
		FragmentTransaction ft=fm.beginTransaction();
		Tab5 ff=new Tab5();
		Bundle b=new Bundle();
		b.putSerializable("item",phim.get(pos));
		ff.nhandulieu(getaddbl);
		// nếu để add trước khi chuyển qua vitris pos bi thay doi
		/*ma.applyAndAnimateAdditions();
		if(thanhphoadd>menuadd){
		ma.addthanhpho();
		ma.addmenu();
		}else {
			ma.addmenu();
			ma.addthanhpho();
			
		} */
		ma.addmenu();
		ff.setArguments(b);	
		ft.replace(R.id.frg1, ff); ////R.id.frame1_1 chi thay doi 1 cai id frame duy nhat
		ft.addToBackStack("1");	
		ft.commit(); 
    	
    	
    }
	
    public void binhluan(View v,int pos){
    	db =new DatabaseHandler(getActivity());
    	if(db.checkdangnhap()){
    		Intent ii=new Intent(getActivity(),binhluan.class);
        	Bundle bb=new Bundle();
        	bb.putSerializable("binhluan", phim.get(pos));
        	ii.putExtras(bb);
        	startActivity(ii);
    	}else {
    		Toast.makeText(getContext(), "Bạn chưa đăng nhập ", Toast.LENGTH_SHORT).show();
    	}
    	
    	
    /*	Intent ii=new Intent(getActivity(),dangnhap.class);
    	Bundle bb=new Bundle();
    	bb.putSerializable("binhluan", phim.get(pos));
    	ii.putExtras(bb);
    	startActivity(ii); */
    }

    public void luusqli(int pos){
     if(!db.checkluu(phim.get(pos).getId())){
    	hinhanh123 = chuyendoibitmap(phim.get(pos).getTesthinhanh());
     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
     hinhanh123.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
     byte[] byteArray = byteArrayOutputStream .toByteArray();
     String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
        db.addContact(phim.get(pos),encoded);
        Toast.makeText(getContext(), "Đã Lưu !!", Toast.LENGTH_SHORT).show();
     }else {
    	 Toast.makeText(getContext(), "Bạn đã lưu", Toast.LENGTH_SHORT).show();
     }
    }


	

	
	
}
