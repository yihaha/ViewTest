package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {

    private Paint mPaint;
    private float mStartAngle;  //起始点
    private float mSweepAngle;  //所占弧度
    private List<PieViewBean> mPieViewBeanList = new ArrayList<>();
    private int mHeight;
    private int mWidth;
    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};

    public Practice11PieChartView(Context context) {
        this(context, null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    private void init(Context context) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//
//      使用各种 Canvas.drawXXX() 方法画饼图

        float min = (float) (Math.min(mWidth, mHeight)*0.5);
        canvas.translate(mWidth / 2, mHeight / 2);
        RectF rectF = new RectF(-min, -min, min, min);
//        RectF rectF = new RectF(-50, -50, 50, 50);

        for (int i = 0; i < mPieViewBeanList.size(); i++) {
            PieViewBean pieViewBean = mPieViewBeanList.get(i);
            mStartAngle += mSweepAngle;
            mSweepAngle = pieViewBean.mRadian;
            mPaint.setColor(pieViewBean.mColor);
            canvas.drawArc(rectF, mStartAngle, mSweepAngle, true, mPaint);
        }

    }

    /**
     * 开始执行具体操作
     *
     * @param list
     */
    public void onStartDraw(List<PieViewBean> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            PieViewBean pieViewBean = list.get(i);
            sum += pieViewBean.mCount;
            pieViewBean.mColor = mColors[i % mColors.length];   //设置颜色
        }

        for (int i = 0; i < list.size(); i++) {
            PieViewBean pieViewBean = list.get(i);
            pieViewBean.mRadian = (float) pieViewBean.mCount / (float) sum * 360;
            mPieViewBeanList.add(pieViewBean);
        }

        invalidate();

    }


}
