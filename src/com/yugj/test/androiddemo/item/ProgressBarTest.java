package com.yugj.test.androiddemo.item;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

import com.yugj.test.androiddemo.R;
import com.yugj.test.androiddemo.S;

public class ProgressBarTest extends Activity {
	
    private ProgressBar mProgress;
    private ProgressBar mProgress2;
    private int mProgressStatus = 0;
    private Button button;

    private Handler mHandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbar_test_layout);
		
		mProgress = (ProgressBar) findViewById(R.id.progress_bar);
		mProgress2 = (ProgressBar) findViewById(R.id.progress_bar2);
		button = (Button) findViewById(R.id.button);
		mProgress.setMax(300);
		
		button.setOnClickListener(new MyButtonListener());
		
		// Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus < mProgress.getMax()) {
                    try {
						mProgressStatus = doWork();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            mProgress.setProgress(mProgressStatus);
                            mProgress.setSecondaryProgress(mProgressStatus + 10);
                        }
                    });
                }
            }

			private int doWork() throws InterruptedException {
				Thread.sleep(1000L);
				return mProgressStatus + 10;
			}
        }).start();
        
        
		
	}
	
	class MyButtonListener implements OnClickListener {
		
		int i=0;

		@Override
		public void onClick(View v) {
			Log.i(S.tag,"click");
			if(i/2 == 0) {
				mProgress.setVisibility(View.VISIBLE);
				mProgress2.setVisibility(View.VISIBLE);
			} else {
				mProgress.setVisibility(View.INVISIBLE);
				mProgress2.setVisibility(View.INVISIBLE);
			}
			i++;
		} 
		
	}
	
	

}
