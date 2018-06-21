package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Unconsciousyes extends Templet1{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.unconscious1;
		vv.setVideoURI(Uri.parse(uri));
		vv.start();
		 
		txt1.setText("Move them onto their side and tilt their head back.");
		txt2.setText("As soon as possible, Call Ambulance or get someone else to do it.");
		txt3.setText("Continue to monitor the person until help arrives.");

	}
	}
