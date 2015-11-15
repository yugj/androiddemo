package com.yugj.test.androiddemo.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.yugj.test.androiddemo.R;
import com.yugj.test.androiddemo.S;

public class ListViewTest extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview_test_layout);
		
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		HashMap<String, String> map3 = new HashMap<String, String>();
		
		map1.put("user_name", "yugj");
		map1.put("user_ip","192.168.1.1");
		map2.put("user_name", "yugj");
		map2.put("user_ip","192.168.1.1");
		map3.put("user_name", "yugj");
		map3.put("user_ip","192.168.1.1");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		SimpleAdapter adapter = new SimpleAdapter(ListViewTest.this,
				list,
				R.layout.listview_test_adapter, 
				new String[]{"user_name","user_ip"}, 
				new int[]{R.id.user_name,R.id.user_ip});
		
		setListAdapter(adapter);
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		Log.i(S.tag,"positiong:" + position);
		Log.i(S.tag,"id:" + id);
	}
	
	

}
