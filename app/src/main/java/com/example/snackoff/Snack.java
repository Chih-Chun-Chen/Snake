package com.example.snackoff;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Snack extends Sprite{

    int image;
    int body;
    Paint innerPaint;
    Paint whiteEyesColor;
    Paint blackEyesColor;

    public Snack(Resources res, int c) {
        super(res, c);
        body = 5;

        innerPaint = new Paint();
        innerPaint.setColor(c - 1000000);

        whiteEyesColor = new Paint();
        whiteEyesColor.setColor(Color.WHITE);

        blackEyesColor = new Paint();
        blackEyesColor.setColor(Color.BLACK);
    }

    @Override
    void draw(Canvas c) {
        //Head
        c.drawCircle(position.x, position.y, 18, paint);
        c.drawCircle(position.x, position.y - 8, 8, whiteEyesColor);
        c.drawCircle(position.x, position.y + 8, 8, whiteEyesColor);
        c.drawCircle(position.x, position.y - 8, 5, blackEyesColor);
        c.drawCircle(position.x, position.y + 8, 5, blackEyesColor);

        for (int i = 0; i < body; i++) {
            //Body
            position.x += 27;
            c.drawCircle(position.x, position.y, 15, paint);
            c.drawCircle(position.x, position.y, 8, innerPaint);
        }
    }
}
