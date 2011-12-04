package com.lostandfound;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReportFoundActivity extends CustomActivity implements View.OnClickListener{
	EditText foundlocation, item, date, time, picklocation, email, phone, description;
	Button submit;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.found);
		initializeVars();
		submit.setOnClickListener(this);
	}
	
	private void initializeVars(){
		foundlocation = (EditText)findViewById(R.id.edfoundlocation);
		item = (EditText) findViewById(R.id.editem);
		date = (EditText) findViewById(R.id.eddate);
		time = (EditText) findViewById(R.id.edtime);
		picklocation = (EditText) findViewById(R.id.edpickuplocation);
		email = (EditText) findViewById(R.id.edemail);
		phone = (EditText) findViewById(R.id.edphone);
		description = (EditText)findViewById(R.id.eddescription);
		submit = (Button) findViewById(R.id.submit);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
