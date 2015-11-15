package com.yugj.test.androiddemo.item;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yugj.test.androiddemo.R;
import com.yugj.test.androiddemo.S;

public class RadioAndCheckboxTest extends Activity {
	
	private Button button = null;
	private RadioGroup radioGroup = null;
	private RadioButton radioButton = null;
	private RadioButton radioButton2 = null;
	private CheckBox checkBox = null;
	private CheckBox checkBox2 = null;
	private CheckBox checkBox3 = null;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.radio_checkbox_test_layout);
		radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
		radioButton = (RadioButton)findViewById(R.id.radioButton1);
		radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
		checkBox = (CheckBox)findViewById(R.id.checkbox1);
		checkBox2 = (CheckBox)findViewById(R.id.checkbox2);
		checkBox3 = (CheckBox)findViewById(R.id.checkbox3);
		
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(radioButton.getId() == checkedId) { 
					Toast.makeText(RadioAndCheckboxTest.this, "male", Toast.LENGTH_SHORT).show();
					Log.i(S.tag,"male");
				}
				if(radioButton2.getId() == checkedId) { 
					Toast.makeText(RadioAndCheckboxTest.this, "female", Toast.LENGTH_SHORT).show();
					Log.i(S.tag,"female");
				}
			}
		});
		
		checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(RadioAndCheckboxTest.this,buttonView.getText(), Toast.LENGTH_SHORT).show();
				Log.i(S.tag,"check box checked change");
			}
		});
		
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new MyButtonListener());
		
	}
	
	class MyButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int checkedId = radioGroup.getCheckedRadioButtonId();
			boolean checkboc = checkBox.isChecked();
			Log.i(S.tag,checkedId + "");
			Log.i(S.tag,checkboc + "");
		} 
		
	}

}
