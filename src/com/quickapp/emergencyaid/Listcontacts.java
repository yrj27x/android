package com.quickapp.emergencyaid;

import java.util.Vector;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Listcontacts extends ArrayAdapter<String> {
	
	
	private final Activity context;
	private final Vector<String> name;
	private final Vector<String> number;
	

	public Listcontacts(Activity context, Vector<String> s1,Vector<String> s2) {
		super(context, R.layout.activity_listcontacts,s1);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.name=s1;
		this.number=s2;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		LayoutInflater inflater = context.getLayoutInflater();
		View rowView = inflater.inflate(R.layout.activity_listcontacts, null, true);
		TextView txtTitle = (TextView) rowView.findViewById(R.id.textView1);
		TextView txtTitle1 = (TextView) rowView.findViewById(R.id.textView2);
		txtTitle.setText(name.elementAt(position));
		txtTitle1.setText(number.elementAt(position));
		return rowView;
	}
	
	

  
}
