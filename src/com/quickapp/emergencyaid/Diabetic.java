package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Diabetic extends Templet1{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.diabetes;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("Give them something containing suger to eat or non-diet drink.");
		txt2.setText("Reassure the person.");
		txt3.setText("Most people will gradually improve, but if you are in doubt, the person is breathing fast, pale or sweating, or if they become unconscious Call Ambulance.");

	}
	}
