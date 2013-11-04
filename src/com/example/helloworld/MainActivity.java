package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	public final static String TEST_MESSAGE = "com.example.myfirstapp.TESTMESSAGE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
		
		//getMenuInflater().inflate(R.menu.main, menu);
		//return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item ){
		//Handle presses on the action bar items
		switch (item.getItemId()){
			case R.id.action_search:
				openSearch();
				return true;
			
			case R. id.action_settings:
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void openSearch(){
		Toast.makeText(this, "Testing", Toast.LENGTH_LONG).show();
	}
	
	
	/** Called when the user clicks the send button */
	public void sendMessage(View view){
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		//intent.putExtra(TEST_MESSAGE, "Testing");
		

		
		
		startActivity(intent);
	}
	
	public void callNumber(View view){
		//Intent intent = new Intent(this, DisplayMessageActivity.class);
		
		Uri number = Uri.parse("tel:5551234");
		Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
		
		//EditText editText = (EditText) findViewById(R.id.edit_message);
		//String message = editText.getText().toString();
		//intent.putExtra(EXTRA_MESSAGE, message);
		//intent.putExtra(TEST_MESSAGE, "Testing");
		

		
		
		startActivity(callIntent);
	}

}
