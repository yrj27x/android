package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Choking extends Templet2{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.choking;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("If an adult or child hit them firmly on their back between the shoulder blades 5 times to dislodge the object follwed by 5 quick abdominal thrusts.");
		txt2.setText("For infants under 1 year old" +"+\n"+"- Keep their head lower than the chest, supporting their head and nack."+"\n"+"- Then give 5 back blows between the shoulder blades and 5 chest thrusts, center of chest just below nipple line."+"\n"+"- Repeat this until the object is forced out or the infant can be heard to cry.");
		txt3.setText("Call Ambulance for altered level of consciousness, voice changes, if significant maneuvers to clear the airway are required, or if you are concerned.");
	}
}