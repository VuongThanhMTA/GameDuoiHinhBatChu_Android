package com.vuongthanh.t3h.baitap_buoi7_gamedhbc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class CustomImage  extends AppCompatImageView {
    private Paint paint;
    public CustomImage(Context context) {
        super(context);
        init();
    }

    public CustomImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);// hình tròn giỗng
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = View.MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(height,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = getWidth()/2;
        int stroke = getWidth()/3;
        int radius = getWidth()/2+getWidth()/7;
        paint.setStrokeWidth(stroke);
//        Rect rect = new Rect(0,0,getWidth(),getHeight());
//        canvas.drawRect(rect,paint);
        canvas.drawCircle(size,size,radius,paint);

    }
}
