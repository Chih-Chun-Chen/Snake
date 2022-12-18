package com.example.snackoff;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class ComponentView extends View implements TickListener{

    private boolean scale;
    private Snack snake1;
    private Snack snake2;
    private ArrayList<Snack> snakeList;
    private ArrayList<Sprite> foodCreationList;
    private ArrayList<Sprite> foodList;
    private ArrayList<Sprite> foodRemoveList;
    private Timer timer;
    private GameController controller;
    private int numOfFood;

    public ComponentView(Context context) {
        super(context);
        timer = Timer.getTimer();
        scale = true;
        snakeList = new ArrayList<>();
        foodCreationList = new ArrayList<>();
        foodList = new ArrayList<>();
        foodRemoveList = new ArrayList<>();
        controller = new GameController();
        numOfFood = 0;

    }

    /**
     * Game Controller inner class
     */
    protected class GameController {

        private Paint p;

        GameController() {
            p = new Paint();
            p.setStrokeWidth(10);
            p.setStyle(Paint.Style.STROKE);
            p.setColor(Color.GRAY);
        }

        public void makeController(Canvas c, float controllerX, float controllerY, float radius, Paint p) {
            c.drawCircle(controllerX, controllerY, radius, p);
        }
    }

    @Override
    public void onDraw (Canvas c) {
        //Width: 2040
        //Height: 880

        if (scale) {

            snake1 = new Snack(getResources(), Color.rgb(164, 66, 245));
            snake1.setPoisition(500, 500);
            snakeList.add(snake1);
            timer.register(snake1);

            snake2 = new Snack(getResources(), Sprite.chooseRandomColor());
            snake2.setPoisition(900, 600);
            snakeList.add(snake2);
            timer.register(snake2);

            //50 Food Object
            while (numOfFood != 50) {
                int randomX = (int) (Math.random() * c.getWidth());
                int randomY = (int) (Math.random() * c.getHeight());
                if (!(randomX > snake1.spriteBound.left && randomX < snake1.spriteBound.right && randomY > snake1.spriteBound.top && randomY < snake1.spriteBound.bottom)) {
                        Sprite food = new Food(getResources(), Sprite.chooseRandomColor());
                        food.setPoisition(randomX, randomY);
                        foodList.add(food);
                        numOfFood++;
                }
            }

            scale = false;
        }

        //Background Color
        c.drawColor(Color.rgb(52, 235, 128));

        //To create the game controller
        controller.makeController(c, c.getWidth() * 0.098039f, c.getHeight() * 0.85227f, 80, controller.p);

        //To draw Snack Object
        snake1.draw(c);
        snake1.visualizeRectF(c);

        snake2.draw(c);
        snake2.visualizeRectF(c);

        //To draw 50 Food Object
        for (Sprite f : foodList) {
            f.draw(c);
            f.visualizeRectF(c);
        }

        //To remove Food Object after intersecting with Snake Object
        for (Sprite f : foodRemoveList) {
            foodCreationList.remove(f);
            foodList.remove(f);
            timer.deregister(f);
        }

        tick();
    }

    @Override
    public void tick() {
        detectCollisions();
        invalidate();
    }

    /**
     * To detect the intersection between the Snake Object and Food Object
     */
    public void detectCollisions() {
        for (Snack s : snakeList) {
            for (Sprite f : foodList) {
                if (s.eat(f)) {
                    foodRemoveList.add(f);
                }
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {

        return true;
    }
}
