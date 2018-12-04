package com.likego.taiji;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * TODO: document your custom view class.
 */
public class MyView extends View {

    private String TAG = "xmlc-MyView";

    private Paint whitePaint;
    private Paint blackPaint;
    private Paint randomPaint;
    private Random mRandom;
    private String[] testString = {"生日快乐"};
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.resize);

    public MyView(Context context) {
        super(context);
        Log.d(TAG, "MyView: 1");
        initPaints();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG, "MyView: 2");
        initPaints();
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Log.d(TAG, "MyView: 3");
    }

    private void initPaints() {
        //黑白画笔
        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);

        blackPaint = new Paint();
        blackPaint.setAntiAlias(true);
        blackPaint.setColor(Color.BLACK);

        randomPaint = new Paint();
        blackPaint.setAntiAlias(true);
        randomPaint.setTextSize(100);
        randomPaint.setStyle(Paint.Style.FILL);
        randomPaint.setTextAlign(Paint.Align.CENTER);
        mRandom = new Random();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();   //画布宽度
        int height = canvas.getHeight(); //画布高度
        int view_width = bitmap.getWidth();
        int view_height = bitmap.getHeight();
        Log.d(TAG, "onDraw: "+width +" * "+ height+"----"+view_width +" * "+ view_height);
        canvas.translate(width/2, height/2);//定义一个点，画布中心点
        canvas.drawColor(Color.WHITE);//背景白色

        randomPaint.setColor(Color.rgb(getRandomNumber(0,255),
                getRandomNumber(0,255), getRandomNumber(0,255)));//每次颜色都随机
        canvas.drawRect(-20, 10, 20, 500, randomPaint);

        canvas.rotate(degrees);

//        randomPaint.setColor(Color.rgb(getRandomNumber(0,255),
//                getRandomNumber(0,255), getRandomNumber(0,255)));//每次颜色都随机
//        canvas.drawText(testString[getRandomNumber(0,testString.length)], getRandomNumber(100,width), getRandomNumber(100,height),randomPaint);
        Paint paint_2 = new Paint();
        paint_2.setAntiAlias(true);
//        canvas.drawBitmap(bitmap,width/2 - view_width/2,height/2 - view_height/2,paint_2);
        canvas.drawBitmap(bitmap,-view_width/2,-view_height/2,paint_2);


    }

    private float degrees = 0;                  //旋转角度
    public void setRotate(float degrees) {
        this.degrees = degrees;
        invalidate();                        //重绘界面
    }

    public static int getRandomNumber(int Min,int max){
        if(max > Min){
            Random random = new Random();
            return random.nextInt(max - Min) + Min;
        }
        return 0;
    }

}
