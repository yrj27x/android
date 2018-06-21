package com.quickapp.emergencyaid;



import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Unconscious1 extends Activity {
TextView t1,t2;
ImageView unconchge;
Button yes,no;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_templetuncon1);
		t1=(TextView) findViewById(R.id.text1unco);
		t2=(TextView) findViewById(R.id.text2unco);
		unconchge=(ImageView) findViewById(R.id.imageunconchange);
		unconchge.setBackgroundResource(R.drawable.unconanim);
		yes=(Button) findViewById(R.id.yesbtn);
		no=(Button) findViewById(R.id.nobtn);
		AnimationDrawable anim = (AnimationDrawable) unconchge.getBackground();
		anim.start();
		
		t1.setText("Check breathing by tilting their head backwards and looking and feeling for breaths.");
		t2.setText("Are they breathing?");
		
		yes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), Unconsciousyes.class));
			}
		});
		no.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(), Unconsciousno.class));
			}
		});
	}
}
