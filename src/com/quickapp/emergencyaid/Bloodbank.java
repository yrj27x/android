package com.quickapp.emergencyaid;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.android.gms.internal.dd;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressLint("WorldReadableFiles") public class Bloodbank extends Activity {
	
	AssetManager assetManager;
    InputStream in;
    OutputStream out;
    File file;
    byte[] buffer;
    Intent intent;
    int read;
    
    /////////*****************BLOOD BANK NAME PDF START*************/////////////////////
    String andhra_Pradesh="blood_banks_ap.pdf";
    String arunachal_Pradesh="blood_banks_arp.pdf";
    String andaman_and_Nicobar_Island="blood_banks_an.pdf";
    String assam="blood_banks_assam.pdf";
    String bihar="blood_bank_bihar.pdf";
    String chandigarh="blood_bank_chd.pdf";
    String chhattisgarh="blood_bank_chhattis.pdf";
    String dadra_and_Nagar_Haveli="blood_bank_ddrngr.pdf";
    String daman_and_Diu="blood_bank_dandd.pdf";
    String delhi_NCR="delhi_blood_bank.pdf";
    String goa="blood_bank_goa.pdf";
    String gujarat="blood_bank_gujrat.pdf";
    String haryana="blood_bank_haryana.pdf";
    String himachal_Pradesh="blood_bank_hp.pdf";
    String jammu_Kashmir="blood_bank_jandk.pdf";
    String jharkhand="blood_bank_jandk.pdf";
    String karnataka="blood_bank_karnatak.pdf";
    String kerala="blood_bank_kerala.pdf";
    String madhya_Pradesh="blood_bank_mp.pdf";
    String maharashtra="blood_bank_maha.pdf";
    String manipur="blood_bank_manipur.pdf";
    String meghalaya="blood_bank_meghalaya.pdf";
    String mizoram="blood_bank_mizoram.pdf";
    String nagaland="blood_bank_nagaland.pdf";
    String orissa="blood_bank_orissa.pdf";
    String punjab="blood_bank_punjab.pdf";
    String puducherry="blood_bank_pondicherry.pdf";
    String rajasthan="blood_bank_rajstn.pdf";
    String sikkim="blood_bank_sikkim.pdf";
    String tamil_Nadu="blood_bank_tamil.pdf";
    String tripura="blood_bank_tripura.pdf";
    String uttar_Pradesh="blood_bank_up.pdf";
    String uttarakhand="blood_bank_uk.pdf";
    String west_Bengal="blood_bank_wb.pdf"; 
    /////////////*****************BLOOD BANK NAME PDF END************//////////
    
ListView bbplace;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bloodbank);
		
		
		assetManager = getAssets();
        in = null;
        out = null;
        //////////*********LISTVIEW OF BLOOD BANK'S*******/////////////
		bbplace =(ListView) findViewById(R.id.listViewbbplace);
		
		  String[] values = new String[] { "Andhra Pradesh","Arunachal Pradesh","Andaman and Nicobar Island","Assam","Bihar","Chandigarh","Chhattisgarh",
				  							"Dadra and Nagar Haveli","Daman and Diu","Delhi NCR","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir",
				  							"Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya",
				  							"Mizoram","Nagaland","Orissa","Punjab","Puducherry","Rajasthan","Sikkim","Tamil Nadu","Tripura","Uttar Pradesh","Uttarakhand","West Bengal" };
		  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	      android.R.layout.simple_list_item_1, android.R.id.text1, values);
		  bbplace.setAdapter(adapter); 
		  
		  /////////////********************/////////END*******LV*********/////////
		  
		  ////////************BLOOD BANK START***************////////////////////
		  bbplace.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				if(position==0)
				{
					ap_blood_bank();
				}
				if(position==1)
				{
					arp_blood_bank();
				}
				if(position==2)
				{
					ann_blood_bank();
				}
				if(position==3)
				{
					assam_blood_bank();
				}
				if(position==4)
				{
					bihar_blood_bank();
				}
				if(position==5)
				{
					chd_blood_bank();
				}
				if(position==6)
				{
					chhtis_blood_bank();
				}
				if(position==7)
				{
					dnnr_blood_bank();
				}
				if(position==8)
				{
					dnd_blood_bank();
				}
				if(position==10)
				{
					ngoa_blood_bank();
				}
				if(position==9)
				{
					Delhibloodbank();
				}
				if(position==11)
				{
					guj_blood_bank();
				}
				if(position==12)
				{
					har_blood_bank();
				}
				if(position==13)
				{
					hp_blood_bank();
				}
				if(position==14)
				{
					jnk_blood_bank();
				}
				if(position==15)
				{
					jhrd_blood_bank();
				}
				if(position==16)
				{
					krntk_blood_bank();
				}
				if(position==17)
				{
					krla_blood_bank();
				}
				if(position==18)
				{
					mp_blood_bank();
				}
				if(position==19)
				{
					maha_blood_bank();
				}
				if(position==20)
				{
					mani_blood_bank();
				}
				if(position==21)
				{
					megha_blood_bank();
				}
				if(position==22)
				{
					mizo_blood_bank();
				}
				if(position==23)
				{
					naga_blood_bank();
				}
				if(position==24)
				{
					ori_blood_bank();
				}
				if(position==25)
				{
					pun_blood_bank();
				}
				if(position==26)
				{
					pund_blood_bank();
				}
				if(position==27)
				{
					raj_blood_bank();
				}
				if(position==28)
				{
					siki_blood_bank();
				}
				if(position==29)
				{
					tamil_blood_bank();
				}
				if(position==30)
				{
					tri_blood_bank();
				}
				if(position==31)
				{
					up_blood_bank();
				}
				if(position==32)
				{
					uk_blood_bank();
				}
				if(position==33)
				{
					wb_blood_bank();
				}
				
			}

