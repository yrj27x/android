package com.quickapp.emergencyaid;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class Unconsciousno extends Activity {
	TextView t1,t2,t3,t4;
	ImageView unconani2;
	VideoView vv;
	String uri="";
    Button callambu6;
	 AlertDialog.Builder alertDialogBuilder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unconsciousno);
		t1=(TextView) findViewById(R.id.textunno1);
		t2=(TextView) findViewById(R.id.textunno2);
		t3=(TextView) findViewById(R.id.textunno3);
		t4=(TextView) findViewById(R.id.textunno4);
		unconani2=(ImageView) findViewById(R.id.unconanim2);
		unconani2.setBackgroundResource(R.drawable.unconanim2);
	    vv = (VideoView)this.findViewById(R.id.videoView5);
		uri = "android.resource://" + getPackageName() + "/" + R.raw.unconscious;
		vv.setVideoURI(Uri.parse(uri));
		 vv.start();
		AnimationDrawable anim = (AnimationDrawable) unconani2.getBackground();
		anim.start();
		
		t1.setText("Call Ambulance as soon as possible, or get someone else to do it.");
		t2.setText("Push firmly downwards in the middle of the chest and than release.");
		t3.setText("Push at a rate of 100 compressions pre minute, until help arrives.");
		t4.setText("Let the chest rise completely before pushing down again.");
		
		callambu6=(Button) findViewById(R.id.callambu6);
		alertDialogBuilder = new AlertDialog.Builder(this);
		
		callambu6.setOnClickListener(new OnClickListener() {
			
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
	}
}
