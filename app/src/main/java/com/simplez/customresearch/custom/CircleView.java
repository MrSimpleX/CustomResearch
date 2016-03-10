package com.simplez.customresearch.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author JokerX
 * @version V1.0
 * @Package com.simplez.customresearch.custom
 * @Description: 类似PPT展示百分比的自定义View
 * @date 2016/3/9 16:50
 */
public class CircleView extends View{

	//最内层圆画笔
	private Paint mCirclePaint;
	//最外层圆弧画笔
	private Paint mArcPaint;
	//内层文字
	private Paint mTextPaint;

	private int mCircleWidth = 0;
	private int mLength = 0;
	private float mRadius = 0;
	private RectF mArcRectF;
	private int mSweepAngle = (int)((70 / 100.0) * 360);
	private String mText = "Java";
	private int mTextSize = 30;

	public CircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initPaint();
	}

	private void initPaint() {
		mCirclePaint = new Paint();
		mCirclePaint.setColor(Color.BLUE);
		mCirclePaint.setStyle(Paint.Style.FILL);
		mArcPaint = new Paint();
		mArcPaint.setColor(Color.GREEN);
		mArcPaint.setStyle(Paint.Style.STROKE);
		mArcPaint.setStrokeWidth(20);
		mTextPaint = new Paint();
		mTextPaint.setColor(Color.WHITE);
		mTextPaint.setStyle(Paint.Style.FILL);

		//获取中心圆的直径
		mLength = 400;
		mCircleWidth = mLength / 2;
		mRadius = (float)(mLength * 0.5 / 2);
		//指定圆弧的外接矩形
		mArcRectF = new RectF((float)(mLength * 0.1),
			(float)(mLength * 0.1), (float)(mLength * 0.9),
			(float)(mLength * 0.9));
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		//绘制中间的圆
		canvas.drawCircle(mCircleWidth, mCircleWidth, mRadius, mCirclePaint);
		//绘制中间的圆弧
		canvas.drawArc(mArcRectF, 270, mSweepAngle, false, mArcPaint);
		//绘制文字
		canvas.drawText(mText, 0, mText.length(), mCircleWidth, mCircleWidth + (mTextSize / 4), mTextPaint);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

	}
}