//////////***************************AP******************//////////////////
			private void ap_blood_bank() {
				// TODO Auto-generated method stub
				 file = new File(getFilesDir(), andhra_Pradesh);
			        try
			        {
			            in = assetManager.open(andhra_Pradesh);
			            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

			            copyFile(in, out);
			            in.close();
			            in = null;
			            out.flush();
			            out.close();
			            out = null;
			        } catch (Exception e)
			        {
			            Log.e("tag", e.getMessage());
			        }

			        intent = new Intent(Intent.ACTION_VIEW);
			        intent.setDataAndType(
			                Uri.parse("file://" + getFilesDir() + "/"+andhra_Pradesh),
			                "application/pdf");
			        startActivity(intent);
			}
//////////////////*******************AP END****************//////////////////	
			
	//////////***************************ARUNP******************//////////////////
	private void arp_blood_bank() {
	// TODO Auto-generated method stub
	file = new File(getFilesDir(), arunachal_Pradesh);
	try
	{
	in = assetManager.open(arunachal_Pradesh);
	out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);
	copyFile(in, out);
	in.close();
	in = null;
	out.flush();
	out.close();
	out = null;
	} catch (Exception e)
	{
	Log.e("tag", e.getMessage());
	}
	intent = new Intent(Intent.ACTION_VIEW);
	intent.setDataAndType(Uri.parse("file://" + getFilesDir() + "/"+arunachal_Pradesh),"application/pdf");
	startActivity(intent);
				}
	//////////////////*******************ARUNP END****************//////////////////
				
		//////////***************************A & N******************//////////////////
				private void ann_blood_bank() {
					// TODO Auto-generated method stub
					 file = new File(getFilesDir(), andaman_and_Nicobar_Island);
				        try
				        {
				            in = assetManager.open(andaman_and_Nicobar_Island);
				            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

				            copyFile(in, out);
				            in.close();
				            in = null;
				            out.flush();
				            out.close();
				            out = null;
				        } catch (Exception e)
				        {
				            Log.e("tag", e.getMessage());
				        }

				        intent = new Intent(Intent.ACTION_VIEW);
				        intent.setDataAndType(
				                Uri.parse("file://" + getFilesDir() + "/"+andaman_and_Nicobar_Island),
				                "application/pdf");
				        startActivity(intent);
				}
	//////////////////*******************A & N END****************//////////////////
				
		//////////***************************BIHAR******************//////////////////
				private void bihar_blood_bank() {
					// TODO Auto-generated method stub
					 file = new File(getFilesDir(), bihar);
				        try
				        {
				            in = assetManager.open(bihar);
				            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

				            copyFile(in, out);
				            in.close();
				            in = null;
				            out.flush();
				            out.close();
				            out = null;
				        } catch (Exception e)
				        {
				            Log.e("tag", e.getMessage());
				        }

				        intent = new Intent(Intent.ACTION_VIEW);
				        intent.setDataAndType(
				                Uri.parse("file://" + getFilesDir() + "/"+bihar),
				                "application/pdf");
				        startActivity(intent);
				}
	//////////////////*******************BIHAR END****************//////////////////
				
		//////////***************************ASSAM******************//////////////////
				private void assam_blood_bank() {
					// TODO Auto-generated method stub
					 file = new File(getFilesDir(), assam);
				        try
				        {
				            in = assetManager.open(assam);
				            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

				            copyFile(in, out);
				            in.close();
				            in = null;
				            out.flush();
				            out.close();
				            out = null;
				        } catch (Exception e)
				        {
				            Log.e("tag", e.getMessage());
				        }

				        intent = new Intent(Intent.ACTION_VIEW);
				        intent.setDataAndType(
				                Uri.parse("file://" + getFilesDir() + "/"+assam),
				                "application/pdf");
				        startActivity(intent);
				}
	//////////////////*******************ASSAM END****************//////////////////
				
		//////////***************************CHANDIGADH******************//////////////////
				private void chd_blood_bank() {
					// TODO Auto-generated method stub
					 file = new File(getFilesDir(), chandigarh);
				        try
				        {
				            in = assetManager.open(chandigarh);
				            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

				            copyFile(in, out);
				            in.close();
				            in = null;
				            out.flush();
				            out.close();
				            out = null;
				        } catch (Exception e)
				        {
				            Log.e("tag", e.getMessage());
				        }

				        intent = new Intent(Intent.ACTION_VIEW);
				        intent.setDataAndType(
				                Uri.parse("file://" + getFilesDir() + "/"+chandigarh),
				                "application/pdf");
				        startActivity(intent);
				}
	//////////////////*******************CHANDIGADH END****************//////////////////
				
		/////////***************************CHHATTISGARH******************//////////////////
						private void chhtis_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), chhattisgarh);
						        try
						        {
						            in = assetManager.open(chhattisgarh);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+chhattisgarh),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************CHATTISGARH END****************//////////////////
						
				
		//////////***************************DAADAR AND NAGAR******************//////////////////
				private void dnnr_blood_bank() {
					// TODO Auto-generated method stub
					 file = new File(getFilesDir(), dadra_and_Nagar_Haveli);
				        try
				        {
				            in = assetManager.open(dadra_and_Nagar_Haveli);
				            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

				            copyFile(in, out);
				            in.close();
				            in = null;
				            out.flush();
				            out.close();
				            out = null;
				        } catch (Exception e)
				        {
				            Log.e("tag", e.getMessage());
				        }

				        intent = new Intent(Intent.ACTION_VIEW);
				        intent.setDataAndType(
				                Uri.parse("file://" + getFilesDir() + "/"+dadra_and_Nagar_Haveli),
				                "application/pdf");
				        startActivity(intent);
				}
	//////////////////*******************DADDAR AND NAGAR END****************//////////////////
				
		//////////***************************DAMAN AND DIU******************//////////////////
				private void dnd_blood_bank() {
					// TODO Auto-generated method stub
					 file = new File(getFilesDir(), daman_and_Diu);
				        try
				        {
				            in = assetManager.open(daman_and_Diu);
				            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

				            copyFile(in, out);
				            in.close();
				            in = null;
				            out.flush();
				            out.close();
				            out = null;
				        } catch (Exception e)
				        {
				            Log.e("tag", e.getMessage());
				        }

				        intent = new Intent(Intent.ACTION_VIEW);
				        intent.setDataAndType(
				                Uri.parse("file://" + getFilesDir() + "/"+daman_and_Diu),
				                "application/pdf");
				        startActivity(intent);
				}
	//////////////////*******************DAMAN AND DIU END****************//////////////////
				

