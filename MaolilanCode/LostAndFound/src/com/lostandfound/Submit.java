package com.lostandfound;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Submit extends Activity{
	TextView tv;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit);
		tv = (TextView)findViewById(R.id.tvsubmit);
	}
}
