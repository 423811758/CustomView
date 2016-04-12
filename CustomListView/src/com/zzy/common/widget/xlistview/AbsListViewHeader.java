package com.zzy.common.widget.xlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * 下拉刷新控件头部抽象类
 * 
 * @author tian
 * 
 */
public abstract class AbsListViewHeader extends LinearLayout {

	protected int mState = STATE_NORMAL;

	// private final int ROTATE_ANIM_DURATION = 180;

	public final static int STATE_NORMAL = 0;
	public final static int STATE_READY = 1;
	public final static int STATE_REFRESHING = 2;

	public AbsListViewHeader(Context context) {
		super(context);
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public AbsListViewHeader(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public abstract void setState(int state);

	public abstract void setVisiableHeight(int height);

	public abstract int getVisiableHeight();

}
