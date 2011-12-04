package com.lostandfound;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class CustomActivity extends Activity {
private static String TAG = "CustomActivity";
	
	/** called when the activity is first made*/
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	public SharedPreferences getPreferences() {
		LostFoundApp app = (LostFoundApp)getApplication();
		return app.getPreferences();
	}
}
