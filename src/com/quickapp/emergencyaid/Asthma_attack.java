package com.quickapp.emergencyaid;


import android.net.Uri;
import android.os.Bundle;

public class Asthma_attack extends Templet2{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.asthma;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("Help the person sit in a comfortable position and take their medication.");
		txt2.setText("Reassure the person.");
		txt3.setText("If the attack become severs, they don't hava their medication or they don't improve with medication, Call Ambulance or get someone else to do it.");
	}

}
