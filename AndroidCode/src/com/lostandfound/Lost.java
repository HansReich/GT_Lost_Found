package com.lostandfound;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// TODO: Auto-generated Javadoc
/**
 * The Class Lost.
 */
public class Lost extends CustomActivity implements View.OnClickListener{
	
	/** The lostlocation. */
	EditText lostlocation;
	/** The lostItem. */
	EditText lostitem;
	/** The lostdate. */
	EditText lostdate;
	
	/** The button for executing query. */
	Button query;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
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
		lostdate = (EditText) findViewById(R.id.edlostdate);
		query = (Button) findViewById(R.id.qurey);
	}


	public void onClick(View v) {
		/*// TODO Auto-generated method stub
		try{
		Class ourClass = Class.forName("com.lostandfound.HttpParseJSON");
		Intent ourIntent = new Intent(ourClass);
		startActivity(ourIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}*/
	}

}
