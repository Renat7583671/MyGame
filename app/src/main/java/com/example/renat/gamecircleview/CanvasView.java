package com.example.renat.gamecircleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;


public class CanvasView extends View implements ICanvasView{

    private GameManager gameManager;
    private static int height;
    private static  int wiedht;
    private Paint paint;
    private Canvas canvas;



    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        intWiedhtAndHeight(context);
        initPaint();


        gameManager = new GameManager(this,wiedht,height);


    }
    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    private void intWiedhtAndHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);
        wiedht = point.x;
        height = point.y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        gameManager.onDraw();

    }

    @Override
    public void drawCircle(SimplelCircle circle) {
        paint.setColor(circle.getColor());
        canvas.drawCircle(circle.getX(),circle.getY(),circle.getRadius(),paint);

    }

    @Override
    public void restDraw() {
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_MOVE){
            gameManager.onTouchEvent (x , y);
        }
        invalidate();
        return true;
    }
}

