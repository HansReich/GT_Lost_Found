package com.lostandfound;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Found extends Activity implements View.OnClickListener{
	EditText foundlocation, item, date, picklocation, email, phone, description;
	Button submit;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.found);
		initializeVars();
		//Insertion();
		submit.setOnClickListener(this);
	}
	
	private void initializeVars(){
		foundlocation = (EditText)findViewById(R.id.edfoundlocation);
		item = (EditText) findViewById(R.id.editem);
		date = (EditText) findViewById(R.id.eddate);
		//time = (EditText) findViewById(R.id.edtime);
		picklocation = (EditText) findViewById(R.id.edpickuplocation);
		email = (EditText) findViewById(R.id.edemail);
		phone = (EditText) findViewById(R.id.edphone);
		description = (EditText)findViewById(R.id.eddescription);
		submit = (Button) findViewById(R.id.submit);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try{
			Class ourClass = Class.forName("com.lostandfound.Submit");
			Intent ourIntent = new Intent(Found.this, ourClass);
			startActivity(ourIntent);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}		
	}

}
