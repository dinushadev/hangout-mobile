package com.nandika.hang_out.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.nandika.hang_out.R;

public class NewHangOutActivity extends Activity {

	private Button viewFriendListBt;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		
		setContentView(R.layout.activity_new_hang_out);
		
		viewFriendListBt =(Button) findViewById(R.id.addUserToHagOutBt);
		viewFriendListBt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent friendListActivityIntent = new Intent(NewHangOutActivity.this, FriendListActivity.class);
                startActivity(friendListActivityIntent);  
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_hang_out, menu);
		return true;
	}

}
