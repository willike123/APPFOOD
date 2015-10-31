package com.example.android_appfood2;

import java.io.File;
import java.util.ArrayList;

import org.apache.http.entity.mime.content.FileBody;
import org.json.JSONObject;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

import android.R.integer;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class binhluan extends Activity {
	EditText tv1,tv2,tv3,tv4;
	TextView tv;
	Button bt1,bt2;
	ProgressDialog progressDialog;
	ArrayList<String> anh=new ArrayList<String>();
	GridView gr;
	String idthongtin;
	String iduser,name;
	String binhluan;
	String hinhanh;
	 foody data=new foody();
	
	  private DisplayImageOptions options;
	protected ImageLoader imageLoader;
	protected ImageAdapter imageAdapter;
	JSONParser json=new JSONParser();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.vietbinhluan);
		 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	     StrictMode.setThreadPolicy(policy);
	     imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(this));
		DatabaseHandler db = new DatabaseHandler(getApplicationContext());
		String[] dangnhap=db.getuser().split("\\|");
		Intent i=getIntent();
		Bundle b=i.getExtras();
		 data=(foody) b.getSerializable("binhluan");
		 iduser=dangnhap[0].toString().trim();
		name=dangnhap[1].toString().trim();
		 idthongtin = Integer.toString(data.getId()).toString().trim();
        
		
			
		 tv=(TextView)findViewById(R.id.textView1);
			
		// tv1=(EditText)findViewById(R.id.editText1);
	//	 tv2=(EditText)findViewById(R.id.editText2);
		 tv3=(EditText)findViewById(R.id.editText3);
		// tv4=(EditText)findViewById(R.id.editText4);
		 bt1=(Button)findViewById(R.id.button1);
		 bt2=(Button)findViewById(R.id.button2);
		// tv1.setText(Integer.toString(data.getId()));
		 tv.setText(data.getTieude());
		 gr=(GridView)findViewById(R.id.gridView1);
		 imageAdapter = new ImageAdapter(this, anh);
			
			
			gr.setAdapter(imageAdapter);
	        options = new DisplayImageOptions.Builder()
	    			.showStubImage(R.drawable.stub_image)
	    			.showImageForEmptyUri(R.drawable.image_for_empty_url)
	    			.cacheInMemory()
	    			.cacheOnDisc()
	    			.build();
		 bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 	
	             //    hinhanh = tv4.getText().toString().trim();
	            //    UserFunctions userFunction = new UserFunctions();
	            //    JSONObject json = userFunction.(idthongtin, iduser, binhluan, hinhanh);
	               
	                
				
				 binhluan = tv3.getText().toString().trim();
                
                progressDialog = ProgressDialog.show(binhluan.this, "", "Đang update.....", false);
                Thread thread=new Thread(new Runnable(){
                       public void run(){
                    	   json.getJSONFromUrlbinhluan("http://ddl-mediafire.com/Spam/upload2/upload_media_test.php", idthongtin, iduser,name, binhluan,anh);
                           runOnUiThread(new Runnable(){
                               public void run() {
                                   if(progressDialog.isShowing())
                                       progressDialog.dismiss();
                                   Toast.makeText(getApplication(), "Đã Xong !!!!", Toast.LENGTH_SHORT).show();
                                   SystemClock.sleep(2000);
                                   finish();                               }
                           });
                       }
               });
               thread.start();
                
                
                
                
	                Log.v("1", ""+json);
			}
		});
		 
		 
		 bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				inten();
			}
		});
		 
		
		 
	}
	
	
	
	
	
	 public void inten(){
		  Intent intent = new Intent(this,MultiPhotoSelectActivity.class);
	        startActivityForResult(intent,100);
	 }
	 
	 public void onActivityResult(int requestCode, int resultCode, Intent data) {
		 
		    if (resultCode == RESULT_OK) {
		        //    Uri selectedImageUri = data.getData();
		            if (requestCode == 100)
		            {
		            	anh=data.getStringArrayListExtra("fileanh");
		            	Log.v("1", ""+anh);
		            	imageAdapter.notifyDataSetChanged();
		            	
		//            	arrayfile=new ArrayList<File>();
		  //          	arrayFileBody=new ArrayList<FileBody>();
		            //    System.out.println("selectedPath1 : " + selectedPath1);
		            }
		           
		        } 
		    }
	 
	 public class ImageAdapter extends BaseAdapter {
			
			ArrayList<String> mList;
			LayoutInflater mInflater;
			Context mContext;
			SparseBooleanArray mSparseBooleanArray;
			
			public ImageAdapter(Context context, ArrayList<String> imageList) {
				// TODO Auto-generated constructor stub
				mContext = context;
				mInflater = LayoutInflater.from(mContext);
				mSparseBooleanArray = new SparseBooleanArray();
				mList = new ArrayList<String>();
				this.mList = imageList;

			}
			
			public ArrayList<String> getCheckedItems() {
				ArrayList<String> mTempArry = new ArrayList<String>();

				for(int i=0;i<mList.size();i++) {
					if(mSparseBooleanArray.get(i)) {
						mTempArry.add(mList.get(i));
					}
				}

				return mTempArry;
			}
			
			@Override
			public int getCount() {
				return anh.size();
			}

			@Override
			public Object getItem(int position) {
				return null;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				
				if(convertView == null) {
					convertView = mInflater.inflate(R.layout.row_multiphoto_item2, null);
				}

			//	CheckBox mCheckBox = (CheckBox) convertView.findViewById(R.id.checkBox1);
				final ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView1);
				
				imageLoader.displayImage("file://"+anh.get(position), imageView, options, new SimpleImageLoadingListener() {
					@Override
					public void onLoadingComplete(Bitmap loadedImage) {
						Animation anim = AnimationUtils.loadAnimation(binhluan.this, R.anim.fade_in);
						imageView.setAnimation(anim);
						anim.start();
					}
				});
				
			//	mCheckBox.setTag(position);
			//	mCheckBox.setChecked(mSparseBooleanArray.get(position));
		//		mCheckBox.setOnCheckedChangeListener(mCheckedChangeListener);
				
				return convertView;
			}
			
		/*	OnCheckedChangeListener mCheckedChangeListener = new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Auto-generated method stub
					mSparseBooleanArray.put((Integer) buttonView.getTag(), isChecked);
				}
			}; */
		}
	 
	 
}



