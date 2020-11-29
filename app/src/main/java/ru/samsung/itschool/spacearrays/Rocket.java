package ru.samsung.itschool.spacearrays;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.widget.Space;

public class Rocket extends SpaceObject {
    Rocket(float x, float y, float vx, float vy, Bitmap image){
        super(x, y, vx, vy, image);
    }

    public void move(){
        x += vx;
        y += vy;

    }

    //Paint paint = new Paint();

    public void draw(Canvas canvas)
    {
        Matrix matrix = new Matrix();
        matrix.setScale(0.2f, 0.2f);
        //Study mathematics, dear young programmer :)
        matrix.postRotate((float)Math.toDegrees(Math.atan2(vy, vx)) + 45);
        matrix.postTranslate(x, y);
        paint.setAlpha(255);
        canvas.drawBitmap(image, matrix, paint);
    }

}
