package com.quickapp.emergencyaid;






import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.hardware.Sensor;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.widget.Button;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class Service extends android.app.Service implements SensorListener
{
	
SensorManager sm;
Sensor msensor;
private static final int SHAKE_THRESHOLD = 3500;

private float x, y ,z;
private long lastUpdate = 0;
private float last_x, last_y, last_z;

@Override
public IBinder onBind(Intent intent) {
// TODO Auto-generated method stub
return null;
}

@Override
public int onStartCommand(Intent intent, int flags, int startId) {
// TODO Auto-generated method stub

sm = (SensorManager) getSystemService(SENSOR_SERVICE);
sm.registerListener(this, SensorManager.SENSOR_ACCELEROMETER,
		SensorManager.SENSOR_DELAY_GAME);
return android.app.Service.START_STICKY;


}

@Override
public void onCreate() {
// TODO Auto-generated method stub

super.onCreate();
}

@Override
public void onDestroy() {
// TODO Auto-generated method stub
super.onDestroy();
}

@Override
public void onAccuracyChanged(int sensor, int accuracy) {
// TODO Auto-generated method stub

}

@Override
public void onSensorChanged(int sensor, float[] values) {
	



if (sensor == SensorManager.SENSOR_ACCELEROMETER) {
	
	x = values[SensorManager.DATA_X];
	y = values[SensorManager.DATA_Y];
	z = values[SensorManager.DATA_Z];

	
	long curTime = System.currentTimeMillis();
	if ((curTime - lastUpdate) > 100) {
        long diffTime = (curTime - lastUpdate);
        lastUpdate = curTime;
        float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;
	if (speed > SHAKE_THRESHOLD) 
	{
		Vibrator mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		mVibrator.vibrate(300);
		
		try
		{
		//Toast.makeText(this, "shake speed : " + speed,
		//Toast.LENGTH_SHORT).show();
		//Intent i = new Intent(getApplicationContext(), SendSms.class);
		//i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		//startActivity(i);
		Intent i = new Intent(getApplicationContext(), PanicButton.class);
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(i);
		}
		catch(Exception e)
		{
			Toast.makeText(this, " " + e,
			Toast.LENGTH_SHORT).show();
		}
		
	}
	last_x = x;
    last_y = y;
    last_z = z;
	}
}

}


}
