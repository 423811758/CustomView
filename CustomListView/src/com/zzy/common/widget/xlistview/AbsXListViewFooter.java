/**
 * @file XFooterView.java
 * @create Mar 31, 2012 9:33:43 PM
 * @author Maxwin
 * @description XListView's footer
 */
package com.zzy.common.widget.xlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public abstract class AbsXListViewFooter extends LinearLayout {
	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_LOADING = 2;

	public AbsXListViewFooter(Context context) {
		super(context);
		initView(context);
	}

	public AbsXListViewFooter(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public abstract void setState(int state);

	public abstract void setBottomMargin(int height);

	public abstract int getBottomMargin();

	/**
	 * hide footer when disable pull load more
	 */
	public abstract void hide();

	/**
	 * show footer
	 */
	public abstract void show();

	protected abstract void initView(Context context);

}
