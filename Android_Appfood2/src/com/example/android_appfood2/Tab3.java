package com.example.android_appfood2;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab3 extends Fragment {
//	MapView mapView;
//	GoogleMap map;
	
	View v;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
       
        
     
         v =inflater.inflate(R.layout.tab_3,container,false);
        // Passing harcoded values for latitude & longitude. Please change as per your need. This is just used to drop a Marker on the Map
                 // For setting up the MapFragment

        
 //       mapView = (MapView) v.findViewById(R.id.mapview);
//		mapView.onCreate(savedInstanceState);
 
		// Gets to GoogleMap from the MapView and does initialization stuff
//	map = mapView.getMap();
//		map.getUiSettings().setMyLocationButtonEnabled(false);
//		map.setMyLocationEnabled(true);

//		MapsInitializer.initialize(this.getActivity());
		
		// Updates the location and zoom of the MapView
//		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(43.1, -87.9), 10);
	//	map.animateCamera(cameraUpdate);
    
   //    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
  //   map.getUiSettings().setZoomControlsEnabled(true);
      

        return v;
    }
    
    

    
    
}