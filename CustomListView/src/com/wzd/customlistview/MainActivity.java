package com.wzd.customlistview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button mPullToRefresh;
	private Button mSwipeDelBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPullToRefresh = (Button) findViewById(R.id.pull_to_refresh_btn);
		mSwipeDelBtn = (Button) findViewById(R.id.swipe_del_btn);

		mPullToRefresh.setOnClickListener(this);
		mSwipeDelBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.pull_to_refresh_btn:
			PullToRefreshActivity.startPullToRefreshActivity(this);
			break;
		case R.id.swipe_del_btn:
			SwipeListViewActivity.startSwipeListViewActivity(this);
			break;
		default:
			break;
		}
	}

}
