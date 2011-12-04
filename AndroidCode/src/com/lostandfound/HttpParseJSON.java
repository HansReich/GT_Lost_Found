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

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HttpParseJSON extends Activity{
	TextView httpStuff;
	HttpClient client;
	JSONObject json;
	
	final static String URL = "http://gtmob.matthewpinkston.com/test.php";
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.http);
		httpStuff = (TextView)findViewById(R.id.httpinfo);
		client = new DefaultHttpClient();
		new Read().execute("publicdes");
	}
		public JSONObject lastlostfound(String username)throws ClientProtocolException, IOException, JSONException{
			StringBuilder url = new StringBuilder(URL);
			url.append(username);
			
			HttpGet get = new HttpGet(url.toString());
			HttpResponse r = client.execute(get);
			int status = r.getStatusLine().getStatusCode();
			if(status == 200){
				HttpEntity e = r.getEntity();
				String data = EntityUtils.toString(e);
				JSONArray timeline = new JSONArray(data);
				JSONObject last = timeline.getJSONObject(0);
				return last;
			}else{
				Toast.makeText(HttpParseJSON.this, "error", Toast.LENGTH_LONG);
				return null;
			}
		}
		
		public class Read extends AsyncTask<String, Integer, String>{

			@Override
			protected String doInBackground(String... arg0) {
				// TODO Auto-generated method stub
				try {
					json = lastlostfound("");
					return json.getString(arg0[0]);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}

			/* (non-Javadoc)
			 * @see android.os.AsyncTask#onPostExecute(java.lang.Object)
			 */
			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				//super.onPostExecute(result);
				httpStuff.setText(result);
			}
		}

	}


