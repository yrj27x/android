package com.quickapp.emergencyaid;

import java.util.ArrayList;
import java.util.Vector;


import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.BaseColumns;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Alertsms extends Activity {
	
	ListView lv;
	Button add;
	String aa;
	Listcontacts sb;
	Bundle b;
	String phone, name;
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "myDatabase5";
	String image_uri = "";
	ArrayList<String> list = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	int count;
	Vector<String> v ;
	Vector<String> vname;
	Vector<String> photo;
	DataBaseHelper handler;
	LinearLayout add_con;
	ToggleButton onoff;
	TextView alertsms,conts1,conts2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alert_sms);
		
		/*********************/////////////////*************//////////////
		
		onoff=(ToggleButton) findViewById(R.id.toggleButton1);
		onoff.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(isChecked==true)
				{
					
					/*showNotification();*/
					Toast.makeText(getApplicationContext(), "Shake Activate", Toast.LENGTH_SHORT).show();
					startService(new Intent(getApplicationContext(), Service.class));		
				}
				else
				{
					
					Toast.makeText(getApplicationContext(), "Shake Deactivate", Toast.LENGTH_SHORT).show();
					stopService(new Intent(getBaseContext(), Service.class));
					
				}
			}
		});
		
		
		///////////////****************************//////////////////
		
		conts1 =(TextView) findViewById(R.id.textconts);
		conts2 =(TextView) findViewById(R.id.textaddcontcs);
		alertsms =(TextView) findViewById(R.id.textalertsms);
		
		Typeface myf= Typeface.createFromAsset(getAssets(), "font3bold.ttf");
		alertsms.setTypeface(myf);
		conts1.setTypeface(myf);
		conts2.setTypeface(myf);
		
		
		
		
		add_con=(LinearLayout) findViewById(R.id.add_contacts);
		
		lv=(ListView) findViewById(R.id.contactlist);
		
		 v = new Vector<String>();
		 vname = new Vector<String>();
		
		try{
			Bundle b = getIntent().getExtras();
			int match = b.getInt("keylist");
			if (match == 1) {
				add_con.setVisibility(0);;
			}}catch(Exception e){
				}
		try {
			handler = new DataBaseHelper(this, DATABASE_NAME, null, DATABASE_VERSION);
			handler.getWritableDatabase();
			Cursor mCursor = handler.display();

			if (mCursor.moveToFirst()) {
				do {

					v.add(mCursor.getString(1).toString());

					vname.add(mCursor.getString(2).toString());

					
				} while (mCursor.moveToNext());
			}

			

			sb = new Listcontacts(Alertsms.this, v, vname);

			
			lv.setAdapter(sb);
		} catch (Exception e) {
		}
		add_con.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// registerForContextMenu(addContact);

				Intent intent = new Intent(Intent.ACTION_PICK,
						ContactsContract.Contacts.CONTENT_URI);
				startActivityForResult(intent, 1);

			}
		});
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), " DELETE " ,
						Toast.LENGTH_SHORT).show();

				handler.getWritableDatabase();
				handler.delete(v.elementAt(position).toString());
				Cursor mCursor = handler.display();
				if (mCursor.moveToFirst()) {
					do {
						Log.e("", "" + mCursor.getString(1).toString());
						v.add(mCursor.getString(1).toString());
						Log.e("", "" + mCursor.getString(2).toString());
						vname.add(mCursor.getString(2).toString());
						
					} while (mCursor.moveToNext());
				}
				Intent i = new Intent(getApplicationContext(), Alertsms.class);
				finish();
				startActivity(i);
				
			}
		});
      
		
	}
	
	///////////***************************Start********tgbtn st*******////////////////
	public static void setDefaults(String key, Boolean value, Context context)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
	
	public static Boolean getDefaults(String key, Context context)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, true);
    }

	@Override
	public void onStart(){
    super.onStart();
    onoff.setChecked(getDefaults("etatToggle",this));
	}

	@Override
	public void onStop(){
    super.onStop();
    setDefaults("etatToggle", onoff.isChecked(), this);
	}
	/////////////*************************save tgbtn st******END****//////////////////////////



	@SuppressWarnings("deprecation")
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
		if (requestCode == 1) {

			try {
				/*Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT)
						.show();*/

				Uri contact = data.getData();
				ContentResolver cr = getContentResolver();

				Cursor c = managedQuery(contact, null, null, null, null);
				// c.moveToFirst();

				while (c.moveToNext()) {
					String id = c.getString(c.getColumnIndex(BaseColumns._ID));

					
					name = c.getString(c
							.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
					if (Integer
							.parseInt(c.getString(c
									.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
						Cursor pCur = cr.query(Phone.CONTENT_URI, null,
								Phone.CONTACT_ID + " = ?", new String[] { id },
								null);

						while (pCur.moveToNext()) {
							phone = pCur.getString(pCur
									.getColumnIndex(Phone.NUMBER));
							Toast.makeText(getApplicationContext(), "ADD",
									Toast.LENGTH_SHORT).show();
							
							additamAtList(name, phone);

						}

					}
				}
			} catch (Exception e) {
				Intent i = new Intent(getApplicationContext(), Alertsms.class);
				finish();
				startActivity(i);
			}
		}
		
		
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	private void additamAtList(String name2, String phone2) {
		// TODO Auto-generated method stub
		adapter = null;
		v.clear();
		Toast.makeText(getApplicationContext(), " " + name+" : " + phone ,
				Toast.LENGTH_SHORT).show();
		DataBaseHelper handler = new DataBaseHelper(this, DATABASE_NAME, null,
				DATABASE_VERSION);
		handler.getWritableDatabase();
		handler.add(name, phone);
		Cursor mCursor = handler.display();

		if (mCursor.moveToFirst()) {
			do {
				Log.e("", "" + mCursor.getString(1).toString());
				v.add(mCursor.getString(1).toString());
				Log.e("", "" + mCursor.getString(2).toString());
				vname.add(mCursor.getString(2).toString());
				
			} while (mCursor.moveToNext());
		}

		Listcontacts sb = null;
		sb = new Listcontacts(this, v, vname);
		
		lv.setAdapter(sb);

		Intent i = new Intent(getApplicationContext(), Alertsms.class);
		finish();
		startActivity(i);
		
	}
	
}
