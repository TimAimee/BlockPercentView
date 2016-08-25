package com.timaimee.blockview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TimAimee on 2016/8/25.
 */
public class BlockPercentView extends View {

    private Paint paintone, painttwo, paintthree, paintfour, paintfive;
    private float mWidth, mHeight;

    private List<Paint> paintList = new ArrayList<>();
    private float[] progressList = new float[5];

    public BlockPercentView(Context context) {
        super(context);
    }

    public BlockPercentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initPaint();
    }

    private void initPaint() {
        paintone = new Paint();
        paintone.setStrokeWidth(2);
        paintone.setColor(Color.GREEN);
        paintone.setStyle(Paint.Style.FILL);

        painttwo = new Paint();
        painttwo.setStrokeWidth(2);
        painttwo.setColor(Color.RED);
        painttwo.setStyle(Paint.Style.FILL);

        paintthree = new Paint();
        paintthree.setStrokeWidth(2);
        paintthree.setColor(Color.BLUE);
        paintthree.setStyle(Paint.Style.FILL);

        paintfour = new Paint();
        paintfour.setStrokeWidth(2);
        paintfour.setColor(Color.BLACK);
        paintfour.setStyle(Paint.Style.FILL);

        paintfive = new Paint();
        paintfive.setStrokeWidth(2);
        paintfive.setColor(Color.YELLOW);
        paintfive.setStyle(Paint.Style.FILL);

        addPaint();
    }



    private void addPaint() {
        paintList.add(paintone);
        paintList.add(painttwo);
        paintList.add(paintthree);
        paintList.add(paintfour);
        paintList.add(paintfive);
    }


    public void setProgressArr(float... progressArr) {
        for (int i = 0; i < progressArr.length; i++) {
            progressList[i] = progressArr[i];
        }
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float progreeSum = 0;
        float lastXPoint = 0;
        for (int i = 0; i < progressList.length; i++) {
            progreeSum = progreeSum + progressList[i];
            RectF rectF = new RectF(lastXPoint, 0, mWidth * progreeSum, getHeight());
            canvas.drawRect(rectF, paintList.get(i));
            lastXPoint = mWidth * progreeSum;
        }
    }

}
