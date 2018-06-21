package com.quickapp.emergencyaid;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Templet1 extends Activity {
	/*ListView allergies;
	String[] values;
	ArrayAdapter<String> adapter;*/
		TextView txt1,txt2,txt3;
		String uri="";
		 VideoView vv;
		 MediaController mediaController;
		 Button callam2;
		 AlertDialog.Builder alertDialogBuilder;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_templet1);
	/*	values = new String[] { "Android List View", 
	            "Adapter implementation",
	            "Simple List View In Android",
	            "Create List View Android", 
	            "Android Example", 
	            "List View Source Code", 
	            "List View Array Adapter", 
	            "Android Example List View" 
		};
		allergies=(ListView) findViewById(R.id.allergielist);
		 adapter = new ArrayAdapter<String>(this,
	              android.R.layout.simple_list_item_1, android.R.id.text1, values);
		 allergies.setAdapter(adapter);*/
		 
		         vv = (VideoView)this.findViewById(R.id.videoView1);
				// uri = "android.resource://" + getPackageName() + "/" + R.raw.allergic;
		         
		    /*	 mediaController = new 
		    				MediaController(this);
		    			mediaController.setAnchorView(vv);
		    			vv.setMediaController(mediaController);
						*/
		         alertDialogBuilder = new AlertDialog.Builder(this);
						
						
				txt1=(TextView) findViewById(R.id.text1);	
				txt2=(TextView) findViewById(R.id.text2);	
				txt3=(TextView) findViewById(R.id.text3);
				
				callam2=(Button) findViewById(R.id.callambu2);
				callam2.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						alertDialogBuilder.setMessage("Call to Ambulance?")
						 
				        .setCancelable(false)
				  
				        .setPositiveButton("CALL",
				                new DialogInterface.OnClickListener(){
				            public void onClick(DialogInterface dialog, int id){
				            	Intent callIntent = new Intent(Intent.ACTION_CALL);
							    callIntent.setData(Uri.parse("tel:123456789"));
							    startActivity(callIntent);
				            }
				        });
				        alertDialogBuilder.setNegativeButton("CANCEL",
				                new DialogInterface.OnClickListener(){
				            public void onClick(DialogInterface dialog, int id){
				                dialog.cancel();
				            }
				        });
				        AlertDialog alert = alertDialogBuilder.create();
				        alert.show();
					}
				});
				
			//	txt1.setText("The person may develop a rash, itchiness or swelling o the body, feet or face. Their breathing may slow down.");
			//	txt2.setText("When observe these symoptoms, call ambulance.");
			//	txt3.setText("If the person has a known allergy and has ab auto-injector/Epi-pen, you can help them to use it. Give them constant reassurance while wating for the ambulance.");
	}
}
