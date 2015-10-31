package com.example.android_appfood2;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;


import android.content.Context;
 
public class UserFunctions {
 
    private JSONParser jsonParser;
 
    private static String loginURL = "http://ddl-mediafire.com/android_login_api/";
    private static String registerURL = "http://ddl-mediafire.com/android_login_api/";
    private static String binhluanURL = "http://ddl-mediafire.com/Spam/uploadbinhluan.php";
    /*private static String loginURL = "http://localhost/android_login_api/ ";
    private static String registerURL = "http://localhost/android_login_api/";*/
 
    private static String login_tag = "login";
    private static String register_tag = "register";
    private static String binhluan_tag="binhluan";
    //Hàm xây dựng khởi tạo đối tượng
    public UserFunctions(){
        jsonParser = new JSONParser();
    }
 
    
    public JSONObject binhluanurl(String idthongtin, String iduser, String binhluan,String hinhanh){
        //Xây dựng các giá trị
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", binhluan_tag));
        params.add(new BasicNameValuePair("idthongtin", idthongtin));
        params.add(new BasicNameValuePair("iduser", iduser));
        params.add(new BasicNameValuePair("binhluan", binhluan));
        params.add(new BasicNameValuePair("hinhanh", hinhanh));
        JSONObject json = jsonParser.getJSONFromUrl(binhluanURL, params);
        //Trả về đối tượng là 1 JSONObject
        return json;
    }
    
    //Thực hiện công việc đăng nhập với email và password
    public JSONObject loginUser(String name, String password){
        //Xây dựng các giá trị
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", login_tag));
        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("password", password));
        JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
        //Trả về đối tượng là 1 JSONObject
        return json;
    }
 
    public JSONObject registerUser(String name, String email, String password){
        //Xây dựng các giá trị
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag", register_tag));
        params.add(new BasicNameValuePair("name", name));
        params.add(new BasicNameValuePair("email", email));
        params.add(new BasicNameValuePair("password", password));
        JSONObject json = jsonParser.getJSONFromUrl(registerURL, params);
        //Trả về đối tượng là 1 JSONObject
        return json;
    }
 /*
    //Kiểm tra người dùng
    public boolean isUserLoggedIn(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        int count = db.getRowCount();
        if(count > 0){
            return true;
        }
        return false;
    }
 
    //Thực hiện việc logoutUser bằng cách xóa dữ liệu database
    public boolean logoutUser(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.resetTables();
        return true;
    }
 */
}