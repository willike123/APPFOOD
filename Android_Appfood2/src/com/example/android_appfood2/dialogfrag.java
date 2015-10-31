package com.example.android_appfood2;
import com.squareup.picasso.Picasso;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class dialogfrag extends DialogFragment {
	String url;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setStyle(STYLE_NORMAL, 0);
	}
	
	public void nhandulieu(String hinh){
		this.url=hinh;
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.dialogfrag,container,false);
        Dialog d=getDialog();
        d.setTitle("Hình Ảnh");
        d.setCanceledOnTouchOutside(true);
        Button bt=(Button)v.findViewById(R.id.button1);
        ImageView iv=(ImageView)v.findViewById(R.id.imageView1);
        Picasso.with(getActivity()).load("http://ddl-mediafire.com/Spam/upload2/uploads/"+url).into(iv);
        bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
        
        
        return v;
    }
}