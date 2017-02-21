package com.dy.mytopbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 作者： Dyan on 2017/2/21 16:24
 * 描述：
 */
public class Topbar extends RelativeLayout {
	private Button leftButton, rightButton;
	private TextView tvTitle;

	private int leftTextColor;
	private Drawable leftBackground;
	private String leftText;

	private int rightTextColor;
	private Drawable rightBackground;
	private String rightText;

	private float titleTextSize;
	private int titleTextColor;
	private String titleText;

	LayoutParams leftParams, rightParams, titleParams;

	public Topbar(final Context context, AttributeSet attrs) {
		super(context, attrs);
		//1、获得自定义属性
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
		leftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor, 0);
		leftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
		leftText = ta.getString(R.styleable.Topbar_leftText);

		rightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor, 0);
		rightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
		rightText = ta.getString(R.styleable.Topbar_rightText);

		titleTextSize = ta.getDimension(R.styleable.Topbar_titleTextSize, 0.0f);
		titleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
		titleText = ta.getString(R.styleable.Topbar_title);
		ta.recycle();

		//2、创建需要用的控件
		leftButton = new Button(context);
		rightButton = new Button(context);
		tvTitle = new TextView(context);
		//3、自定义属性赋值给对应的控件
		leftButton.setBackground(leftBackground);
		leftButton.setText(leftText);
		leftButton.setTextColor(leftTextColor);

		rightButton.setBackground(rightBackground);
		rightButton.setText(rightText);
		rightButton.setTextColor(rightTextColor);

		tvTitle.setTextSize(titleTextSize);
		tvTitle.setTextColor(titleTextColor);
		tvTitle.setText(titleText);
		tvTitle.setGravity(Gravity.CENTER);

		//4、设置整体topBar背景色
		setBackgroundColor(0xFFF59563);

		//5、把控件放到ViewGroup里面
		leftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		//左对齐
		leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
		leftParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
		//把leftButton以leftParams的形式添加的ViewGroup中
		addView(leftButton, leftParams);

		rightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		//右对齐
		rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
		rightParams.addRule(RelativeLayout.CENTER_VERTICAL, TRUE);
		//把rightButton以rightParams的形式添加的ViewGroup中
		addView(rightButton, rightParams);

		titleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		//右对齐
		titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
		//把titleButton以titleParams的形式添加的ViewGroup中
		addView(tvTitle, titleParams);

		//6、添加点击事件
		leftButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (mOnClickListener != null)
					mOnClickListener.onLeftClick();
				else
					Toast.makeText(context, "DY LEFT", Toast.LENGTH_SHORT).show();
			}
		});
		rightButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (mOnClickListener != null)
					mOnClickListener.onrightClick();
				else
					Toast.makeText(context, "DY RIGHT", Toast.LENGTH_SHORT).show();
			}
		});
	}

	public interface TopClickListener {
		void onLeftClick();

		void onrightClick();
	}

	TopClickListener mOnClickListener;

	public void setOnTopClickListener(TopClickListener onClickListener) {
		mOnClickListener = onClickListener;
	}

	//7、控制左侧button是否显示
	public void setLeftIsVisiable(boolean flag)
	{
		leftButton.setVisibility(flag?View.VISIBLE:View.GONE);
	}

}
