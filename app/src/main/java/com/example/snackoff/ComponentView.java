package com.example.snackoff;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

public class ComponentView extends View {

    private boolean scale;
    private Sprite snack1;
    private Sprite food;

    public ComponentView(Context context) {
        super(context);
        scale = true;
    }

    @Override
    public void onDraw (Canvas c) {

        if (scale) {

            snack1 = new Snack(getResources(), Color.rgb(164, 66, 245));

            food = new Food(getResources(), Color.rgb(66, 117, 245));

            scale = false;
        }

        //Background Color
        c.drawColor(Color.rgb(52, 235, 128));

        //Snack Object
        snack1.setPoisition(500, 500);
        snack1.draw(c);

        //Food Object
        food.setPoisition(700, 700);
        food.draw(c);
    }
}
