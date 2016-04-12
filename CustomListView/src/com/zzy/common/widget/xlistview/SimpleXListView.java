package com.zzy.common.widget.xlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

import com.wzd.customlistview.R;

public class SimpleXListView extends XListView {
	public SimpleXListView(Context context) {
		super(context);
	}

	public SimpleXListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SimpleXListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void initHeaderAndFooter(Context context) {
		mHeaderView = new SimpleXListViewHeader(context);
		mHeaderViewContent = (RelativeLayout) mHeaderView
				.findViewById(R.id.xlistview_header_content);
		addHeaderView(mHeaderView);
		// init header height
		mHeaderView.getViewTreeObserver().addOnGlobalLayoutListener(
				new OnGlobalLayoutListener() {
					@Override
					public void onGlobalLayout() {
						mHeaderViewHeight = mHeaderViewContent.getHeight();
						getViewTreeObserver()
								.removeGlobalOnLayoutListener(this);
					}
				});
		mFooterView = new XListViewFooter(context);
	}

	// @Override
	// protected void resetFooterHeight() {
	// if (super.mEnablePullLoad) {
	// super.resetFooterHeight();
	// }
	// }
	//
	// @Override
	// protected void updateFooterHeight(float delta) {
	// if (super.mEnablePullLoad) {
	// super.updateFooterHeight(delta);
	// }
	// }

}
