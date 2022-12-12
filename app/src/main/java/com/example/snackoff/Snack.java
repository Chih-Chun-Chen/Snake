package com.example.snackoff;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

public class Snack extends Sprite implements TickListener{


    private Paint innerPaint;
    private Paint whiteEyesColor;
    private Paint blackEyesColor;
    private PointF velocity;
    private int image;
    private int body;
    private int bodySize;

    public Snack(Resources res, int c) {
        super(res, c);
        body = 5;
        bodySize = 15;
        velocity = new PointF();

        innerPaint = new Paint();
        innerPaint.setColor(c - 1000000);

        whiteEyesColor = new Paint();
        whiteEyesColor.setColor(Color.WHITE);

        blackEyesColor = new Paint();
        blackEyesColor.setColor(Color.BLACK);

        spriteBound.set(0, 0, bodySize, bodySize);
    }

    /**
     * Draw method for Snake's head, eyes, and body
     * @param c
     */
    @Override
    public void draw(Canvas c) {
        //Head
        c.drawCircle(spriteBound.left, spriteBound.top, 18, paint);
        c.drawCircle(spriteBound.left, spriteBound.top - 8, 8, whiteEyesColor);
        c.drawCircle(spriteBound.left, spriteBound.top + 8, 8, whiteEyesColor);
        c.drawCircle(spriteBound.left, spriteBound.top - 8, 5, blackEyesColor);
        c.drawCircle(spriteBound.left, spriteBound.top + 8, 5, blackEyesColor);

        for (int i = 0; i < body; i++) {
            //Body
            spriteBound.left += 27;
            c.drawCircle(spriteBound.left, spriteBound.top, bodySize, paint);
            c.drawCircle(spriteBound.left, spriteBound.top, bodySize - 2, innerPaint);
        }



        Paint paint= new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);
        c.drawRoundRect(spriteBound,0, 0 , paint);
    }

    /**
     * To make the Sprite to move
     */
    public void move() {
        spriteBound.offset(1, 1);
    }

    /**
     * To call Sprite.move()
     * To use as Observer design pattern
     */
    @Override
    public void tick() {
        this.move();
    }
}
