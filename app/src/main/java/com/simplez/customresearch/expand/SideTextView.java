package com.simplez.customresearch.expand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author JokerX
 * @version V1.0
 * @Package com.simplez.customresearch.expand
 * @Description: 自定义View测试，拓展TextView
 * @date 2016/3/9 11:20
 */
public class SideTextView extends TextView{

	//外层矩形画笔
	private Paint outPaint;
	//内层矩形画笔
	private Paint inPaint;

	public SideTextView(Context context) {
		super(context);
	}

	public SideTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initPaints();
	}

	/**
	 * 初始化相关画笔
	 */
	private void initPaints() {
		outPaint = new Paint();
		outPaint.setColor(Color.parseColor("#F14841"));
		outPaint.setStyle(Paint.Style.FILL);
		inPaint = new Paint();
		inPaint.setColor(Color.YELLOW);
		inPaint.setStyle(Paint.Style.FILL);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		//绘制外层形状
		canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), outPaint);
		//绘制内层矩形
		canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, inPaint);
		canvas.save();
		//绘制文字前平移10像素
		canvas.translate(10, 0);
		//完成父类的绘制方法
		super.onDraw(canvas);
		canvas.restore();
	}

	/*@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
	}
*/
	/**
	 * 根据测量模式给出不同的默认值，主要用于设置Wrap_Content属性
	 *
	 * @param measureSpec 测量值
	 * @return 重新绘制的宽度
	 */
	private int measureWidth(int measureSpec){
		int result = 0;
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);

		if(MeasureSpec.EXACTLY == specMode){
			result = specSize;
		}else{
			result = 200;
			if(MeasureSpec.AT_MOST == specMode){
				result = Math.min(result, specSize);
			}
		}

		return result;
	}

	/**
	 * 根据测量模式给出不同的默认值，主要用于设置Wrap_Content属性
	 *
	 * @param measureSpec 系统测量值
	 * @return 重新绘制的高度
	 */
	private int measureHeight(int measureSpec){
		int result = 0;
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);

		if(MeasureSpec.EXACTLY == specMode){
			result = specSize;
		}else{
			result = 20;
			if(MeasureSpec.AT_MOST == specMode){
				result = Math.min(result, specSize);
			}
		}

		return result;
	}
}
