package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Seizure extends Templet2{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.seizure;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("Do not restrain them. Use something like blanket or clothing next to their head to protect it form injury. Do not place under their head may compromise the airway.");
		txt2.setText("After the seizure, help the person to rest on their side with their head tilted back.");
		txt3.setText("If necessary, Call Ambulance or get someone to do it.");
		

	}
	}