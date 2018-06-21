package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Head_injury extends Templet3{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.head_injury;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("If they become confused, drowsy, vomit or if the fall was greater than 2 times their height, Call Ambulance or get someone else to do it.");
		txt2.setText("Ask them to rest and apply a cold compress to the injury(e.g. frozen vegetable wrapped in a towel.");
		callambu4.setVisibility(View.VISIBLE);
		
	}
	}