//////////////////***************DEL*****************///////////////////
			@SuppressWarnings("deprecation")
			private void Delhibloodbank() {
				// TODO Auto-generated method stub
				
		        file = new File(getFilesDir(), delhi_NCR);
		        try
		        {
		            in = assetManager.open(delhi_NCR);
		            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

		            copyFile(in, out);
		            in.close();
		            in = null;
		            out.flush();
		            out.close();
		            out = null;
		        } catch (Exception e)
		        {
		            Log.e("tag", e.getMessage());
		        }

		        intent = new Intent(Intent.ACTION_VIEW);
		        intent.setDataAndType(
		                Uri.parse("file://" + getFilesDir() + "/"+delhi_NCR),
		                "application/pdf");
		        startActivity(intent);
			}
/////////**********************DEL END****************/////////////
	//////////*****************************GOA****************//////////////////
				private void ngoa_blood_bank() {
					// TODO Auto-generated method stub
					 file = new File(getFilesDir(), goa);
				        try
				        {
				            in = assetManager.open(goa);
				            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

				            copyFile(in, out);
				            in.close();
				            in = null;
				            out.flush();
				            out.close();
				            out = null;
				        } catch (Exception e)
				        {
				            Log.e("tag", e.getMessage());
				        }

				        intent = new Intent(Intent.ACTION_VIEW);
				        intent.setDataAndType(
				                Uri.parse("file://" + getFilesDir() + "/"+goa),
				                "application/pdf");
				        startActivity(intent);
				}
	//////////////////*******************GOA END****************//////////////////	
		//////////*****************************GUJRAT****************//////////////////
						private void guj_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), gujarat);
						        try
						        {
						            in = assetManager.open(gujarat);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+gujarat),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************GUJRAT END****************//////////////////	
				//////////*****************************HARYANA****************//////////////////
						private void har_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), haryana);
						        try
						        {
						            in = assetManager.open(haryana);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+haryana),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************HARYANA END****************//////////////////	
				//////////*****************************HP****************//////////////////
						private void hp_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), himachal_Pradesh);
						        try
						        {
						            in = assetManager.open(himachal_Pradesh);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+himachal_Pradesh),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************HP END****************//////////////////
				//////////*****************************J & K****************//////////////////
						private void jnk_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), jammu_Kashmir);
						        try
						        {
						            in = assetManager.open(jammu_Kashmir);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+jammu_Kashmir),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************J & K END****************//////////////////	
				//////////*****************************JHARKHAND****************//////////////////
						private void jhrd_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), jharkhand);
						        try
						        {
						            in = assetManager.open(jharkhand);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+jharkhand),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************JHARKHAND END****************//////////////////
				//////////*****************************KARNATAKA****************//////////////////
						private void krntk_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), karnataka);
						        try
						        {
						            in = assetManager.open(karnataka);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+karnataka),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************KARNATAKA END****************//////////////////
				//////////*****************************KERALA****************//////////////////
						private void krla_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), kerala);
						        try
						        {
						            in = assetManager.open(kerala);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+kerala),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************KERALA END****************//////////////////	
				//////////*****************************MP****************//////////////////
						private void mp_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), madhya_Pradesh);
						        try
						        {
						            in = assetManager.open(madhya_Pradesh);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+madhya_Pradesh),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************MP END****************//////////////////	
				//////////*****************************MAHARASTRA****************//////////////////
						private void maha_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), maharashtra);
						        try
						        {
						            in = assetManager.open(maharashtra);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+maharashtra),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************MAHARASTRA END****************//////////////////	
						
				//////////*****************************MANIPUR***************//////////////////
						private void mani_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), manipur);
						        try
						        {
						            in = assetManager.open(manipur);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+manipur),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************MANIPUR END****************//////////////////	
				//////////*****************************MEGHALAYA****************//////////////////
						private void megha_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), meghalaya);
						        try
						        {
						            in = assetManager.open(meghalaya);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+meghalaya),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************MEGHALAYA END****************//////////////////	
				//////////*****************************MIZORAM****************//////////////////
						private void mizo_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), mizoram);
						        try
						        {
						            in = assetManager.open(mizoram);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+mizoram),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************MIZORAM END****************//////////////////	
				//////////*****************************NAGALAND****************//////////////////
						private void naga_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), nagaland);
						        try
						        {
						            in = assetManager.open(nagaland);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+nagaland),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************NAGALAND END****************//////////////////	
				//////////*****************************ORISSA****************//////////////////
						private void ori_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), orissa);
						        try
						        {
						            in = assetManager.open(orissa);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+orissa),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************ORRISA END****************//////////////////	
				//////////*****************************PUNJAB****************//////////////////
						private void pun_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), punjab);
						        try
						        {
						            in = assetManager.open(punjab);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+punjab),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************PUNJAB END****************//////////////////	
				//////////*****************************PUNDUCHARRY****************//////////////////
						private void pund_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), puducherry);
						        try
						        {
						            in = assetManager.open(puducherry);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+puducherry),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************PUNDUCHERRY END****************//////////////////	
				//////////*****************************RAJSTAN****************//////////////////
						private void raj_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), rajasthan);
						        try
						        {
						            in = assetManager.open(rajasthan);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+rajasthan),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************RAJSTAN END****************//////////////////	
				//////////*****************************SIKKIM****************//////////////////
						private void siki_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), sikkim);
						        try
						        {
						            in = assetManager.open(sikkim);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+sikkim),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************SIKKM END****************//////////////////	
				//////////*****************************TAMIL****************//////////////////
						private void tamil_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), tamil_Nadu);
						        try
						        {
						            in = assetManager.open(tamil_Nadu);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+tamil_Nadu),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************TAMIL END****************//////////////////	
						
				//////////*****************************TRIPURA****************//////////////////
						private void tri_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), tripura);
						        try
						        {
						            in = assetManager.open(tripura);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+tripura),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************TRIPURA END****************//////////////////	
				//////////*****************************UP****************//////////////////
						private void up_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), uttar_Pradesh);
						        try
						        {
						            in = assetManager.open(uttar_Pradesh);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+uttar_Pradesh),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************UP END****************//////////////////	
				//////////*****************************UK****************//////////////////
						private void uk_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), uttarakhand);
						        try
						        {
						            in = assetManager.open(uttarakhand);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+uttarakhand),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************UK END****************//////////////////
				//////////*****************************WB****************//////////////////
						private void wb_blood_bank() {
							// TODO Auto-generated method stub
							 file = new File(getFilesDir(), west_Bengal);
						        try
						        {
						            in = assetManager.open(west_Bengal);
						            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

						            copyFile(in, out);
						            in.close();
						            in = null;
						            out.flush();
						            out.close();
						            out = null;
						        } catch (Exception e)
						        {
						            Log.e("tag", e.getMessage());
						        }

						        intent = new Intent(Intent.ACTION_VIEW);
						        intent.setDataAndType(
						                Uri.parse("file://" + getFilesDir() + "/"+west_Bengal),
						                "application/pdf");
						        startActivity(intent);
						}
			//////////////////*******************WB END****************//////////////////	
			
			
			
			
			
			
			
			
			
			
			
			
			private void copyFile(InputStream in, OutputStream out) throws IOException {
				// TODO Auto-generated method stub
				buffer = new byte[1024];
		 
		        while ((read = in.read(buffer)) != -1)
		        {
		            out.write(buffer, 0, read);
		        }
			}
		});
		  
		  ///////////////////////*****************BLOOD BANK END*************////////////////
	}
}
				
			