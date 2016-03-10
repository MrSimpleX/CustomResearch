package com.simplez.customresearch.expand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author JokerX
 * @version V1.0
 * @Package com.simplez.customresearch.expand
 * @Description: 文字闪耀TextView
 * @date 2016/3/9 14:49
 */
public class GlintTextView extends TextView{

	//自定义颜色渐变器
	private LinearGradient mLineatGradient;
	private Matrix mGradientMatrix;
	private int mTranslate = 0;
	//控件的宽高
	private int mViewWidth = 0;
	private int mViewHight = 0;
	//文本绘制画笔
	private Paint mPaint;

	public GlintTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(mGradientMatrix != null){
			mTranslate += mViewWidth / 5;
			if(mTranslate > 2 * mViewWidth){
				mTranslate = -mViewWidth;
			}
			mGradientMatrix.setTranslate(mTranslate, 0);
			mLineatGradient.setLocalMatrix(mGradientMatrix);
			postInvalidateDelayed(200);
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		if(mViewWidth == 0){
			mViewWidth = getMeasuredWidth();
			if(mViewWidth > 0 ){
				mPaint = getPaint();
				mLineatGradient = new LinearGradient(0, 0, mViewWidth, 0,
																						new int[]{Color.BLUE, 0xFFFFFFFF, Color.BLUE},
																						null, Shader.TileMode.CLAMP);
				mPaint.setShader(mLineatGradient);
				mGradientMatrix = new Matrix();
			}
		}
	}

}
