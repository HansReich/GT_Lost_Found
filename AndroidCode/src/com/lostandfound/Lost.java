package com.lostandfound;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Lost  extends Activity implements View.OnClickListener{
	EditText lostlocation, lostitem, lostdate;
	Button query;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lost);
		initializeVars();
		query.setOnClickListener(this);
	}
	
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
