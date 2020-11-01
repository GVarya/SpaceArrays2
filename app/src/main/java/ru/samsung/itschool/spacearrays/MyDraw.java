package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyDraw extends View {
	Rocket[] rockets = new Rocket[10];

	Bitmap rocketImage = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);

	Rocket rocket = new Rocket(300f, 300f, 2f, 2f, rocketImage);
	Rocket rocket2 = new Rocket(300f, 1000f, 1f, -2f, rocketImage);
	Rocket rocket3 = new Rocket(300f, 10f, 1f, 2f, rocketImage);
	Sky sky = new Sky();


	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		sky.make();
		for (int i = 0; i < rockets.length; i++){
			float x = (float) (Math.random() * 1000);
			float y = (float) (Math.random() * 2000);
			float vy = (float) ((Math.random() - 0.5) * 2);
			float vx = (float) ((Math.random() - 0.5) * 2);
			rockets[i] = new Rocket(x, y,vx,vy, rocketImage);
		}



	}
	@Override
	protected void onDraw(Canvas canvas) {

		sky.draw(canvas);

		rocket.draw(canvas);
		rocket2.draw(canvas);
		rocket3.draw(canvas);
		rocket.move();
		rocket2.move();
		rocket3.move();
		for (int i = 0; i < rockets.length; i++){
			rockets[i].draw(canvas);
			rockets[i].move();
		}


		// Запрос на перерисовку экрана
		invalidate();
	}
}