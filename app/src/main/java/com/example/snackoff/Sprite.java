package com.example.snackoff;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.View;

abstract class Sprite implements TickListener{

    public Bitmap image;
    Point position;
    Paint paint;
    RectF spriteBound;


    public Sprite(Resources res, int c) {
        position = new Point();
        spriteBound = new RectF();
        paint = new Paint();
        paint.setColor(c);
    }

    /**
     * abstract method
     * To draw the Sprite
     * @param c
     */
    public abstract void draw(Canvas c);

    /**
     * To set Sprite's position
     * @param x coordinate
     * @param y coordinate
     */
    public void setPosition(float x, float y) {
        spriteBound.offsetTo(x, y);
    }

    /**
     * To set the color randomly for the Sprite
     * @return int color
     */
    public static int chooseRandomColor() {
        int color;
        int randomColloer = (int) (Math.random() * 10);
        switch (randomColloer) {
            case 0: color = Color.rgb(235, 52, 52);
                break;
            case 1: color = Color.rgb(235, 205, 52);
                break;
            case 2: color = Color.rgb(173, 165, 9);
                break;
            case 3: color = Color.rgb(52, 189, 235);
                break;
            case 4: color = Color.rgb(52, 64, 235);
                break;
            case 5: color = Color.rgb(171, 52, 235);
                break;
            case 6: color = Color.rgb(226, 52, 235);
                break;
            case 7: color = Color.rgb(235, 52, 162);
                break;
            case 8: color = Color.rgb(34, 102, 68);
                break;
            case 9: color = Color.rgb(0, 0, 0);
                break;
            default: color = Color.rgb(89, 52, 235);
                break;
        }
        return color;
    }

    public void visualizeRectF(Canvas c) {
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        c.drawRect(spriteBound, p);
    }
}
