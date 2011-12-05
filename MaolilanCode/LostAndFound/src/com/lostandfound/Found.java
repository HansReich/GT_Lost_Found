package com.lostandfound;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Found extends Activity implements View.OnClickListener{
	EditText foundlocation, item, date, picklocation, email, phone, description;
	Button submit;
	//final static String URL = "http://gtmob.matthewpinkston.com/test.php";
	final static String URL = "http://gtmob.matthewpinkston.com/post.php";
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.found);
		initializeVars();
		//Insertion();
		submit.setOnClickListener(this);
	}
	
	private void initializeVars(){
		foundlocation = (EditText)findViewById(R.id.edfoundlocation);
		item = (EditText) findViewById(R.id.editem);
		date = (EditText) findViewById(R.id.eddate);
		//time = (EditText) findViewById(R.id.edtime);
		picklocation = (EditText) findViewById(R.id.edpickuplocation);
		email = (EditText) findViewById(R.id.edemail);
		phone = (EditText) findViewById(R.id.edphone);
		description = (EditText)findViewById(R.id.eddescription);
		submit = (Button) findViewById(R.id.submit);
	}
	
	private void SubmitInfo() throws UnsupportedEncodingException, ClientProtocolException, IOException{
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(URL);
		
		List<NameValuePair> pairs = new ArrayList<NameValuePair>();
		pairs.add(new BasicNameValuePair("foundlocation", foundlocation.getText().toString()));
		pairs.add(new BasicNameValuePair("item", item.getText().toString()));
		pairs.add(new BasicNameValuePair("date", date.getText().toString()));
		pairs.add(new BasicNameValuePair("picklocation", picklocation.getText().toString()));
		pairs.add(new BasicNameValuePair("email", email.getText().toString()));
		pairs.add(new BasicNameValuePair("phone", phone.getText().toString()));
		pairs.add(new BasicNameValuePair("description", description.getText().toString()));
		try{
		post.setEntity(new UrlEncodedFormEntity(pairs));
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		try{
		HttpResponse response = client.execute(post);
		}catch(ClientProtocolException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try {
			SubmitInfo();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try{
			Class ourClass = Class.forName("com.lostandfound.Submit");
			Intent ourIntent = new Intent(Found.this, ourClass);
			startActivity(ourIntent);
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}		
	}

}
