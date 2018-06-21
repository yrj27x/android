package com.quickapp.emergencyaid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Chemist extends Map {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mPlaceType="pharmacy";
		mPlaceTypeName="Pharmacy";
		
	}
}
