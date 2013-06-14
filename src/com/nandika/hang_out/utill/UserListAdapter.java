package com.nandika.hang_out.utill;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.nandika.hang_out.domain.UserDao;

public class UserListAdapter extends ArrayAdapter<UserDao>{

	private List<UserDao> friends;
	private Context context;

	
	public UserListAdapter(Context context,int textViewResourceId, List<UserDao> friends) {
		
		
		super(context, textViewResourceId, friends);

		this.context = context;
		this.friends = friends;
	}

}
