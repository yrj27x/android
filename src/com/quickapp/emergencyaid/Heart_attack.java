package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Heart_attack extends Templet4{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.heart_attack;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("The person may have persistent vice-like chest pain, or isolated unexplanined discomfort in arms, neck, jaw, back or stomach.");
		txt2.setText("Call Ambulance immediately or get someone else to do it.");
		txt3.setText("Make sure they are in a position that is comfortable for them (e.g. sit them on the floor, leaning againest a wall or chair) and give them aspirin(if available and if they're not allergic.");
		txt4.setText("Give them constant reassurane while waiting for the ambulance.");
	}
	}
