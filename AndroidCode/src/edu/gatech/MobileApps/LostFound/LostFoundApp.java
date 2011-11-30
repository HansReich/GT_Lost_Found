package edu.gatech.MobileApps.LostFound;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class LostFoundApp extends Application {
	private static String TAG = "LostFound App";
	/* The instance of this Application. */
	private static LostFoundApp instance; 
	
	/* The SharedPreferences provider that the application will use. */
	private SharedPreferences preferences;
	
	/* Set up our singleton. */
	@Override
	public void onCreate() {
		super.onCreate();
		Log.v(TAG, "ON CREATE");
		
		instance = this;
		preferences = getSharedPreferences(Common.MAIN_PREFERENCES,
				Context.MODE_PRIVATE);
	}
	
	public static LostFoundApp getInstance() {
		return instance;
	}
	
	public static void setInstance(LostFoundApp instance) {
		LostFoundApp.instance = instance;
	}

	public SharedPreferences getPreferences() {
		return preferences;
	}

	public void setPreferences(SharedPreferences preferences) {
		this.preferences = preferences;
	}
}
