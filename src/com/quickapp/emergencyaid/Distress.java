package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Distress extends Templet3{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.distress;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("Show you are listening and calmly ask them how you can help.");
		txt2.setText("Be condiderate of what is going on around them and what they need.");
		
	}
	}
