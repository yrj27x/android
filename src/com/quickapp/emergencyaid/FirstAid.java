package com.quickapp.emergencyaid;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FirstAid extends Activity {
	ListView frstaid;
	
	String[] itemname ={
			"Allergies/anaphylaxis",
			"Asthma attack",
			"Bleeding",
			"Broken Bone",
			"Burns",
			"Choking",
			"Diabetic emergency",
			"Distress",
			"Head injury",
			"Heart Attack",
			"Heart stroke",
			"Hypothermia",
			"Meningitis",
			"Poisoning/harmful substance",
			"Seizure/epilepsy",
			"Stings/bites",
			"Strains and sprains",
			"Stroke",
			"Unconscious"
		};
	
	Integer[] imgid={
			R.drawable.allergy,
			R.drawable.asthma,
			R.drawable.bleeding,
			R.drawable.broken_bone,
			R.drawable.burns,
			R.drawable.choking,
			R.drawable.diabetes,
			R.drawable.distress,
			R.drawable.head_injury,
			R.drawable.heart_attack,
			R.drawable.severeheat,
			R.drawable.severecold,
			R.drawable.meningitis,
			R.drawable.poison,
			R.drawable.seizure,
			R.drawable.stings_bites,
			R.drawable.sprain,
			R.drawable.stroke,
			R.drawable.unconc	
	};

Button callam;
AlertDialog.Builder alertDialogBuilder;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_aid);
		frstaid=(ListView) findViewById(R.id.listViewfirsaid);
		CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
		frstaid.setAdapter(adapter);
		alertDialogBuilder = new AlertDialog.Builder(this);
		callam=(Button) findViewById(R.id.callambu1);
		callam.setOnClickListener(new OnClickListener() {
			
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
		
		
		
		frstaid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
if (position==0) {
					
startActivity(new Intent(getApplicationContext(), Allergies.class));
}
if (position==1) 
{
					
startActivity(new Intent(getApplicationContext(), Asthma_attack.class));
}
if (position==2) 
{
					
startActivity(new Intent(getApplicationContext(), Bleeding.class));
}	
if (position==3) 
{
					
startActivity(new Intent(getApplicationContext(), Broken_bone.class));
}	
if (position==4) 
{
					
startActivity(new Intent(getApplicationContext(), Burns.class));
}	
if (position==5) 
{
					
startActivity(new Intent(getApplicationContext(), Choking.class));
}	
if (position==6) 
{
					
startActivity(new Intent(getApplicationContext(), Diabetic.class));
}	
if (position==7) 
{
					
startActivity(new Intent(getApplicationContext(), Distress.class));
}	
if (position==8) 
{
					
startActivity(new Intent(getApplicationContext(), Head_injury.class));
}	
if (position==9) 
{
					
startActivity(new Intent(getApplicationContext(), Heart_attack.class));
}	
if (position==10) 
{
					
startActivity(new Intent(getApplicationContext(), Heat_stroke.class));
}	
if (position==11) 
{
					
startActivity(new Intent(getApplicationContext(), Hypothermia.class));
}	
if (position==12) 
{
					
startActivity(new Intent(getApplicationContext(), Meningitis.class));
}	
if (position==13) 
{
					
startActivity(new Intent(getApplicationContext(), Poisoning.class));
}	
if (position==14) 
{
					
startActivity(new Intent(getApplicationContext(), Seizure.class));
}	
if (position==15) 
{
					
startActivity(new Intent(getApplicationContext(), Stings.class));
}	
if (position==16) 
{
					
startActivity(new Intent(getApplicationContext(), Strains.class));
}	
if (position==17) 
{
					
startActivity(new Intent(getApplicationContext(), Stroke.class));
}	
if (position==18) 
{
					
startActivity(new Intent(getApplicationContext(), Unconscious1.class));
}	
	
	
				
			}
		});
		
		
	}
}
