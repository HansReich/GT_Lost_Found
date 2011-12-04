package com.lostandfound;

import android.os.Bundle;

/**
 * The LostAndFoundActivity.
 */
public class LostAndFoundActivity extends CustomActivity {
    
    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState the saved instance state
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu);
    }
}