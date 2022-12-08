package com.example.snackoff;

import android.content.res.Resources;
import android.graphics.Canvas;

public class Food extends Sprite{

    Food (Resources res, int c) {
        super(res, c);
    }

    @Override
    void draw(Canvas c) {
        c.drawCircle(position.x, position.y, 10, paint);
    }
}
