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

public class HttpParseJSON extends CustomActivity{
	private static final String TAG = "HttpParseJSON";
	TextView httpStuff;
	ExpandableListView exListV;
	HttpClient client;
	JSONObject json;
	
	final static String URL = "http://gtmob.matthewpinkston.com/test.php";
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.searchresults);
		httpStuff = (TextView)findViewById(R.id.httpinfo);
		client = new DefaultHttpClient();
		try {
			this.lastlostfound("");
		} catch (ClientProtocolException e) {
			Log.e(TAG, e.getMessage());
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		} catch (JSONException e) {
			Log.e(TAG, e.getMessage());
		}
	}
	
	public void lastlostfound(String username)throws ClientProtocolException, IOException, JSONException{
		StringBuilder url = new StringBuilder(URL);
		url.append(username);
		
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
					httpStuff.append("item " + i + "\n");
					httpStuff.append("Description: ");
					httpStuff.append(pubdes);
					httpStuff.append("\n");
					httpStuff.append("Pick up Location: ");
					httpStuff.append(pickup);
					httpStuff.append("\n");
					httpStuff.append("Contact Information: \n Email Address: ");
					httpStuff.append(email);
					httpStuff.append("\n");
					httpStuff.append("Phone Number: ");
					httpStuff.append(phone);
					httpStuff.append("\n");
				}
			}
		} else {
			Toast.makeText(HttpParseJSON.this, "error", Toast.LENGTH_LONG).show();
		}
	}

	}
