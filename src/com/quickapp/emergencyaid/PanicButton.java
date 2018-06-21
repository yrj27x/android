package com.quickapp.emergencyaid;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Vector;



import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PanicButton extends Activity {
	
	LocationManager locationmanager;
    LocationListener locationlistener; 
    NotificationManager mnoticationmngr;
    
    private static final int DATABASE_VERSION = 1;
   	private static final String DATABASE_NAME = "myDatabase5";
   	DataBaseHelper handler;
   	
    
    double mLatitude=0.0;
	double mLongitude=0.0;
	
	ImageView panicbutton;
	
	TextView paincalrt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_panic_button);
        mnoticationmngr=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		panicbutton=(ImageView) findViewById(R.id.panicbtn);
		paincalrt=(TextView) findViewById(R.id.textViewonpanic);
		paincalrt.setText("Send your location to"+"\n"+"selected contacts?");
		Typeface myf= Typeface.createFromAsset(getAssets(), "font3bold.ttf");
		paincalrt.setTypeface(myf);
		
		handler = new DataBaseHelper(this, DATABASE_NAME, null, DATABASE_VERSION);
		
		locationmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		locationlistener=new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				//locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, locationlistener);
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				//locationmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 100, locationlistener);
			}
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				
				mLatitude = location.getLatitude();
				mLongitude = location.getLongitude();	
			}
		};
		
		locationmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 100.0F, locationlistener);
		locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0L, 100.0F, locationlistener);
		
	panicbutton.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Notification n = new Notification(R.drawable.noticon,"Emergency Aid",System.currentTimeMillis());
				Context con = getApplicationContext();
				Intent in = new Intent(con,Main.class);
				PendingIntent pi = PendingIntent.getActivity(con, 0, in, 0);
				n.setLatestEventInfo(con, "Emergency Aid", "Alert message has been sent.", pi);
				//n.flags=Notification.FLAG_ONGOING_EVENT;
				//n.flags |=Notification.FLAG_AUTO_CANCEL;
				mnoticationmngr.notify(0,n);
				Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				mVibrator.vibrate(50); 
				
			handler.getWritableDatabase();
				Cursor mCursor = handler.display();
				Vector<String> v1 = new Vector<String>();
				
			
			if (mCursor.moveToFirst()) {
					do {
						v1.add(mCursor.getString(2).toString());
						
					} while (mCursor.moveToNext());
				}

				SmsManager sm = SmsManager.getDefault();
				for (int i = 0; i < v1.size(); i++) {
					sm.sendTextMessage(v1.elementAt(i),null,"Please help me! My Location Coordiantes are"+" http://maps.google.com/?q=" + mLatitude+","+ mLongitude, null, null);
				/*sm.sendTextMessage(v1.elementAt(i),null,"Please help me. I am at My Location Coordiantes are"+" http://maps.google.com/?q=" + mLatitude+","+ mLongitude +","+address+","+city+
				","+country, null, null);*/
				}
			}
		});
		
	}
}
