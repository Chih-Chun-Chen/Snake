package com.example.snackoff;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;

public class Snack extends Sprite implements TickListener{

    private Paint whiteEyesColor;
    private Paint blackEyesColor;
    private PointF velocity;
    private int image;
    private int body;
    private int bodySize;
    private int bodyBound;
    private final int lensOfBody = 30;

    public Snack(Resources res, int c) {
        super(res, c);
        body = 5;
        bodySize = 15;

        velocity = new PointF();
        velocity.x = -10;

        whiteEyesColor = new Paint();
        whiteEyesColor.setColor(Color.WHITE);

        blackEyesColor = new Paint();
        blackEyesColor.setColor(Color.BLACK);

        spriteBound.set(0, 0, 30 + bodySize * 2 * body, bodySize * 2);
    }

    /**
     * To call Sprite.move()
     * To use as Observer design pattern
     */
    @Override
    public void tick() {
        this.move();
    }

    /**
     * Draw method for Snake's head, eyes, and body
     * @param c
     */
    @Override
    public void draw(Canvas c) {
        //Head
        c.drawCircle(spriteBound.left + bodySize, spriteBound.top + bodySize, 18, paint);
        c.drawCircle(spriteBound.left + bodySize, spriteBound.top + bodySize - 8, 8, whiteEyesColor);
        c.drawCircle(spriteBound.left + bodySize, spriteBound.top + bodySize + 8, 8, whiteEyesColor);
        c.drawCircle(spriteBound.left + bodySize, spriteBound.top + bodySize - 8, 5, blackEyesColor);
        c.drawCircle(spriteBound.left + bodySize, spriteBound.top + bodySize + 8, 5, blackEyesColor);

        bodyBound = lensOfBody;
        for (int i = 0; i < body; i++) {
            //Body
            c.drawCircle(spriteBound.left + bodySize + bodyBound, spriteBound.top + bodySize, bodySize, paint);
            bodyBound += lensOfBody;
        }
    }

    /**
     * To make the Sprite to move
     */
    public void move() {
        spriteBound.offset(velocity.x, 0);
    }

    /**
     * To check if Sprite Object contains Food Object's spriteBound
     * To adjust the lengths of body and spriteBound of Snake Object
     * @return true
     */
    public boolean eat(Sprite other) {
        if (this.spriteBound.intersects(this.spriteBound, other.spriteBound)) {
            this.body += 1;
            this.spriteBound.right += lensOfBody;
        }
        return RectF.intersects(this.spriteBound, other.spriteBound);
    }

}
