package com.example.android_appfood2;



import java.util.ArrayList;

import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity   {
	  String[] mMenuTitles;
	    int[] mMenuIcons={R.drawable.ic_home,R.drawable.ic_people,R.drawable.ic_photos};
	    ListView listviewMenu;
	    MyArrayAdapter adaptermenu;
	    DrawerLayout drawerlayout;
	    ArrayList<DrawerItem> dataDrawerItems;
	Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"Home","Sale","Data"};
    int Numboftabs =3;
    DatabaseHandler   db;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        
       
        mMenuTitles=getResources().getStringArray(R.array.drawer_items_title);
      
        // Creating The Toolbar and setting it as the Toolbar for the activity

     //   toolbar = (Toolbar) findViewById(R.id.tool_bar);
     //   setSupportActionBar(toolbar);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(4); //giu du lieu trong page
        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width
        
        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor1);
            }
        });
        
        // Setting the ViewPager For the SlidingTabsLayout
     
        tabs.setViewPager(pager);
      tabs.setOnPageChangeListener(new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			if (pager.getCurrentItem()==3){
				
				drawerlayout.openDrawer(listviewMenu);
				
			}
			
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}
	});
  
        
        listviewMenu = (ListView) findViewById(R.id.left_drawer);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //
      
        //data menu items
        dataDrawerItems = new ArrayList<DrawerItem>();
        //Home
        
           db =new DatabaseHandler(this);
        if (db.checkdangnhap()){
        	 dataDrawerItems.add(new DrawerItem(mMenuTitles[1], mMenuIcons[1]));
        	 dataDrawerItems.add(new DrawerItem(mMenuTitles[2], mMenuIcons[2]));
        }else {
        dataDrawerItems.add(new DrawerItem(mMenuTitles[0],mMenuIcons[0]));
        }
        // Find People
      //  dataDrawerItems.add(new DrawerItem(mMenuTitles[1], mMenuIcons.getResourceId(1, -1)));
        // Photos
     //   dataDrawerItems.add(new DrawerItem(mMenuTitles[2], mMenuIcons.getResourceId(2, -1)));
        // Communities
      //  dataDrawerItems.add(new DrawerItem(mMenuTitles[3], mMenuIcons.getResourceId(3, -1)));
        // Pages
     //   dataDrawerItems.add(new DrawerItem(mMenuTitles[4], mMenuIcons.getResourceId(4, -1)));
        // What's hot
     //   dataDrawerItems.add(new DrawerItem(mMenuTitles[5], mMenuIcons.getResourceId(5, -1)));
       
   //     mMenuIcons.recycle();
        //
        adaptermenu = new MyArrayAdapter(this, android.R.layout.simple_list_item_1, dataDrawerItems);

        listviewMenu.setAdapter(adaptermenu);
        //listviewMenu.setSelector(color.holo_red_dark);
       
        listviewMenu.setOnItemClickListener(new OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     drawerlayout.closeDrawers();
                     //Truyá»�n menu chá»�n qua FragmentDetail
                     if (dataDrawerItems.size()<=1){
                 if (position==0){
                	 dangnhap();
                 }
                 }else {
                	 if (position==0){
                		 postbai();
                     }else {
                    	 db.deletedangnhap();
                    	 dataDrawerItems.clear();
                    	 dataDrawerItems.add(new DrawerItem(mMenuTitles[0], mMenuIcons[0]));
                    	 adaptermenu.notifyDataSetChanged();
                     }
                 }
                //     DrawerItem listViewSelect = (DrawerItem) parent.getItemAtPosition(position);
               //    Toast.makeText(getApplication(), listViewSelect.getTitle(), Toast.LENGTH_SHORT).show()     ;           
               }
        });  
        
       
        

	}
    
    public void dangnhap(){
    	Intent intent = new Intent(this,dangnhap.class);
        startActivityForResult(intent,100);
       }
    public void postbai(){
     	 Intent ii=new Intent(this,postbai.class);
  	 startActivity(ii);
      }
   
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
		 
	    if (resultCode == RESULT_OK) {
	        //    Uri selectedImageUri = data.getData();
	            if (requestCode == 100)
	            {
	            	
	            	dataDrawerItems.remove(0);
	            	 dataDrawerItems.add(new DrawerItem(mMenuTitles[1], mMenuIcons[1]));
	            	 dataDrawerItems.add(new DrawerItem(mMenuTitles[2], mMenuIcons[2]));
	            //	imageAdapter.notifyDataSetChanged();
	            	 adaptermenu.notifyDataSetChanged();
	//            	arrayfile=new ArrayList<File>();
	  //          	arrayFileBody=new ArrayList<FileBody>();
	            //    System.out.println("selectedPath1 : " + selectedPath1);
	            }
	           
	        } 
	    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		   MenuItem mi=menu.add(1,1,1,"");
		   mi.setIcon(R.drawable.menu);
		   mi.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS|MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		   mi.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// TODO Auto-generated method stub
				
				if (drawerlayout.isDrawerOpen(listviewMenu)){
					drawerlayout.closeDrawer(listviewMenu);
				}else {
					drawerlayout.openDrawer(listviewMenu);
				}
				
				return false;
			}
		});
	//	SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
   //    searchView.setOnQueryTextListener(this);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
	
		return super.onOptionsItemSelected(item);
	}




	





}
