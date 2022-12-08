package com.example.snackoff;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

abstract class Sprite {

    public Bitmap image;
    Point position;
    Paint paint;


    public Sprite(Resources res, int c) {
        position = new Point();
        paint = new Paint();
        paint.setColor(c);
    }

    abstract void draw(Canvas c);

    public void setPoisition(int x, int y) {
        position.x = x;
        position.y = y;
    }
}
