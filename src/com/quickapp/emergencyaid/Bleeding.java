package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Bleeding extends Templet1{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.bleeding;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("Put pressure on the wound with whatever is available to stop or slow down the flow of blood.");
		txt2.setText("If the bleeding is servere, Call Ambulance as soon as possible, or get someone to do it.");
		txt3.setText("Keep pressure on the wound utill help arrives");
		

	}
	}
