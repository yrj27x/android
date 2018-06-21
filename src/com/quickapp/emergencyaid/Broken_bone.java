package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Broken_bone extends Templet1{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.broken_bone;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("Encourage the person to support the injury with their hend, or use a cushion or items of clothing to prevent unnescessary movement.");
		txt2.setText("If the injured area is obviously deformed, significantly painfful or need for trasport, Call Ambulance or get someone else to do it.");
		txt3.setText("Make sure the injury is supported untill help arrives.");

	}
	}
