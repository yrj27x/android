package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Poisoning extends Templet1{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.poison;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("Establish what they have taken. When? And how much?");
		txt2.setText("As soon as possible, call ambulance or get someone else to do it. If there is change in behavior, they become unconscious or hava difficulty breathing.");
		txt3.setText("Do not make the person sick or give them anything to drink usless advised to do so by doctor.");

	}
	}
