package com.nandika.hang_out.activity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nandika.hang_out.R;
import com.nandika.hang_out.domain.HangOutDTO;
import com.nandika.hang_out.domain.UserDao;
import com.nandika.hang_out.framwork.AbstractAsyncListActivity;

public class MainActivity extends AbstractAsyncListActivity {
	
	ArrayList<UserDao> data;
	private String friendListEndPoit="http://10.0.2.2:8080/hang-out/hangout";
	
	private static final String TAG = MainActivity.class.getSimpleName();


	ArrayAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onStart() {
	
		super.onStart();
		new LoadFriendsTask().execute(friendListEndPoit);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	private void showResult(List<HangOutDTO> hangouts) {
		HangoutListCustomAdapter adapter = new HangoutListCustomAdapter(this,R.layout.hangout_item, hangouts);
		setListAdapter(adapter);
	}
	
	class HangoutListCustomAdapter extends ArrayAdapter<HangOutDTO> {

		private Context context;
		private List<HangOutDTO> data;

		public HangoutListCustomAdapter(Context context, int textViewResourceId,
				List<HangOutDTO> data) {
			super(context, textViewResourceId, data);

			this.context = context;
			this.data = data;
		}



		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			View view;
			ViewHolder viewHolder;

			if (null == convertView) {

				LayoutInflater inflator = (LayoutInflater) context
						.getSystemService(LAYOUT_INFLATER_SERVICE);
				view = inflator.inflate(R.layout.hangout_item, null);

				viewHolder = new ViewHolder(view);
				view.setTag(viewHolder);


			} else {
				view = convertView;
				viewHolder = (ViewHolder) view.getTag();

			}


			viewHolder.name.setText(data.get(position).getName());
			viewHolder.time.setText(new Date( data.get(position).getHangOutTime()).toString());

			return view;

		}
	}

	class ViewHolder {
		ImageView profile;
		TextView name;
		TextView time;

		ViewHolder(View view) {
			name = (TextView) view.findViewById(R.id.txtHanoutName);
			time = (TextView) view.findViewById(R.id.hanOutTime);

		}

	}
	
	
	
	public void addToList(String response) {

		Log.d(getClass().getName(), "Done.. parsing data now..");

		

		JSONObject json = null;
		JSONArray jsonArry = null;

		try {
			json = new JSONObject(response);
			jsonArry = json.getJSONArray("hangouts");
			
		
		} catch (JSONException e) {
			e.printStackTrace();
		}

		List<HangOutDTO> hangouts = new ArrayList<HangOutDTO>();
		
		for (int i = 0; i < json.length(); i++) {
			JSONObject jsonObj;
			try {
				jsonObj = jsonArry.getJSONObject(i);
				String name = (String) jsonObj.get("name") ;
				Long hangoutTime = (Long) jsonObj.get("hangOutTime");
				//Log.d(TAG, "Disply Name: "+fname+ lname);
				
				HangOutDTO tempUser = new HangOutDTO();
				tempUser.setName(name);
				tempUser.setHangOutTime(hangoutTime);
				
				hangouts.add(tempUser);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		showResult(hangouts);

		
		
		

	}

	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		  switch (item.getItemId())
	        {
		  case R.id.main_search:
			  break;

		  case R.id.main_preferences:
			  
				Intent regActivityIntent = new Intent(this, HangOutSettingsActivity.class);
                startActivity(regActivityIntent);  
			  break;

		  case R.id.main_friends:
			  
				Intent friendActivityIntent = new Intent(this, FriendActivity.class);
                startActivity(friendActivityIntent);  
			  break;
		  case R.id.main_new:
			  
				Intent newHangActivityIntent = new Intent(this, NewHangOutActivity.class);
              startActivity(newHangActivityIntent);  
			  break;
		  case R.id.set_my_time:
			  
				Intent setTimeActivityIntent = new Intent(this, SetTimeActivity.class);
				startActivity(setTimeActivityIntent);  
			  break;
	        }

		
		return super.onOptionsItemSelected(item);
	}
	
		
	
	public class LoadFriendsTask extends AsyncTask<String, Void, String> {
	
		
	
		@Override
		protected String doInBackground(String... url) {
	
			HttpClient client = new DefaultHttpClient();
	
			Log.d(TAG,"url[0]: "+url[0]);
			HttpPost get = new HttpPost(url[0]);
			
			JSONObject reqestJSON = new JSONObject();
			try {
				reqestJSON.accumulate("email", "dnsw@gmai.com");
				
				StringEntity s = new StringEntity(reqestJSON.toString());
		        s.setContentEncoding("UTF-8");
		        s.setContentType("application/json");

		        get.setEntity(s);
		        get.addHeader("accept", "application/json");
				
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
	
			String response = null;
	
			try {
				response = client.execute(get, responseHandler);
				Log.d(TAG,"response:"+response);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			return response;
		}
	
		@Override
		protected void onPostExecute(String result) {
			addToList(result);
			super.onPostExecute(result);
		}
	}

}
