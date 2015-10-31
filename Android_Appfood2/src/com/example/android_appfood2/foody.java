package com.example.android_appfood2;

import java.io.Serializable;

import android.content.ClipData.Item;
import android.graphics.Bitmap;


public class foody implements Serializable {
	int id,giamgia;
	float rate;
	double latitude,longitude;
	String tieude,des,thanhpho,menu,diachi,diadiem,sdt,gia;
	Bitmap hinhanh;
	Boolean sele=false;
	String testhinhanh;
	String dembinhluan;
	String demhinhanh;
	/**
	 * @return the id
	 */
	
	public foody(){
		
	}
	
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the rate
	 */
	public float getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(float rate) {
		this.rate = rate;
	}
	/**
	 * @return the tieude
	 */
	public String getTieude() {
		return tieude;
	}
	/**
	 * @param tieude the tieude to set
	 */
	public void setTieude(String tieude) {
		this.tieude = tieude;
	}
	/**
	 * @return the des
	 */
	public String getDes() {
		return des;
	}
	/**
	 * @param des the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}
	/**
	 * @return the hinhanh
	 */
	public Bitmap getHinhanh() {
		return hinhanh;
	}
	/**
	 * @param hinhanh the hinhanh to set
	 */
	public void setHinhanh(Bitmap hinhanh) {
		this.hinhanh = hinhanh;
	}
	/**
	 * @return the thanhpho
	 */
	public String getThanhpho() {
		return thanhpho;
	}
	/**
	 * @param thanhpho the thanhpho to set
	 */
	public void setThanhpho(String thanhpho) {
		this.thanhpho = thanhpho;
	}
	/**
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}
	/**
	 * @param menu the menu to set
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}
	/**
	 * @return the diachi
	 */
	public String getDiachi() {
		return diachi;
	}
	/**
	 * @param diachi the diachi to set
	 */
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	/**
	 * @return the diadiem
	 */
	public String getDiadiem() {
		return diadiem;
	}
	/**
	 * @param diadiem the diadiem to set
	 */
	public void setDiadiem(String diadiem) {
		this.diadiem = diadiem;
	}
	/**
	 * @return the sdt
	 */
	public String getSdt() {
		return sdt;
	}
	/**
	 * @param sdt the sdt to set
	 */
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	/**
	 * @return the gia
	 */
	public String getGia() {
		return gia;
	}
	/**
	 * @param gia the gia to set
	 */
	public void setGia(String gia) {
		this.gia = gia;
	}

	/**
	 * @return the sele
	 */
	public Boolean getSele() {
		return sele;
	}

	/**
	 * @param sele the sele to set
	 */


	public void setSele(boolean checked) {
		// TODO Auto-generated method stub
		this.sele = checked;
	}

	/**
	 * @return the giamgia
	 */
	public int getGiamgia() {
		return giamgia;
	}

	/**
	 * @param giamgia the giamgia to set
	 */
	public void setGiamgia(int giamgia) {
		this.giamgia = giamgia;
	}

	/**
	 * @return the testhinhanh
	 */
	public String getTesthinhanh() {
		return testhinhanh;
	}

	/**
	 * @param testhinhanh the testhinhanh to set
	 */
	public void setTesthinhanh(String testhinhanh) {
		this.testhinhanh = testhinhanh;
	}

	/**
	 * @return the dembinhluan
	 */
	public String getDembinhluan() {
		return dembinhluan;
	}

	/**
	 * @param dembinhluan the dembinhluan to set
	 */
	public void setDembinhluan(String dembinhluan) {
		this.dembinhluan = dembinhluan;
	}

	/**
	 * @return the demhinhanh
	 */
	public String getDemhinhanh() {
		return demhinhanh;
	}

	/**
	 * @param demhinhanh the demhinhanh to set
	 */
	public void setDemhinhanh(String demhinhanh) {
		this.demhinhanh = demhinhanh;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	

   

}
