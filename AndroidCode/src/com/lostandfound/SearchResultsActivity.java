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

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultsActivity extends CustomActivity{
	private static final String TAG = "SearchResultsActivity";
	HttpClient client;
	JSONObject json;
	
	final static String URL = "http://gtmob.matthewpinkston.com/test.php";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchresults);
		Log.d(TAG, "creating search results");
	}
	
	public void lastlostfound(String username)throws ClientProtocolException, IOException, JSONException{
		StringBuilder url = new StringBuilder(URL);
		url.append(username);
		
		HttpClient client = new DefaultHttpClient(); 
		HttpGet get = new HttpGet(url.toString());
		HttpResponse r = client.execute(get);
		int status = r.getStatusLine().getStatusCode();
		if(status == 200){
			HttpEntity e = r.getEntity();
			String data = EntityUtils.toString(e);
			JSONArray timeline = new JSONArray(data);
			for(int i=0; i<timeline.length();i++){
				if(timeline.isNull(i) == false){
					JSONObject item = timeline.getJSONObject(i);
					String pubdes = item.getString("publicdes");
					String phone = item.getString("phone");
					String email = item.getString("email");
					String pickup = item.getString("pickup");
				}
			}
		} else {
			Toast.makeText(SearchResultsActivity.this, "error", Toast.LENGTH_LONG).show();
		}
	}

}
