package com.lifecircle.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.lifecircle.R;

/**
 * Created by lenovo on 2017/11/8.
 */

@SuppressLint("AppCompatCustomView")
public class BadgerView extends TextView {

    private  String nums;


    public BadgerView(Context context) {
        super(context);
    }

    public BadgerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a=context.obtainStyledAttributes(attrs, R.styleable.BadgerView);
        nums=a.getString(R.styleable.BadgerView_text_nums);
        a.recycle();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r=getMeasuredWidth()/2;
        int centerX=getLeft()+r;
        int centerY=getTop()+r;
        Paint p=new Paint();
        p.setColor(R.color.viewbadger);
        canvas.drawCircle(centerX,centerY,r,p);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int h=MeasureSpec.getSize(heightMeasureSpec);
        int w=MeasureSpec.getSize(widthMeasureSpec);
        int wm=MeasureSpec.getMode(widthMeasureSpec);
        if (w<h){
            w=h;
        }
    }
}
