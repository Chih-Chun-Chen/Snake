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
    private Timer timer;

    public ComponentView(Context context) {
        super(context);
        timer = Timer.getTimer();
        scale = true;
        snakeList = new ArrayList<>();
        foodCreationList = new ArrayList<>();
        foodList = new ArrayList<>();

    }

    @Override
    public void onDraw (Canvas c) {

        if (scale) {

            snake1 = new Snack(getResources(), Color.rgb(164, 66, 245));
            snake1.setPoisition(500, 500);
            snakeList.add(snake1);
            timer.register(snake1);

            snake2 = new Snack(getResources(), Sprite.chooseRandomColor());
            snake2.setPoisition(900, 600);
            snakeList.add(snake2);
            timer.register(snake2);

            for (int i = 0; i < 50; i++) {
                foodCreationList.add(new Food(getResources(), Sprite.chooseRandomColor()));
            }

            //50 Food Object
            for (Sprite s : foodCreationList) {
                int randomX = (int) (Math.random() * c.getWidth());
                int randomY = (int) (Math.random() * c.getHeight());
                s.setPoisition(randomX, randomY);
                foodList.add(s);
            }

            scale = false;
        }

        //Background Color
        c.drawColor(Color.rgb(52, 235, 128));

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

        tick();
    }

    @Override
    public void tick() {
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {

        return true;
    }


}
