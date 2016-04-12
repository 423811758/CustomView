package com.wzd.customlistview.adapter;

import java.util.ArrayList;
import java.util.List;

import com.wzd.customlistview.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SimpleXListViewAdapter extends BaseAdapter {

	private List<String> strList = new ArrayList<String>();

	private Context context;
	private LayoutInflater mInflater;

	public SimpleXListViewAdapter(List<String> strList, Context context) {
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
			convertView = mInflater.inflate(R.layout.item_simple_x_list_view,
					null);
			holder = new ViewHolder();
			holder.strTv = (TextView) convertView.findViewById(R.id.str_tv);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.strTv.setText(strList.get(position));
		return convertView;
	}

	class ViewHolder {
		TextView strTv;
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

}
