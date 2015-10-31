package com.example.android_appfood2;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class dangky extends Activity implements OnClickListener {
	EditText ed1,ed2,ed3,ed4;
	Button bt1,bt2;
	TextView tv1;
	private static String KEY_SUCCESS = "success";
 
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
		setContentView(R.layout.dangky);
		ed1=(EditText)findViewById(R.id.namedangkt);
		ed2=(EditText)findViewById(R.id.emaildangky);
		ed3=(EditText)findViewById(R.id.passdangky);
		ed4=(EditText)findViewById(R.id.pass1dangky);
		tv1=(TextView)findViewById(R.id.textView1);
		bt1=(Button)findViewById(R.id.submit);
		bt2=(Button)findViewById(R.id.Cancel);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		

		case R.id.submit:
			Log.v("22222", ed1.getText().toString()+"  "+ed2.getText().toString()+" "+ed3.getText().toString()+" "+ed4.getText().toString());
			if (!((ed3.getText().toString().trim()).equals(ed4.getText().toString().trim())) ) {
				 Toast.makeText(getApplication(), "2 pass không giống nhau", Toast.LENGTH_SHORT).show();
			}else {
			String name = ed1.getText().toString().trim();
	        String email = ed2.getText().toString().trim();
	        String password = ed3.getText().toString().trim();
	        if (name.equals("") || email.equals("") || password.equals("")){
	        	 Toast.makeText(getApplication(), "Lỗi do có trường để trống", Toast.LENGTH_SHORT).show();
	        } else {
	        UserFunctions userFunction = new UserFunctions();
	        JSONObject json = userFunction.registerUser(name, email, password);
			 try {
                 if (json.getString(KEY_SUCCESS) != null) {
                	 tv1.setText("");
                     String res = json.getString(KEY_SUCCESS);
                     Log.v("0", res);
                     //Nếu đăng ký thành công
                     if(Integer.parseInt(res) == 1){               
                         //Lưu trữ thông tin người dùng vào database
                    //     DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                   //      JSONObject json_user = json.getJSONObject("user");
                         //Xóa tất cả dữ liệu
                   //      userFunction.logoutUser(getApplicationContext());
                  //       db.addUser(json_user.getString(KEY_NAME), json_user.getString(KEY_EMAIL), json.getString(KEY_UID), json_user.getString(KEY_CREATED_AT));           
                         //Chuyển qua Activity kết quả
                       //  Intent dashboard = new Intent(getApplicationContext(), dangnhap.class);
                        // dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                      //   startActivity(dashboard);
                        Toast.makeText(getApplication(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                       
                         //Đóng Activity hiện tại
                         finish();
                     }else{
                         //Nếu đăng ký không thành công
                    	 Toast.makeText(getApplication(), "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                     }
                 }
             } catch (JSONException e) {
                 e.printStackTrace();
             }
	        }
			}
			break;
		case R.id.Cancel:
			finish();
			break;
		}
		
	}
}
