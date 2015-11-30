package com.yugj.test.androiddemo.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.yugj.test.androiddemo.R;
import com.yugj.test.androiddemo.S;

public class SqliteActivity extends Activity {
	
	Button create = null;
	Button upgrade = null;
	Button insert = null;
	Button update = null;
	Button show = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqlite_activity_layout);
		
		create = (Button)findViewById(R.id.oncreate);
		upgrade = (Button)findViewById(R.id.onupgrade);
		insert = (Button)findViewById(R.id.insert);
		update = (Button)findViewById(R.id.update);
		show = (Button)findViewById(R.id.show);
		
		
		create.setOnClickListener(new CreateListener());
		upgrade.setOnClickListener(new UpgradeListener());
		insert.setOnClickListener(new InsertListener());
		update.setOnClickListener(new UpdateListener());
		show.setOnClickListener(new ShowListener());
		
	}
	
	class CreateListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			DatabaseHelper db = new DatabaseHelper(SqliteActivity.this, "yugj_db", null, 1);
			db.getReadableDatabase();
		}
		
	}
	class UpdateListener implements OnClickListener {
		
		@Override
		public void onClick(View v) {
			DatabaseHelper db = new DatabaseHelper(SqliteActivity.this, "yugj_db", null, 2);
			db.getReadableDatabase();
			
		}
		
	}
	class UpgradeListener implements OnClickListener {
		
		@Override
		public void onClick(View v) {
			DatabaseHelper db = new DatabaseHelper(SqliteActivity.this, "yugj_db", null, 2);
			db.getReadableDatabase();
			
		}
		
	}
	class InsertListener implements OnClickListener {
		
		@Override
		public void onClick(View v) {
			ContentValues values = new ContentValues();
			values.put("id", 1);
			values.put("name", "hell");
			
			DatabaseHelper db = new DatabaseHelper(SqliteActivity.this, "yugj_db", null, 2);
			SQLiteDatabase writableDatabase = db.getWritableDatabase();
			
			writableDatabase.insert("user", null, values);
			
		}
		
	}
	class ShowListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			DatabaseHelper db = new DatabaseHelper(SqliteActivity.this, "yugj_db", null, 2);
			SQLiteDatabase reDatabase = db.getReadableDatabase();
			
			Cursor cursor = reDatabase.query("user",new String[]{"id","name"},"id=?",new String[]{"1"},null,null,null);
			while (cursor.moveToNext()) {
				String name = cursor.getString(cursor.getColumnIndex("name"));
				Integer id = cursor.getInt(cursor.getColumnIndex("id"));
				Log.d(S.tag,"query--> id:" + id + " name:" + name);
			}
			
		}
		
	}

}
