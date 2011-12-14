package com.lostandfound;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultsActivity extends ListActivity{
	private static final String TAG = "SearchResultsActivity";
	HttpClient client;
	JSONObject json;
	String sLocation, sDate, sItem;
	LostItem[] items;
	
	final static String URL = "http://gtmob.matthewpinkston.com/get1.php?";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//set the theme of the activity
		setTheme(R.style.MainTheme);
		
		//get the parameters from the intent
		String date = getIntent().getStringExtra(Common.DATE_KEY);
		String item = getIntent().getStringExtra(Common.ITEM_KEY);
		String loc = getIntent().getStringExtra(Common.LOCATION_KEY);
		
		//replace any spaces
		date = date.replace(" ", "%20");
		item = item.replace(" ", "%20");
		loc = loc.replace(" ", "%20");
		
		//send it to the database
		pullFromDatabase(item, date, loc);
		
		//set up the list adapter
		List<LostItem> itemsList = Arrays.asList(items);
		setListAdapter(new LostItemAdapter(SearchResultsActivity.this, R.layout.list_item, itemsList));

		//set up the list view
		ListView lv = getListView();
		lv.setTextFilterEnabled(true);
		
		Log.d(TAG, "creating search results");
		
		//get the values from search
		sLocation = getIntent().getStringExtra(Common.LOCATION_KEY);
		sDate = getIntent().getStringExtra(Common.DATE_KEY);
		sItem = getIntent().getStringExtra(Common.ITEM_KEY);
	}
	
	/** pull data from the database
	 * 
	 * @param item the name of the item type to be searched for
	 * @param date the date an item was lost on
	 * @param loc the location an item was lost
	 */
	public void pullFromDatabase(String itemName, String date, String location) {
		try {
			String url = URL;
			
			//tack on the search parameters if provided
			if(itemName != null) {
				url = url + "item=" + itemName;
			}
			if(date != null) {
				url = url + "&day=" + date;
			}
			if(location != null) {
				url = url + "&location=" + location;
			}
			
			//set up the http connection
			HttpClient client = new DefaultHttpClient(); 
			HttpGet get = new HttpGet(URL);
			
			//poll the database
			HttpResponse r;
			r = client.execute(get);
			
			//check if it worked
			int status = r.getStatusLine().getStatusCode();
			Log.d(TAG, "status code: " + status);
			if(status == 200){
				//convert the response into json
				HttpEntity e = r.getEntity();
				String data = EntityUtils.toString(e);
				JSONArray jArray = new JSONArray(data);
				
				Log.d(TAG, "jarray length: " + jArray.length());
				Log.d(TAG, "json data: " + data);
				
				//sort out the different items
				items = new LostItem[jArray.length()];
				String loc, item, day, des, email, phone, pickup;
				for(int i=0; i<jArray.length(); i++){
					if(jArray.isNull(i) == false){
						JSONObject json = jArray.getJSONObject(i);
						
						loc = json.getString("location");
						item = json.getString("item");
						day = json.getString("day");
						des = json.getString("des");
						email = json.getString("email");
						phone = String.valueOf(json.getInt("phone"));
						pickup = json.getString("pickup");
						
						items[i] = new LostItem(item, des, loc, day, email, phone, pickup);
					} else {
						Log.d(TAG, "jarray[" + i + "] was null");
					}
				}
			} else {
				Toast.makeText(SearchResultsActivity.this, "error", Toast.LENGTH_LONG).show();
			}
		} catch (ClientProtocolException e) {
			Log.e(TAG, e.getMessage());
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage());
		}	
	}

	/** adapter for adding locations to a list*/
	public class LostItemAdapter extends ArrayAdapter<LostItem> {
		int resource;
		List<LostItem> items;
		String response;
		Context ctx;
		
		//constructor
		public LostItemAdapter(Context context, int resource, List<LostItem> items) {
			super(context, resource, items);
			this.resource = resource;
			this.items = items;
		}
		
		public View getView(int position, View convertView, ViewGroup parent) {
			RelativeLayout itemView;
			
			//get current object
			LostItem item = items.get(position);
			
			//inflate the view
			if(convertView==null) {
				itemView = new RelativeLayout(getContext());
				String inflater = Context.LAYOUT_INFLATER_SERVICE;
				LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
				vi.inflate(resource,  itemView, true);
			} else {
				itemView = (RelativeLayout) convertView;
			}
			
			//get the text boxes from the list item
			TextView name = (TextView)itemView.findViewById(R.id.itemName);
			TextView loc = (TextView)itemView.findViewById(R.id.foundLoc);
			TextView date = (TextView)itemView.findViewById(R.id.foundDate);
			TextView phone = (TextView)itemView.findViewById(R.id.contactPhone);
			TextView email = (TextView)itemView.findViewById(R.id.contactEmail);
			TextView desc = (TextView)itemView.findViewById(R.id.itemDesc);
			
			Log.d(TAG, "name text: " + name);
			Log.d(TAG, "loc text: " + loc);
			
			//set the text
			name.setText(item.getItem());
			loc.setText(item.getFoundLocation());
			date.setText(item.getDateFound());
			phone.setText(item.getContactPhone());
			email.setText(item.getContactEmail());
			desc.setText(item.getDescription());
			
			return itemView;
		}
	}
}
