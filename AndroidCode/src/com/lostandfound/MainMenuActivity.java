package com.lostandfound;

import android.os.Bundle;

/**
 * The MainMenuActivity.
 */
public class MainMenuActivity extends CustomActivity {
    public static final String TAG = "MainMenuActivity";
    
    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState the saved instance state
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
        
        Log.d(TAG, "Creating main menu activity");
    }
}