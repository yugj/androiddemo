package com.yugj.test.androiddemo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.yugj.test.androiddemo.R;

public class ActivityLifeCycle extends Activity {
	
	private TextView textView1 = null;
	private TextView textView2 = null;
	private Button button = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		System.out.println("activity life cycle 1 ---> onCreate ");
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent1_layout);
		
		textView1 = (TextView)findViewById(R.id.intent1TextView1);
		textView2 = (TextView)findViewById(R.id.intent1TextView2);
		
		
		textView1.setText("intent 1 tw 1");
		textView2.setText("intent 1 tw 2");
		
		button = (Button)findViewById(R.id.intent1Button1);
		
		button.setOnClickListener(new MyButtonListener());
		
	}
	
	class MyButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ActivityLifeCycle.this, ActivityLifeCycle2.class);
			
			intent.putExtra("tw1", textView1.getText());
			intent.putExtra("tw2", textView2.getText());
			
			startActivity(intent);
			
		} 
		
	}

	@Override
	protected void onStart() {
		System.out.println("activity life cycle 1 ---> onStart ");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		System.out.println("activity life cycle 1 ---> onRestart ");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		System.out.println("activity life cycle 1 ---> onResume ");
		super.onResume();
	}

	@Override
	protected void onPause() {
		System.out.println("activity life cycle 1 ---> onPause ");
		super.onPause();
	}

	@Override
	protected void onStop() {
		System.out.println("activity life cycle 1 ---> onStop ");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		System.out.println("activity life cycle 1 ---> onDestroy ");
		super.onDestroy();
	}
	
	
	

}
