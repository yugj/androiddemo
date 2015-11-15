package com.yugj.test.androiddemo.activity;

import com.yugj.test.androiddemo.R;
import com.yugj.test.androiddemo.activity.Activity1.MyButtonListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DialogActivity extends Activity {
	
	private Button button = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_activity_layout);
		button = (Button)findViewById(R.id.button1);
		button.setOnClickListener(new MyButtonListener());
	}
	
	class MyButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(DialogActivity.this, Activity1.class);
			startActivity(intent);
			finish();
		} 
		
	}

}
