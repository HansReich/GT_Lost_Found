package com.lostandfound;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

/**
 * The Class Lost.
 */
public class SearchLostActivity extends CustomActivity implements View.OnClickListener{
	
	/** The lostlocation. */
	EditText lostlocation;
	/** The lostItem. */
	EditText lostitem;
	/** The lostdate. */
	DatePicker lostdate;
	
	/** The button for executing query. */
	Button query;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lost);
		initializeVars();
		query.setOnClickListener(this);
	}
	
	/**
	 * Initialize variables.
	 */
	private void initializeVars(){
		lostlocation = (EditText)findViewById(R.id.edlostlocation);
		lostitem = (EditText) findViewById(R.id.edlostitem);
		lostdate = (DatePicker) findViewById(R.id.eddate);
		query = (Button) findViewById(R.id.search);
	}


	public void onClick(View v) {
		Intent ourIntent = new Intent(SearchLostActivity.this, SearchResultsActivity.class);
		
		//gather the values
		String itemString = lostitem.getText().toString();
		String dateString = lostdate.getMonth() + "/" + lostdate.getDayOfMonth() + "/" + lostdate.getYear();
		String loc = lostlocation.getText().toString();
		
		//add the values gathered to the intent
		ourIntent.putExtra(Common.ITEM_KEY, itemString);
		ourIntent.putExtra(Common.DATE_KEY, dateString);
		ourIntent.putExtra(Common.LOCATION_KEY, loc);
		
		startActivity(ourIntent);
	}

}
