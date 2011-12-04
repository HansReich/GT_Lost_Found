package com.lostandfound;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * The MainMenuActivity.
 */
public class MainMenuActivity extends CustomActivity {
    /** constants needed*/
    public static final String TAG = "MainMenuActivity";
    
    /** views on the screen*/
    Button reportFound, searchLost;
    
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
        
        //set up the button listeners
        reportFound = (Button) findViewById(R.id.FoundButton);
        searchLost = (Button) findViewById(R.id.LostButton);
        reportFound.setOnClickListener(myFoundListener);
        searchLost.setOnClickListener(myLostListener);
    }
    
    /** what to do when reportFound button is clicked*/
    private OnClickListener myFoundListener = new OnClickListener() {
        public void onClick(View v) {
            //TODO
        }
    };
    
    /** what to do when searchLost button is clicked*/
    private OnClickListener myLostListener = new OnClickListener() {
        public void onClick(View v) {
            //TODO
        }
    };
}