package com.quickapp.emergencyaid;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class Templet2 extends Activity {
	TextView txt1,txt2,txt3;
	String uri="";
	 VideoView vv;
	 Button callambu3;
	 AlertDialog.Builder alertDialogBuilder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_templet2);
		 vv = (VideoView)this.findViewById(R.id.videoView2);
			txt1=(TextView) findViewById(R.id.text12);	
			txt2=(TextView) findViewById(R.id.text22);	
			txt3=(TextView) findViewById(R.id.text33);	
			callambu3=(Button) findViewById(R.id.callambu3);
			
		      alertDialogBuilder = new AlertDialog.Builder(this);
			callambu3.setOnClickListener(new OnClickListener() {
				
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
