package com.quickapp.emergencyaid;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

@SuppressLint("NewApi") public class Main extends Activity {
TextView alertsms,hospital,police,chemist,firstaid,blood,bank;
LinearLayout alertsmslay,policelay,hospitallay,chemistlay,bloodbanklay,firstaidlay;
@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
	Intent intent = new Intent(Intent.ACTION_MAIN);
	   intent.addCategory(Intent.CATEGORY_HOME);
	   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	   startActivity(intent);
		super.onBackPressed();
	}

/*********location**********/
double mLatitude=0;
double mLongitude=0;
Geocoder geocoder;
String address;
String city;
String country;
List<Address> addresses;

LocationManager locmng;
LocationListener loclistner;
TextView faddress;
ImageView greendot;
/*\**********location******\*/


	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		   //requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		ActionBar bar = getActionBar();
		//for color
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff0000")));
		//for image
		
		
		alertsms=(TextView) findViewById(R.id.textalertsms);
		police=(TextView) findViewById(R.id.textpolice);
		chemist=(TextView) findViewById(R.id.textchemist);
		firstaid=(TextView) findViewById(R.id.textfirstaid);
		bank=(TextView) findViewById(R.id.textbank);
		blood=(TextView) findViewById(R.id.textblood);
		hospital=(TextView) findViewById(R.id.texthospital);
		
		Typeface myf= Typeface.createFromAsset(getAssets(), "font3bold.ttf");
		alertsms.setTypeface(myf);
	    hospital.setTypeface(myf);
		police.setTypeface(myf);
		chemist.setTypeface(myf);
		firstaid.setTypeface(myf);
		bank.setTypeface(myf);
		blood.setTypeface(myf);
		
		alertsmslay=(LinearLayout) findViewById(R.id.alertsmslayout);
		policelay=(LinearLayout) findViewById(R.id.policelayout);
		hospitallay=(LinearLayout) findViewById(R.id.hospitallayout);
		chemistlay=(LinearLayout) findViewById(R.id.chemistlayout);
		bloodbanklay=(LinearLayout) findViewById(R.id.bloodbanklayout);
		firstaidlay=(LinearLayout) findViewById(R.id.firstaidlayot);
		
		firstaidlay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), FirstAid.class));
			}
		});
		
		alertsmslay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), Alertsms.class));
				
			}
		});
		
	bloodbanklay.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(new Intent(getApplicationContext(), Bloodbank.class));
			//startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=mfY1NKrzqi0")));
		}
	});
		
		/////////************************///////////////*******location******////////
		
		faddress=(TextView) findViewById(R.id.textfaddress);
		faddress.setTypeface(myf);
		geocoder = new Geocoder(getApplicationContext(),Locale.getDefault());
		locmng= (LocationManager) getSystemService(LOCATION_SERVICE);
		loclistner=new LocationListener()
		{

			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				
				mLatitude = location.getLatitude();
				mLongitude = location.getLongitude();
				
				
				try {
			    	addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
			    } catch (IOException e) {
			    	// TODO Auto-generated catch block
			    	e.printStackTrace();
			    }

			    address = addresses.get(0).getAddressLine(0);
			    city = addresses.get(0).getAddressLine(1);
			    country = addresses.get(0).getAddressLine(2);
			    faddress.setText("" +address+","+city+","+country);
			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
		};
		locmng.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 100.0F, loclistner);
		locmng.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 100.0F, loclistner);
		
		
		greendot=(ImageView) findViewById(R.id.imagegreendot);
		
		  Animation myFadeInAnimation4 = AnimationUtils.loadAnimation(getApplicationContext(),R.drawable.fadein );
	        
 		 greendot.startAnimation(myFadeInAnimation4);
	//////////*************//////////location*******/////////////////
 		 
 		 
 		 policelay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), PoliceStn.class));
				
			}
		});
 		 
 		 hospitallay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), Hospital.class));
				
			}
		});
 		 
 		 chemistlay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), Chemist.class));
				
			}
		});
	}
}
