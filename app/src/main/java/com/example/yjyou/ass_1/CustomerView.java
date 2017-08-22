package com.example.yjyou.ass_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by YJYou on 2017/8/21.
 */

public class CustomerView extends View implements View.OnTouchListener{
    ArrayList<Coordinate> points = new ArrayList<>();
    class Coordinate{
        float x,y;
        int colour;
        public Coordinate(float x,float y, int colour){
            this.x=x;
            this.y=y;
            this.colour=colour;
        }
    }
    public CustomerView (Context context) {
        super(context);
        setOnTouchListener(this);
    }

    public CustomerView (Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }

    public CustomerView (Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOnTouchListener(this);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint=new Paint();

        for(Coordinate pt:points){
            paint.setColor(pt.colour);
            canvas.drawCircle(pt.x,pt.y,25,paint);
        }
    }
    float x,y;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        System.err.println(""+motionEvent.getX()+":"+motionEvent.getY());
        x=motionEvent.getX();
        y=motionEvent.getY();
        Random rand =new Random();

        points.add(new Coordinate(motionEvent.getX(), motionEvent.getY(),rand.nextInt()));
        invalidate();
        return true;
    }

}
