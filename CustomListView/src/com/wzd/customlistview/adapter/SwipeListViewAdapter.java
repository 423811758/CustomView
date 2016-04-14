package com.wzd.customlistview.adapter;

import java.util.ArrayList;
import java.util.List;

import com.wzd.customlistview.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class SwipeListViewAdapter extends BaseAdapter {

	private List<String> strList = new ArrayList<String>();

	private Context context;
	private LayoutInflater mInflater;

	public SwipeListViewAdapter(List<String> strList, Context context) {
		super();
		this.strList = strList;
		this.context = context;
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return strList.size();
	}

	@Override
	public Object getItem(int position) {
		return strList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater
					.inflate(R.layout.item_swipe_list_view, null);
			holder = new ViewHolder();
			holder.totalView = (View) convertView
					.findViewById(R.id.message_list_item_total_view);
			holder.strTv = (TextView) convertView.findViewById(R.id.str_tv);
			holder.deleteView = (View) convertView
					.findViewById(R.id.message_list_item_delete_view);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		LinearLayout.LayoutParams lp1 = new LayoutParams(
				LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		holder.totalView.setLayoutParams(lp1);
		LinearLayout.LayoutParams lp2 = new LayoutParams(dip2px(context, 60),
				LayoutParams.MATCH_PARENT);
		holder.deleteView.setLayoutParams(lp2);
		holder.strTv.setText(strList.get(position));
		return convertView;
	}

	class ViewHolder {
		public View totalView;
		TextView strTv;
		public View deleteView;
	}

	public void addAll(List<String> data) {
		if (data != null && data.size() > 0) {
			synchronized (strList) {
				strList.addAll(data);
			}
		}
	}

	public void refresh(List<String> data) {
		synchronized (strList) {
			strList.clear();
			if (data != null && data.size() > 0) {
				strList.addAll(data);
			}
		}
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

}
