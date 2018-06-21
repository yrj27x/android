package com.quickapp.emergencyaid;


import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;

public class Allergies extends Templet1{
@Override
public void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
	uri = "android.resource://" + getPackageName() + "/" + R.raw.allergic;
	vv.setVideoURI(Uri.parse(uri));
	vv.start();
	 
	txt1.setText("The person may develop a rash, itchiness or swelling o the body, feet or face. Their breathing may slow down.");
	txt2.setText("When observe these symoptoms, call ambulance.");
	txt3.setText("If the person has a known allergy and has ab auto-injector/Epi-pen, you can help them to use it. Give them constant reassurance while wating for the ambulance.");

}
}
