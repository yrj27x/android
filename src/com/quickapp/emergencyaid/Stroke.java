package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Stroke extends Templet1{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.stroke;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("Think F.A.S.T"+"\n"+"Face: is there weakness on one side of the face?"+"\n"+"Arams: can they raise both arms?"+"\n"+"Speech: is their speech easily understood?"+"\n"+"Time: to call ambulance");
		txt2.setText("Immediately Call Ambulance or get someone else to do it.");
		txt3.setText("Talk to the person to reassure them while you wait for the ambulance.");
		

	}
	}