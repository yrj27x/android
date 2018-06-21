package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Burns extends Templet2{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.burns;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("Cool the burn under cool running water for at least ten minutes.");
		txt2.setText("If the burn reqires further medical care, loosely cover the burn with plastic wrap or a clean plastic bag. Otherwise, it dose not need plastic covering.");
		txt3.setText("If necessary, Call Ambulance or get someone else to do it.");
	}

}
