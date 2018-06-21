package com.quickapp.emergencyaid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.json.JSONObject;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.Toast;

public class Map extends Activity {
	
	    public GoogleMap googleMap;
	  
	    LocationManager locationmanager;
	    LocationListener locationlistener;
	    
	    boolean zoomm=true;
	    Geocoder geocoder;
	    List<Address> addresses;
	    
	    String address;
	    String city;
	    String country;
	   
	    String mPlaceType;
	    String mPlaceTypeName;
	    
	    Spinner mSprPlaceType;
	    
	   
		double mLatitude=0;
		double mLongitude=0;
		
		AlertDialog.Builder alertDialogBuilder;

	@SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		mPlaceType="";
		mPlaceTypeName="";
		
		alertDialogBuilder = new AlertDialog.Builder(this);
		
		ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo ni=cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo niw=cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if(ni.isConnected()||niw.isConnected())
		{
			Toast.makeText(this, "Internet Available", Toast.LENGTH_SHORT).show();
		}
		else {
			getinternet();
		}
		
		
		
		 googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		 googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		 googleMap.setMyLocationEnabled(true);
		 
		 geocoder = new Geocoder(getApplicationContext(),Locale.getDefault());
		
		 locationmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		 
		 locationlistener = new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
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
			
			@Override
			public void onLocationChanged(Location location) {
				// TODO Auto-generated method stub
				
				mLatitude = location.getLatitude();
				mLongitude = location.getLongitude();
				
				 LatLng point = new LatLng(mLatitude, mLongitude);
				
				 try {
				    	addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
				    } catch (IOException e) {
				    	// TODO Auto-generated catch block
				    	e.printStackTrace();
				    }
				 MarkerOptions maker= new MarkerOptions().position(point);

				    address = addresses.get(0).getAddressLine(0);
				   if(address==null)
				   {
					   maker.title("My Location");
						googleMap.addMarker(maker);
				   }
				   else
				   {
					maker.title(""+address);
					googleMap.addMarker(maker);
				   }
				    
				     String type = mPlaceType;
			         StringBuilder sb = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
			         sb.append("location="+mLatitude+","+mLongitude);
			         sb.append("&radius=1500");
			         sb.append("&types="+type);
			         sb.append("&sensor=true");
			         sb.append("&key=AIzaSyAwZSGS1kZG7_UuqxqHH3MdO1hbwB2cjag");                               
			         PlacesTask placesTask = new PlacesTask();        
			         placesTask.execute(sb.toString());
			         
			         
			         if(zoomm)
			         {
			        	 googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(point, 15, 30, 0)));
			        	 zoomm=false;
			         }
				
			}
		};
		locationmanager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		locationmanager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0L, 100.0F, locationlistener);
		
	}
	private void getinternet() {
		// TODO Auto-generated method stub
		alertDialogBuilder.setTitle("Internet services disabled");
        alertDialogBuilder.setMessage("Nearby police station needs access to internet and gps. Please turn on internet & location access.")
 
        .setCancelable(false)
        .setPositiveButton("Ok",
                new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                startActivity(new Intent(getApplicationContext(),Main.class));
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
        
	}
    	/** A method to download json data from url */
        private String downloadUrl(String strUrl) throws IOException{
            String data = "";
            InputStream iStream = null;
            HttpURLConnection urlConnection = null;
            try{
                    URL url = new URL(strUrl);                
                    urlConnection = (HttpURLConnection) url.openConnection();                
                    urlConnection.connect();               
                    iStream = urlConnection.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
                    StringBuffer sb  = new StringBuffer();
                    String line = "";
                    while( ( line = br.readLine())  != null){
                            sb.append(line);
                    }
                    data = sb.toString();
                    br.close();

            }catch(Exception e){
                    Log.d("Exception while downloading url", e.toString());
            }finally{
                    iStream.close();
                    urlConnection.disconnect();
            }

            return data;
        }
        
    	
     	private class PlacesTask extends AsyncTask<String, Integer, String>{

    		String data = null;
    		@Override
    		protected String doInBackground(String... url) {
    			try{
    				data = downloadUrl(url[0]);
    			}catch(Exception e){
    				 Log.d("Background Task",e.toString());
    			}
    			return data;
    		}
    		
    		@Override
    		protected void onPostExecute(String result){			
    			ParserTask parserTask = new ParserTask();
    			parserTask.execute(result);
    		}
    		
    	}


    	class ParserTask extends AsyncTask<String, Integer, List<HashMap<String,String>>>{

    		JSONObject jObject;
    		
    		@Override
    		protected List<HashMap<String,String>> doInBackground(String... jsonData) {
    		
    			List<HashMap<String, String>> places = null;			
    			PlaceJSONParser placeJsonParser = new PlaceJSONParser();
            
    	        try{
    	        	jObject = new JSONObject(jsonData[0]);
    	        	
    	            /** Getting the parsed data as a List construct */
    	            places = placeJsonParser.parse(jObject);
    	            
    	        }catch(Exception e){
    	                Log.d("Exception",e.toString());
    	        }
    	        return places;
    		}
        
    		@Override
    		protected void onPostExecute(List<HashMap<String,String>> list){	
    			googleMap.clear();
    			for(int i=0;i<list.size();i++){
    				MarkerOptions markerOptions = new MarkerOptions();
    	            HashMap<String, String> hmPlace = list.get(i);
    	            double lat = Double.parseDouble(hmPlace.get("lat"));	             
    	            double lng = Double.parseDouble(hmPlace.get("lng"));	           	        
    	            String name = hmPlace.get("place_name");	         
    	            String vicinity = hmPlace.get("vicinity");	            
    	            LatLng latLng = new LatLng(lat, lng);
    	            markerOptions.position(latLng);
    	            markerOptions.title(name + " : " + vicinity);	            
    	            googleMap.addMarker(markerOptions);      
    	            
    			}		
    		}
    	}
}

