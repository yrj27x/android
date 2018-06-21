package com.quickapp.emergencyaid;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Hypothermia extends Templet1{
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		vv.setVisibility(View.INVISIBLE);
		 
		txt1.setText("The person may be shivering, pale and cold to touch. They may also be disoriented");
		txt2.setText("As soon as possible Call Ambulance or get someone to do it.");
		txt3.setText("Warm the person slowly and, if they're conscious, give them wram drinks or soup by mouth.");

	}
	}
