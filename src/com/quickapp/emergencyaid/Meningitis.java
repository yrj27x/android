package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Meningitis extends Templet1{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.meningitis;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("The person will complain of a stiff neck. They also may have flu-like symptoms, muscle and joint pain, a headache, a high temperature, and be sensitive to light..");
		txt2.setText("When observe these symoptoms, call ambulance.");
		txt3.setText("Give them constant reassurance while wating for the ambulance.");

	}
	}
