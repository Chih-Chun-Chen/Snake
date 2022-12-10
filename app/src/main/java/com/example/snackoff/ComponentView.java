package com.example.snackoff;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class ComponentView extends View implements TickListener{

    private boolean scale;
    private Sprite snake1;
    private Sprite snake2;
    private ArrayList<Sprite> snakeList;
    private Timer timer;

    public ComponentView(Context context) {
        super(context);
        timer = Timer.getTimer();
        scale = true;
        snakeList = new ArrayList<>();

    }

    @Override
    public void onDraw (Canvas c) {

        if (scale) {

            snake1 = new Snack(getResources(), Color.rgb(164, 66, 245));
            timer.register(snake1);

            snake2 = new Snack(getResources(), Sprite.chooseRandomColor());
            timer.register(snake2);

            for (int i = 0; i < 50; i++) {
                snakeList.add(new Food(getResources(), Sprite.chooseRandomColor()));
            }

            scale = false;
        }

        //Background Color
        c.drawColor(Color.rgb(52, 235, 128));

        //Snack Object
        snake1.setPoisition(500, 500);
        snake1.draw(c);

        snake2.setPoisition(900, 600);
        snake2.draw(c);

        //50 Food Object
        for (Sprite s : snakeList) {
            int randomX = (int) (Math.random() * c.getWidth());
            int randomY = (int) (Math.random() * c.getHeight());
            s.setPoisition(randomX, randomY);
            s.draw(c);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent m) {

        return true;
    }

    @Override
    public void tick() {

    }
}
