package com.quickapp.emergencyaid;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        
        
        Thread thread = new Thread()
		{
		    @Override
		    public void run() {
		        try {
		        	sleep(1100);
		            startActivity(new Intent(getApplication(),Main.class));
		            overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
		            } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		};
		thread.start();
    }
}
