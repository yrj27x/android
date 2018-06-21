package com.quickapp.emergencyaid;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Stings extends Templet2{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		vv.setVisibility(View.INVISIBLE);
		 
		txt1.setText("Remove the stinger by scraping it away with a flat surface, such as a credit card.");
		txt2.setText("Wash wound with soap and water, cover with a dressing then apply ice or a cold pack.");
		txt3.setText("Call Ambulance or loacl emergency number if person seems to be having an allergic or anaphylaxic reaction.");
		
	}
	}