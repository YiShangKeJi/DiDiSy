package com.ys.didisy.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import com.ys.didisy.R;

/**
 * 启动页
 */
public class StartActivity extends BaseActivity {
	private Runnable runnable;
	private Handler handler;
	private SharedPreferences preferences;
	private int useCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		init();
	}

	private void init() {
		preferences = getSharedPreferences("use", this.MODE_PRIVATE);
		useCount = preferences.getInt("count", 0);
		runnable = new Runnable() {

				@Override
				public void run() {
				if (useCount == 1) {
					Intent intent = new Intent(StartActivity.this,
							MainActivity.class);
					startActivity(intent);
				} else if (useCount == 0) {
					Intent intent = new Intent(StartActivity.this,
							GuideActivity.class);
					startActivity(intent);
				}
				finish();
			}
		};
		handler = new Handler();
		handler.postDelayed(runnable, 2000);
	}
}