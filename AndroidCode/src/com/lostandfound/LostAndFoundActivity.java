package com.lostandfound;

import android.app.Activity;
import android.os.Bundle;


/**
 * The LostAndFoundActivity.
 */
public class LostAndFoundActivity extends Activity {
    
    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState the saved instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}