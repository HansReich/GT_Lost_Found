package com.lostandfound;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SearchResultsActivity extends ListActivity{
	private static final String TAG = "SearchResultsActivity";
	HttpClient client;
	JSONObject json;
	String sLocation, sDate, sItem;
	
	final static String URL = "http://gtmob.matthewpinkston.com/test.php";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//set the theme of the activity
		setTheme(R.style.MainTheme);
		
		//set up the list adapter

		//set up the list view
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		
		Log.d(TAG, "creating search results");
		
		//get the values from search
		sLocation = getIntent().getStringExtra(Common.LOCATION_KEY);
		sDate = getIntent().getStringExtra(Common.DATE_KEY);
		sItem = getIntent().getStringExtra(Common.ITEM_KEY);
	}
	
	public void lastlostfound(String username)throws ClientProtocolException, IOException, JSONException{
		//necessary variables
		String desc, phone, email, pickup, date, item, location;
		HttpClient client = new DefaultHttpClient(); 
		HttpGet get = new HttpGet(URL);
		
		//poll the database
		HttpResponse r = client.execute(get);
		
		//check if it worked
		int status = r.getStatusLine().getStatusCode();
		if(status == 200){
			//convert the response into json
			HttpEntity e = r.getEntity();
			String data = EntityUtils.toString(e);
			JSONArray jArray = new JSONArray(data);
			
			//sort out the different items
			LostItem[] items = new LostItem[jArray.length()];
			for(int i=0; i<jArray.length(); i++){
				if(jArray.isNull(i) == false){
					JSONObject json = jArray.getJSONObject(i);
					desc = json.getString("des");
					phone = json.getString("phone");
					email = json.getString("email");
					pickup = json.getString("pickup");
					date = json.getString("day");
					item = json.getString("item");
					location = json.getString("location");
				}
			}
		} else {
			Toast.makeText(SearchResultsActivity.this, "error", Toast.LENGTH_LONG).show();
		}
	}

}
