package com.nandika.hang_out.task;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class LoadFriendsTask extends AsyncTask<String, Void, String> {

	

	@Override
	protected String doInBackground(String... url) {

		HttpClient client = new DefaultHttpClient();

		HttpGet get = new HttpGet(url[0]);

		ResponseHandler<String> responseHandler = new BasicResponseHandler();

		String response = null;

		try {
			response = client.execute(get, responseHandler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}

	@Override
	protected void onPostExecute(String result) {
		//
		super.onPostExecute(result);
	}

}

