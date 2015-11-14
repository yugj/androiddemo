package com.yugj.test.androiddemo.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.yugj.test.androiddemo.R;

public class Intent2 extends Activity {
	
	private TextView textView1 = null;
	private TextView textView2 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
	
	

}
