package com.example.renat.gamecircleview;


import android.graphics.Color;

import java.util.Random;

public class EnemyCircle extends SimplelCircle {
    public static final int TO_RADIUS = 110;
    public static final int  FROM_RADIUS = 10;
    public static final int  ENEMY_COLOR = Color.RED;
    public static final int  FOOD_COLOR = Color.rgb( 0, 0, 200);
    public static final int  SPEED_RANDOM = 10;
    private int dx;
    private int dy;


    public EnemyCircle(int x, int y, int radius, int dx, int dy) {
        super(x, y, radius);
        this.dx = dx;
        this.dy = dy;
    }

    public static EnemyCircle getRandomCircle() {
        Random random = new Random();
        int x = random.nextInt(GameManager.getWidth());
        int y = random.nextInt(GameManager.getHeight());
        int dx = 2 + random.nextInt(SPEED_RANDOM);
        int dy = 2 + random.nextInt(SPEED_RANDOM);
        int radius = FROM_RADIUS + random.nextInt(TO_RADIUS - FROM_RADIUS);
        EnemyCircle enemyCircle = new EnemyCircle( x, y,radius, dx, dy);
        return  enemyCircle;


    }

    public void setEnemyOrFoodColorDependsOn(MainCircle mainCircle) {
        if (isSmallerThan (mainCircle)) {
            setColor(FOOD_COLOR);
        }else {
            setColor(ENEMY_COLOR);

        }
    }

    public boolean isSmallerThan(SimplelCircle circle) {
        if (radius < circle.radius)
            return true;
        return false;
    }

    public void moveOneStep() {
        x += dx;
        y += dy;
        checkBounds();

    }

    private void checkBounds() {
        if ( x > GameManager.getWidth() || x < 0){
            dx = -dx;
        }
        if ( y > GameManager.getHeight() || y < 0){
            dy = -dy;
        }




    }
}

