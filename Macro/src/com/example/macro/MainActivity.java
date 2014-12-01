package com.example.macro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_layout);
	
		findViewById(R.id.startAppButton).setOnClickListener(this);
		findViewById(R.id.stopAppButton).setOnClickListener(this);
		findViewById(R.id.test).setOnClickListener(this);
		

	}
	
	public void onClick(View v){
		  int view = v.getId();
		  
	      if(view == R.id.startAppButton){
	    	  startService(new Intent(this, MacroService.class));    //서비스 시작  
	      } else if((view == R.id.stopAppButton)){
	    	  stopService(new Intent(this, MacroService.class));    //서비스 종료
	      }else{
	    	  System.out.println("test");
	      }
	          
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
