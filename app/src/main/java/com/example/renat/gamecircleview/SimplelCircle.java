package com.example.renat.gamecircleview;


public class SimplelCircle {
    protected int x;
    protected int y;
    protected int radius;
    private int color;

    public SimplelCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public SimplelCircle getCircleArea() {
        return new SimplelCircle( x, y, radius * 3);
    }

    public boolean isIntersect(SimplelCircle circle) {

        return radius + circle.radius >= Math.sqrt(Math.pow( x - circle.x,2) + Math.pow( y - circle.y, 2));


    }
}
