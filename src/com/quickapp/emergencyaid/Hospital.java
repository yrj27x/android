package com.quickapp.emergencyaid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Hospital extends Map{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mPlaceType="hospital";
		mPlaceTypeName="Hospital";
	}
}