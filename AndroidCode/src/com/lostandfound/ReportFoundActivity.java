package com.lostandfound;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class ReportFoundActivity extends CustomActivity implements View.OnClickListener{
	private static final String TAG = "ReportFoundActivity";
	
	EditText foundlocation, item, picklocation, email, phone, description;
	DatePicker date;
	TimePicker time;
	Button submit;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.found);
		initializeVars();
		submit.setOnClickListener(this);
	}
	
	/** sets up the global variables so we can use them*/
	private void initializeVars(){
		//assign all of the fields on the screen to a variable for use
		foundlocation = (EditText)findViewById(R.id.edfoundlocation);
		item = (EditText) findViewById(R.id.editem);
		date = (DatePicker) findViewById(R.id.eddate);
		picklocation = (EditText) findViewById(R.id.edpickuplocation);
		email = (EditText) findViewById(R.id.edemail);
		phone = (EditText) findViewById(R.id.edphone);
		description = (EditText)findViewById(R.id.eddescription);
		submit = (Button) findViewById(R.id.submit);
	}

	public void onClick(View v) {
		// set up needed variables	
		String URL = "http://gtmob.matthewpinkston.com/post.php";
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(URL);
		
		//convert the date into a string
		String dateString = null;
		dateString = date.getMonth() + "/" + date.getDayOfMonth() + "/" + date.getYear();
		
		//make the list to send over to the server
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("foundlocation", foundlocation.getText().toString()));
		pairs.add(new BasicNameValuePair("item", item.getText().toString()));
		pairs.add(new BasicNameValuePair("date", dateString));
		pairs.add(new BasicNameValuePair("picklocation", picklocation.getText().toString()));
		pairs.add(new BasicNameValuePair("email", email.getText().toString()));
		pairs.add(new BasicNameValuePair("phone", phone.getText().toString()));
		pairs.add(new BasicNameValuePair("description", description.getText().toString()));
		
		try{
			post.setEntity(new UrlEncodedFormEntity(pairs));
			client.execute(post);
		}catch(UnsupportedEncodingException e){
			Log.e(TAG, e.getMessage());
		} catch (ClientProtocolException e) {
			Log.e(TAG, e.getMessage());
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
	}

}
