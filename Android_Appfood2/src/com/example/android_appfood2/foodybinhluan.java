package com.example.android_appfood2;

import java.io.Serializable;

public class foodybinhluan implements Serializable {
	int id,idthongtin,iduser;
	String username,binhluan,hinhanh;
	
	
	public foodybinhluan(){
		
	}
	
	/**
	 * @return the id
	 */
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
	 * @return the idthongtin
	 */
	public int getIdthongtin() {
		return idthongtin;
	}
	/**
	 * @param idthongtin the idthongtin to set
	 */
	public void setIdthongtin(int idthongtin) {
		this.idthongtin = idthongtin;
	}
	/**
	 * @return the iduser
	 */
	public int getIduser() {
		return iduser;
	}
	/**
	 * @param iduser the iduser to set
	 */
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the binhluan
	 */
	public String getBinhluan() {
		return binhluan;
	}
	/**
	 * @param binhluan the binhluan to set
	 */
	public void setBinhluan(String binhluan) {
		this.binhluan = binhluan;
	}
	/**
	 * @return the hinhanh
	 */
	public String getHinhanh() {
		return hinhanh;
	}
	/**
	 * @param hinhanh the hinhanh to set
	 */
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	
	
}
