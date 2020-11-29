package ru.samsung.itschool.spacearrays;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Space;


public class MyDraw extends View {

	int screen_width = Resources.getSystem().getDisplayMetrics().widthPixels;
	int screen_height = Resources.getSystem().getDisplayMetrics().heightPixels;


	Moveable[] moves = new Moveable[10];


	Bitmap rocketImage = BitmapFactory.decodeResource(getResources(), R.drawable.rocket);
    Bitmap meteorImage = BitmapFactory.decodeResource(getResources(), R.drawable.meteor);

//	Rocket rocket = new Rocket(300f, 300f, 2f, 2f, rocketImage);
//	Rocket rocket2 = new Rocket(300f, 1000f, 1f, -2f, rocketImage);
//	Rocket rocket3 = new Rocket(300f, 10f, 1f, 2f, rocketImage);
	Sky sky = new Sky();



	public MyDraw(Context context, AttributeSet attrs) {
		super(context, attrs);
		sky.make();
		for (int i = 0; i < moves.length; i+=2){
			moves[i] = new Rocket(rnd(screen_width/4, screen_width*3/4), rnd(screen_height/4, screen_height*3/4), rnd(-10, 10), rnd(-10, 10), rocketImage);
		}
		for (int i = 1; i < moves.length; i+=2){
			moves[i] = new Meteorit(rnd(screen_width/8, screen_width*7/8), rnd(screen_height/8, screen_height*7/8), rnd(-0.3, 0.3), rnd(-0.5, 0.5), rnd(0.02, 0.2), meteorImage);
		}



	}
	@Override
	protected void onDraw(Canvas canvas) {

		sky.draw(canvas);

//		rocket.draw(canvas);
//		rocket2.draw(canvas);
//		rocket3.draw(canvas);
//		rocket.move();
//		rocket2.move();
//		rocket3.move();
		for (int i = 0; i < moves.length; i++){
			moves[i].draw(canvas);
			moves[i].move();
		}


		// Запрос на перерисовку экрана
		invalidate();
	}
	float rnd(double a, double b){
		return (float)(Math.random()*(b-a) + a);
	}
    
}