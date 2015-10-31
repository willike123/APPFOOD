package com.example.android_appfood2;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class googlemap extends Activity{
	GoogleMap map;
	//Khai báo Progress Bar dialog để làm màn hình chờ
	ProgressDialog myProgress;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.googlemap);
	Intent i=getIntent();
	Bundle b=i.getExtras();
	double lati=b.getDouble("latitude");
	double longi=b.getDouble("longitude");
	String tieude=b.getString("tieude");
	String diachi=b.getString("diachi");
	//Tạo Progress Bar
	myProgress = new ProgressDialog(this);
	myProgress.setTitle("Đang tải Map ...");
	myProgress.setMessage("Vui lòng chờ...");
	myProgress.setCancelable(true);
	//Hiển thị Progress Bar
	myProgress.show();
	//Lấy đối tượng Google Map ra:
	map = ((MapFragment)getFragmentManager().
	findFragmentById(R.id.map)).getMap();
	//thiết lập sự kiện đã tải Map thành công
	map.setOnMapLoadedCallback(new OnMapLoadedCallback() {

	@Override
	public void onMapLoaded() {
	//Đã tải thành công thì tắt Dialog Progress đi
	myProgress.dismiss();
	}
	});
	map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	map.getUiSettings().setZoomControlsEnabled(true);
	map.setMyLocationEnabled(true);
	
	
	
	
	LatLng latLng=new LatLng(lati,longi);
	map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 13));
	 
	CameraPosition cameraPosition = new CameraPosition.Builder()
	.target(latLng)      // Sets the center of the map to location user
	.zoom(17)                   // Sets the zoom
	.bearing(0)                // Sets the orientation of the camera to east
	.tilt(0)                   // Sets the tilt of the camera to 30 degrees
	.build();                   // Creates a CameraPosition from the builder
	map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
	//Thêm MarketOption cho Map:
	MarkerOptions option=new MarkerOptions();
	option.title(tieude);
	option.snippet(diachi);
	option.position(latLng);
	Marker currentMarker= map.addMarker(option);
	currentMarker.showInfoWindow();
	
	}
}
