package com.example.android_appfood2;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
 
import android.util.Log;
 
public class JSONParser {
 
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
 
    //Hàm xây dựng khởi tạo đối tượng
    public JSONParser() {
 
    }
 
    public JSONObject getJSONFromUrl(String url, List<NameValuePair> params) {
        //Cố gắng thực hiện gửi yêu cầu lên HTTP
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
          //  MultipartEntity reqEntity = new MultipartEntity();
         //   reqEntity.addPart("user", (ContentBody) new UrlEncodedFormEntity(params));
            httpPost.setEntity(new UrlEncodedFormEntity(params));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
            Log.e("JSON", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
 
        //Cố gắng phân tích chuỗi sang một JSONObject
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return jObj;
    }
    
    
    
    
    public JSONObject getJSONFromUrlbinhluan(String url, String idthongtin, String iduser,String name, String binhluan,ArrayList<String> anh) {
        //Cố gắng thực hiện gửi yêu cầu lên HTTP
        try {
        	ArrayList<File> arrayfile=new ArrayList<File>();
        	ArrayList<FileBody> arrayFileBody=new ArrayList<FileBody>();
        	
        	
        	 for (int i=0;i<anh.size();i++){
             	File file = new File(anh.get(i));
             	arrayfile.add(file);
             }
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            for (int i=0;i<arrayfile.size();i++){
           	 FileBody bin = new FileBody(arrayfile.get(i));
           	 arrayFileBody.add(bin);
            }
            MultipartEntity reqEntity = new MultipartEntity();
            for (int i=0;i<arrayfile.size();i++){
           	 reqEntity.addPart("uploadedfile"+(i+1), arrayFileBody.get(i));
            }
         reqEntity.addPart("tag", new StringBody("binhluan"));
         reqEntity.addPart("idthongtin", new StringBody(idthongtin));
         reqEntity.addPart("iduser", new StringBody(iduser));
         reqEntity.addPart("username", new StringBody(name));
         reqEntity.addPart("binhluan", new StringBody(binhluan));
    //     reqEntity.addPart("hinhanh", new StringBody(hinhanh));
            httpPost.setEntity(reqEntity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
            Log.e("JSON", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
 
        //Cố gắng phân tích chuỗi sang một JSONObject
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return jObj;
    }
    
    
    public JSONObject getJSONFromUrlpostbai(String url, String tieude, String mota,String diachi, String menu,String thanhpho,String sdt,String gia,String giamgia,String anh) {
        //Cố gắng thực hiện gửi yêu cầu lên HTTP
        try {
        
        	
        	
        	
             	File file = new File(anh);
             
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
           	 FileBody bin = new FileBody(file);
            MultipartEntity reqEntity = new MultipartEntity();
         reqEntity.addPart("uploadedfile1", bin);
         reqEntity.addPart("tag", new StringBody("binhluan"));
         reqEntity.addPart("tieude", new StringBody(tieude));
         reqEntity.addPart("mota", new StringBody(mota));
         reqEntity.addPart("diachi", new StringBody(diachi));
         reqEntity.addPart("menu", new StringBody(menu));
         reqEntity.addPart("thanhpho", new StringBody(thanhpho));
         reqEntity.addPart("sdt", new StringBody(sdt));
         reqEntity.addPart("gia", new StringBody(gia));
         reqEntity.addPart("giamgia", new StringBody(giamgia));
    //     reqEntity.addPart("hinhanh", new StringBody(hinhanh));
            httpPost.setEntity(reqEntity);
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
            Log.e("JSON", json);
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
 
        //Cố gắng phân tích chuỗi sang một JSONObject
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
        return jObj;
    }
    
}