package com.example.android_appfood2;

import java.util.ArrayList;
import java.util.List;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class postbai extends Activity{

	EditText ed,ed1,ed2,ed3,ed4,ed5;
	Spinner sp1,sp2;
	ImageView img;
	Button bt1,bt2,bt3;
	JSONParser json=new JSONParser();
	String menu1,thanhpho1;
	ArrayAdapter<String> dataAdapter,dataAdapter1;
	ArrayList<String> anh=new ArrayList<String>();
	static List<String> menu=new ArrayList<String>();
	static List<String> thanhpho=new ArrayList<String>();
	 private DisplayImageOptions options;
		protected ImageLoader imageLoader;
		

		public void menu(List<String> menu2){
			this.menu=menu2;
		}
		public void thanhpho(List<String> thanhpho){
			this.thanhpho=thanhpho;
		}
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postbai);
		   imageLoader = ImageLoader.getInstance();
					imageLoader.init(ImageLoaderConfiguration.createDefault(this));
		ed=(EditText)findViewById(R.id.editText1);	
		ed1=(EditText)findViewById(R.id.editText2);
		ed2=(EditText)findViewById(R.id.editText3);
		ed3=(EditText)findViewById(R.id.editText4);
		ed4=(EditText)findViewById(R.id.editText5);
		ed5=(EditText)findViewById(R.id.editText6);
		sp1=(Spinner)findViewById(R.id.spinner1);
		sp2=(Spinner)findViewById(R.id.spinner2);
		img=(ImageView)findViewById(R.id.imageView1);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		bt3=(Button)findViewById(R.id.button3);
		 options = new DisplayImageOptions.Builder()
	    			.showStubImage(R.drawable.stub_image)
	    			.showImageForEmptyUri(R.drawable.image_for_empty_url)
	    			.cacheInMemory()
	    			.cacheOnDisc()
	    			.build();
		 
		 dataAdapter = new ArrayAdapter<String>(this,
	                android.R.layout.simple_spinner_item, menu);
	        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp1.setAdapter(dataAdapter);
	        dataAdapter1 = new ArrayAdapter<String>(this,
	                android.R.layout.simple_spinner_item, thanhpho);
	        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        sp2.setAdapter(dataAdapter1);
		 
	     sp1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				if (position==0){
					menu1="";
				}else {
				menu1=dataAdapter.getItem(position);
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});   
	     
	     
	     sp2.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					// TODO Auto-generated method stub
					if (position==0){
						thanhpho1="";
					}else {
					thanhpho1=dataAdapter1.getItem(position);
					}
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}
			});   
	        
		 bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (anh.isEmpty()){
					  Toast.makeText(getApplication(), "Vui lòng chọn ảnh !!!!", Toast.LENGTH_SHORT).show();
				} else {				
				// TODO Auto-generated method stub
				  final ProgressDialog progressDialog = ProgressDialog.show(postbai.this, "", "Đang update.....", false);
	                Thread thread=new Thread(new Runnable(){
	                       public void run(){
	                    	   Log.v("tieude", ed1.getText().toString().trim());
                               Log.v("mota", ed.getText().toString().trim());
	                    	   json.getJSONFromUrlpostbai("http://ddl-mediafire.com/Spam/upload2/postbai.php", ed1.getText().toString().trim(), ed.getText().toString().trim(),ed2.getText().toString().trim(),menu1,thanhpho1, ed3.getText().toString().trim(),ed4.getText().toString().trim(),ed5.getText().toString().trim(),anh.get(0).toString());
	                           runOnUiThread(new Runnable(){
	                               public void run() {
	                                   if(progressDialog.isShowing())	                                	  
	                                       progressDialog.dismiss();
	                                   Toast.makeText(getApplication(), "Đã Xong !!!!", Toast.LENGTH_SHORT).show();
	                                   finish();                               
	                                   }
	                           });
	                       }
	               });
	               thread.start();
			}
			}
		});
	        
	        
		bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		}); 
		 
		bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				inten();
			}		
		});
		
		
		
		
	}
	private void inten() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this,MultiPhotoSelectActivity.class);
        startActivityForResult(intent,100);
	}
	
	 public void onActivityResult(int requestCode, int resultCode, Intent data) {
		 
		    if (resultCode == RESULT_OK) {
		        //    Uri selectedImageUri = data.getData();
		            if (requestCode == 100)
		            {
		            	anh=data.getStringArrayListExtra("fileanh");
		            	if (!anh.isEmpty()){
		            		imageLoader.displayImage("file://"+anh.get(0), img, options, new SimpleImageLoadingListener() {
		    					@Override
		    					public void onLoadingComplete(Bitmap loadedImage) {
		    						Animation anim = AnimationUtils.loadAnimation(postbai.this, R.anim.fade_in);
		    						img.setAnimation(anim);
		    						anim.start();
		    					}
		    				});
		            	}
		            	
		            	Log.v("1", ""+anh);
		            	
		            //	imageAdapter.notifyDataSetChanged();
		            	
		//            	arrayfile=new ArrayList<File>();
		  //          	arrayFileBody=new ArrayList<FileBody>();
		            //    System.out.println("selectedPath1 : " + selectedPath1);
		            }
		           
		        } 
		    }
}
