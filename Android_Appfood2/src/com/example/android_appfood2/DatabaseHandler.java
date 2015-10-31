package com.example.android_appfood2;

import java.util.ArrayList;
import java.util.List;

import android.R.bool;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "foody";
   
   
    public DatabaseHandler(Context context) {
           super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_CONTACTS_TABLE = "CREATE TABLE thongtin (id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "idthongtin INTEGER,tieude TEXT,des TEXT,hinhanh TEXT,thanhpho TEXT,menu TEXT,diachi TEXT,sdt TEXT,rate INTEGER,"
				+ "gia TEXT,giamgia INTEGER)";
		String CREATE_CONTACTS_TABLE1 = "CREATE TABLE dangnhap (id INTEGER PRIMARY KEY,"
				+ "username TEXT,pass TEXT)";
				
   db.execSQL(CREATE_CONTACTS_TABLE);
   db.execSQL(CREATE_CONTACTS_TABLE1);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 db.execSQL("DROP TABLE IF EXISTS thongtin");
		 db.execSQL("DROP TABLE IF EXISTS dangnhap");
         onCreate(db);
	}

	void addContact(foody foody,String hinhanh) {
        SQLiteDatabase db = this.getWritableDatabase();
       
        ContentValues values = new ContentValues();
        values.put("idthongtin", foody.getId());
        values.put("tieude", foody.getTieude());
        values.put("des", foody.getDes());
        values.put("hinhanh", hinhanh);
        values.put("thanhpho", foody.getThanhpho());
        values.put("menu", foody.getMenu());
        values.put("diachi", foody.getDiachi());
        values.put("sdt", foody.getSdt());
        values.put("rate", foody.getRate());
        values.put("gia", foody.getGia());
        values.put("giamgia", foody.getGiamgia());
        //insert to database
        db.insertOrThrow("thongtin", null, values);
        db.close();
 }
	
	
	 public List<foody> getAllContacts() {
         List<foody> contactslist = new ArrayList<foody>();
         String selectAllQuery = "SELECT * FROM thongtin" ;
        
         SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.rawQuery(selectAllQuery, null);
               
         if (cursor.moveToFirst()) {
                do {
                      foody person = new foody();
                      person.setId(cursor.getInt(1));
                      person.setTieude(cursor.getString(2));
                      person.setDes(cursor.getString(3));
                      person.setTesthinhanh(cursor.getString(4));
                      person.setThanhpho(cursor.getString(5));
                      person.setMenu(cursor.getString(6));
                      person.setDiachi(cursor.getString(7));
                      person.setSdt(cursor.getString(8));
                      person.setRate(cursor.getInt(9));
                      person.setGia(cursor.getString(10));
                      person.setGiamgia(cursor.getInt(11));
                      contactslist.add(person);
                } while(cursor.moveToNext());
         }
        Log.v("2222222", Integer.toString(contactslist.size()));
         return contactslist;
  }
	 
	 public boolean checkluu(int idthongtin){
		 SQLiteDatabase db = this.getWritableDatabase();
		 Cursor dataCount = db.rawQuery("select * from thongtin where idthongtin="+idthongtin  , null);
		 if(dataCount.getCount()!=0){
			 return true;
		 }else return false;
		 
	 }
	 
	 public void removeluu(int idthongtin){
		 SQLiteDatabase db = this.getWritableDatabase();
		 db.delete("thongtin" , "idthongtin = " + idthongtin, null);
		 db.close();
	 }
	 
	 public boolean checkdangnhap(){
		 SQLiteDatabase db = this.getWritableDatabase();
		 Cursor dataCount = db.rawQuery("select * from dangnhap"  , null);
		 if(dataCount.getCount()!=0){
			 return true;
		 }else return false;
		 
	 }
	 
	 public void adduser(String username,String pass,int iduser){
		 SQLiteDatabase db = this.getWritableDatabase();	       
	        ContentValues values = new ContentValues();
	        values.put("id", iduser);
	        values.put("username", username);
	        values.put("pass", pass);	     
	        //insert to database
	        db.insertOrThrow("dangnhap", null, values);
	        db.close();
	 }
	 
	 public String getuser(){
		 String get="";
		 String selectAllQuery = "SELECT * FROM dangnhap" ;
		  SQLiteDatabase db = this.getWritableDatabase();
	         Cursor cursor = db.rawQuery(selectAllQuery, null);
	         if (cursor.moveToFirst()) {
	                do {
	                	get=cursor.getString(0)+"|"+cursor.getString(1);
	                } while(cursor.moveToNext());
	         }
	         return get;
	 }
	 
	 public void deletedangnhap()
	 {
	     SQLiteDatabase db= this.getWritableDatabase();
	     db.delete("dangnhap", null, null);
	     db.close();
	 }
	 
}
