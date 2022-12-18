package com.example.snackoff;

import android.content.res.Resources;
import android.graphics.Canvas;

public class Food extends Sprite{

    private final int FOODSIZE = 10;

    Food (Resources res, int c) {
        super(res, c);
        spriteBound.set(0, 0, FOODSIZE * 2, FOODSIZE * 2);
    }

    /**
     * Draw method for Food itself
     * @param c
     */
    @Override
    public void draw(Canvas c) {
        c.drawCircle(spriteBound.left + FOODSIZE, spriteBound.top + FOODSIZE, FOODSIZE, paint);
    }

    @Override
    public void tick() {}
}
