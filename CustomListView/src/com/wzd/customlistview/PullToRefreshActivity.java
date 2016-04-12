package com.wzd.customlistview;

import java.util.ArrayList;
import java.util.List;

import com.wzd.customlistview.adapter.SimpleXListViewAdapter;
import com.zzy.common.widget.xlistview.SimpleXListView;
import com.zzy.common.widget.xlistview.XListView.IXListViewListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * 下拉刷新
 * 
 * @author Administrator
 * 
 */
public class PullToRefreshActivity extends Activity implements
		IXListViewListener {

	private SimpleXListView mListView;
	private SimpleXListViewAdapter mSimpleXListViewAdapter;
	private List<String> strList = new ArrayList<String>();
	private boolean mRefreshing = false;
	private boolean mLoading = false;

	public static void startPullToRefreshActivity(Context context) {
		Intent intent = new Intent(context, PullToRefreshActivity.class);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pull_to_refresh);
		mListView = (SimpleXListView) findViewById(R.id.listview);

		mListView.setXListViewListener(this);
		mListView.setPullLoadEnable(true);
		mListView.setPullRefreshEnable(true);

		mSimpleXListViewAdapter = new SimpleXListViewAdapter(strList, this);
		mListView.setAdapter(mSimpleXListViewAdapter);
		testData();
		mRefreshing = true;
	}

	private void testData() {
		mListView.postDelayed(new Runnable() {

			@Override
			public void run() {
				strList = new ArrayList<String>();
				for (int i = 0; i < 10; i++) {
					strList.add("item : " + i);
				}
				if (mRefreshing) {
					mSimpleXListViewAdapter.refresh(strList);
				} else {
					mSimpleXListViewAdapter.addAll(strList);
				}
				refreshView();
			}
		}, 1000);

	}

	private void refreshView() {
		if (mRefreshing) {
			mRefreshing = false;
			mListView.stopRefresh();
		}
		if (mLoading) {
			mLoading = false;
			mListView.stopLoadMore();
		}
	}

	@Override
	public void onRefresh() {
		mRefreshing = true;
		testData();
	}

	@Override
	public void onLoadMore() {
		mLoading = true;
		testData();
	}
}
