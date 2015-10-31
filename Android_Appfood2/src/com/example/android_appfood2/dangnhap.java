package com.example.android_appfood2;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class dangnhap extends Activity implements OnClickListener {
	Button bt2,bt1;
	EditText ed1,ed2;
	TextView tv1;
	 foody data=new foody();
	private static String KEY_SUCCESS = "success";
    private static String KEY_UID = "uid";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";
    private static String KEY_CREATED_AT = "created_at";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.dangnhap);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
		bt1=(Button)findViewById(R.id.button1);
		bt2=(Button)findViewById(R.id.button2);
		ed1=(EditText)findViewById(R.id.editText1);
		ed2=(EditText)findViewById(R.id.editText2);
		tv1=(TextView)findViewById(R.id.textView1);
		bt2.setOnClickListener(this);
		bt1.setOnClickListener(this);
	
	/*	Intent i=getIntent();
		Bundle b=i.getExtras();
		if (b!=null){
		 data=(foody) b.getSerializable("binhluan");
		} */
	}

	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
			case R.id.button2:
				Intent a=new Intent(this,dangky.class);
				  startActivity(a);
				  break;
			case R.id.button1:
				 String user = ed1.getText().toString().trim();
	                String password = ed2.getText().toString().trim();
	                UserFunctions userFunction = new UserFunctions();
	                JSONObject json = userFunction.loginUser(user, password);
	                //Log.v("0", json.toString());
	                try {
	                    if (json.getString(KEY_SUCCESS) != null) {
	                    	tv1.setText("");
	                        String res = json.getString(KEY_SUCCESS);
	                        if(Integer.parseInt(res) == 1){
	                            // user successfully logged in
	                            //Lưu trữ thông tin chi iết người dùng trong database
	                          DatabaseHandler db = new DatabaseHandler(getApplicationContext());
	                            JSONObject json_user = json.getJSONObject("user");
	                            
	                            //Xóa toàn bộ dữ liệu trong Database
	                   //         userFunction.logoutUser(getApplicationContext());
	                          db.adduser(user, password,json_user.getInt("uid")); 
	                          Intent i=new Intent();
	                      	
	                  		//writeToFile(name+"/"+phone);
	                  	//	bb.putSerializable("oj",(Serializable) custom ); //goi object
	                  	//	bb.putString("name12", name);
	                  	//	bb.putString("phone12", phone);
	                  	
	                  		setResult(RESULT_OK,i);
	                  		
	                            //Chuyển qua trang đăng nhập thành công
	                     /*       Intent dashboard = new Intent(getApplicationContext(), binhluan.class);
	                            Bundle bb=new Bundle();
	                        	bb.putSerializable("binhluan", data);
	                        	bb.putString("iduser", json_user.getString("uid"));
	                        	bb.putString("username", json_user.getString("name"));
	                        	dashboard.putExtras(bb);
	                            dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	                            startActivity(dashboard);    */
	                          Toast.makeText(getApplicationContext(), "Đăng Nhập Thành Công !", Toast.LENGTH_SHORT).show();
	                            //Đóng Activity này
	                            finish();
	                        }else{
	                        	Toast.makeText(getApplicationContext(),"username/password không chính xác", Toast.LENGTH_SHORT).show();
	                            //Thông báo lỗi đang nhập không thành công
	                        	
	                        }
	                    }
	                } catch (JSONException e) {
	                }
	                
				break;
		}
	}
}
