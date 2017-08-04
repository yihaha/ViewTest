package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        Path path = new Path();
        path.moveTo(10, 10);
        path.lineTo(10, 200);
        path.rLineTo(500, 0);
        canvas.drawPath(path, paint);

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        int x = 0;
        for (int i = 1; i < 6; i++) {
            if (i == 1) {
                x = 20;
            } else {
                x = x + 40;
            }
            Rect rect = new Rect(x, 20 + i * 15, x + 30, 200);
            canvas.drawRect(rect, paint);
        }

    }
}
