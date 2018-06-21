package com.quickapp.emergencyaid;



import android.net.Uri;
import android.os.Bundle;

public class Heat_stroke extends Templet4{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		uri = "android.resource://" + getPackageName() + "/" + R.raw.heat_stroke;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		 
		txt1.setText("The person's skin may be hot or red, and may also be dry or moist; they may be experiencing changes in consciousness, as well as vomiting and a high body temperature.");
		txt2.setText("Call Ambulance immediately or get someone else to do it.");
		txt3.setText("Move the person to cooler place. Remove or loosen tight clothing and apply cool, wet cloths or towels to the skin. Fan the person, if they are conscious, give small amount of cool water to drink. Make sure they drink slowly.");
		txt4.setText("If they needed, continue rapid cooling by applying ice or cold packs wrapped in a cloth to the wrists, ankles, groin, neck and armpits.");
	}
	}
