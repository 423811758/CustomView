package com.wzd.widget;

import com.wzd.clearedittext.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

public class ClearEditText extends EditText implements OnFocusChangeListener,
		TextWatcher {

	/** 右侧删除按钮 */
	private Drawable clearDrawable;

	public ClearEditText(Context context) {
		this(context, null);
	}

	public ClearEditText(Context context, AttributeSet attrs) {
		this(context, attrs, android.R.attr.editTextStyle);
	}

	public ClearEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		clearDrawable = getCompoundDrawables()[2];
		if (clearDrawable == null) {
			clearDrawable = getResources().getDrawable(
					R.drawable.search_clear_pressed);
		}
		clearDrawable.setBounds(0, 0, clearDrawable.getIntrinsicWidth(),
				clearDrawable.getIntrinsicHeight());
		setClearIconVisible(false);
		setOnFocusChangeListener(this);
		addTextChangedListener(this);
	}

	/**
	 * 设置右侧删除按钮显示或隐藏
	 * 
	 * @param visible
	 */
	private void setClearIconVisible(boolean visible) {
		Drawable right = visible ? clearDrawable : null;
		// 刷新view
		setCompoundDrawables(getCompoundDrawables()[0],
				getCompoundDrawables()[1], right, getCompoundDrawables()[3]);

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (getCompoundDrawables()[2] != null) {
			if (event.getAction() == MotionEvent.ACTION_UP) {
				// 判断点击的位置是否是删除按钮
				boolean touchable = ((event.getX() > (getWidth()
						- getPaddingRight() - clearDrawable.getIntrinsicWidth())) && (event
						.getX() < (getWidth() - getPaddingRight())));
				if (touchable) {
					setText("");
				}
			}
		}
		return super.onTouchEvent(event);
	}

	@Override
	public void onFocusChange(View view, boolean hasFocus) {
		if (hasFocus) {
			setClearIconVisible(getText().length() > 0);
		} else {
			setClearIconVisible(false);
		}
	}

	@Override
	public void afterTextChanged(Editable arg0) {
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int count, int after) {
		setClearIconVisible(s.length() > 0);
	}

}
