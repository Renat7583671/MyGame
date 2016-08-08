package com.example.renat.gamecircleview;


import java.util.ArrayList;

public class GameManager {

    public static final int  MAX_CIRCLES = 20;


    private MainCircle mainCircle;
    private ArrayList<EnemyCircle> circles;
    private  CanvasView canvasView;
    private static int wiedht;
    private static int height;


    public GameManager(CanvasView canvasView, int w, int h) {
        this.canvasView = canvasView;
        wiedht = w;
        height = h;


        initMainCircle();
        initEnemyCircles();



    }

    private void initEnemyCircles() {
        SimplelCircle mainCircleArea = mainCircle.getCircleArea ();
        circles = new ArrayList<EnemyCircle>();
        for (int i = 0; i < MAX_CIRCLES; i++){
            EnemyCircle circle;

            do {
                circle = EnemyCircle.getRandomCircle();
            } while (circle.isIntersect(mainCircleArea));
            circles.add(circle);
        }
        calculateAndSetCirclesColor();

    }

    private void calculateAndSetCirclesColor() {
        for (EnemyCircle circle : circles) {
            circle.setEnemyOrFoodColorDependsOn(mainCircle);
        }
    }


    public static int getWidth() {
        return wiedht;
    }

    public static int getHeight() {
        return height;
    }


    private void initMainCircle() {
        mainCircle = new MainCircle(wiedht /2,height /2);
    }


    public void onDraw() {
        canvasView.drawCircle(mainCircle);
        for (EnemyCircle circle : circles) {
            canvasView.drawCircle(circle);
        }


    }


    public void onTouchEvent(int x, int y) {
        mainCircle.moveMainCircle ( x, y);
        checkCollision();
        moveCircles ();
    }

    private void checkCollision() {
        SimplelCircle circleDel = null;
        for (EnemyCircle circle : circles) {
            if (mainCircle.isIntersect(circle)){
                if (circle.isSmallerThan(mainCircle)){
                    mainCircle.growRadius (circle);
                    circleDel = circle;
                    calculateAndSetCirclesColor();
                    break;


                }else {
                    gameEnd();
                    return;
                }

            }
        }
        if (circleDel != null){
            circles.remove(circleDel);
        }
        if (circles.isEmpty()){
            gameEnd();
        }
    }

    private void gameEnd() {
        mainCircle.initRadius ();
        initEnemyCircles();
        canvasView.restDraw();
    }

    private void moveCircles() {
        for (EnemyCircle circle : circles) {
            circle.moveOneStep();
        }
    }
}

