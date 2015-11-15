package com.yugj.test.androiddemo.activity;

import com.yugj.test.androiddemo.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityLifeCycle2 extends Activity {
	
	private TextView textView1 = null;
	private TextView textView2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("activity life cycle 2 ---> onCreate ");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent2_layout);
		
		textView1 = (TextView)findViewById(R.id.intent2TextView1);
		textView2 = (TextView)findViewById(R.id.intent2TextView2);
		
		Intent intent = getIntent();
		
		String tw1 = intent.getStringExtra("tw1");
		String tw2 = intent.getStringExtra("tw2");
		
		textView1.setText("from tw1 : " + tw1);
		textView2.setText("from tw2 : " + tw2);
		
	}

	@Override
	protected void onStart() {
		System.out.println("activity life cycle 2 ---> onStart ");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		System.out.println("activity life cycle 2 ---> onRestart ");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		System.out.println("activity life cycle 2 ---> onResume ");
		super.onResume();
	}

	@Override
	protected void onPause() {
		System.out.println("activity life cycle 2 ---> onPause ");
		super.onPause();
	}

	@Override
	protected void onStop() {
		System.out.println("activity life cycle 2 ---> onStop ");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		System.out.println("activity life cycle 2 ---> onDestroy ");
		super.onDestroy();
	}
	
	
	

}
