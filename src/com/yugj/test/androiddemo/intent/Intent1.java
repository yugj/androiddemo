package com.yugj.test.androiddemo.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.yugj.test.androiddemo.R;

public class Intent1 extends Activity {
	private TextView textView1 = null;
	private TextView textView2 = null;
	private Button button = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
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
			intent.setClass(Intent1.this, Intent2.class);
			
			intent.putExtra("tw1", textView1.getText());
			intent.putExtra("tw2", textView2.getText());
			
			startActivity(intent);
			
		} 
		
	}
	
	

}
