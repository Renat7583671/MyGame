package com.example.renat.gamecircleview;


import android.graphics.Color;

public class MainCircle extends SimplelCircle {

    public static final int INTIT_RADIUS = 50;
    public static final int MAX_SPEED = 70;
    public static final int OUT_COLOR = Color.GREEN;

    public MainCircle(int x, int y) {
        super(x, y, INTIT_RADIUS);
        setColor(OUT_COLOR);
    }


    public void moveMainCircle(int x1, int y1) {

        int dx = (x1 - x) * MAX_SPEED / GameManager.getWidth ();
        int dy = (y1 - y) * MAX_SPEED / GameManager.getHeight ();

        x += dx;
        y += dy;



    }

    public void initRadius() {
        radius = INTIT_RADIUS;
    }

    public void growRadius(SimplelCircle circle) {
        radius = (int) Math.sqrt(Math.pow(radius, 2) + Math.pow(circle.radius, 2) );
    }
}

