package com.lostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class ReportFoundActivity extends CustomActivity implements View.OnClickListener{
	private static final String TAG = "ReportFoundActivity";
	
	EditText foundlocation, item, picklocation, email, phone, description;
	DatePicker date;
	TimePicker time;
	Button submit;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.found);
		initializeVars();
		submit.setOnClickListener(this);
	}
	
	/** sets up the global variables so we can use them*/
	private void initializeVars(){
		//assign all of the fields on the screen to a variable for use
		foundlocation = (EditText)findViewById(R.id.edfoundlocation);
		item = (EditText) findViewById(R.id.editem);
		date = (DatePicker) findViewById(R.id.eddate);
		time = (TimePicker) findViewById(R.id.edtime);
		picklocation = (EditText) findViewById(R.id.edpickuplocation);
		email = (EditText) findViewById(R.id.edemail);
		phone = (EditText) findViewById(R.id.edphone);
		description = (EditText)findViewById(R.id.eddescription);
		submit = (Button) findViewById(R.id.submit);
	}

	public void onClick(View v) {
		// TODO pull the data from the fields and send it to the server	
	}

}
