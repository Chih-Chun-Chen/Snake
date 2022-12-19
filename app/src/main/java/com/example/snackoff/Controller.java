package com.example.snackoff;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public abstract class Controller {

    RectF controllerBound;
    Paint paint;

    Controller() {
        controllerBound = new RectF();
        paint = new Paint();
    }

    abstract void makeController(Canvas c, Paint p);

    /**
     * To set Controller's position
     * @param x coordinate
     * @param y coordinate
     */
    public void setPosition(float x, float y) {
        controllerBound.offsetTo(x, y);
    }

    public void visualizeRectF(Canvas c) {
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        c.drawRect(controllerBound, p);
    }
}
