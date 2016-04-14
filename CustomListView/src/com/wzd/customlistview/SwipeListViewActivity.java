package com.wzd.customlistview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.wzd.customlistview.adapter.SwipeListViewAdapter;
import com.zzy.common.widget.swipelistview.SwipeListView;

public class SwipeListViewActivity extends Activity {

	private SwipeListView mSwipeListView;
	private List<String> strList = new ArrayList<String>();
	private SwipeListViewAdapter mSwipeListViewAdapter;

	public static void startSwipeListViewActivity(Context context) {
		Intent intent = new Intent(context, SwipeListViewActivity.class);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_swipe_list_view);

		mSwipeListView = (SwipeListView) findViewById(R.id.swipe_list_view);
		mSwipeListView.setRightViewWidth(dip2px(this, 60));

		mSwipeListViewAdapter = new SwipeListViewAdapter(strList, this);
		mSwipeListView.setAdapter(mSwipeListViewAdapter);

		testData();
	}

	private void testData() {
		mSwipeListView.postDelayed(new Runnable() {

			@Override
			public void run() {
				strList = new ArrayList<String>();
				for (int i = 0; i < 30; i++) {
					strList.add("item : " + i);
				}
				mSwipeListViewAdapter.addAll(strList);
				mSwipeListViewAdapter.notifyDataSetChanged();
			}
		}, 1000);

	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}
}
