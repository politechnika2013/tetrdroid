package karol.artur.adam.tetris;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 
 * @author Artur Matusiak, Karol Nowak, Adam Nawarycz
 *
 * GameActivity class creates new block object and sets background
 */
public class GameActivity extends Activity {

	private MySurfaceView mySurfaceView;
	private BlockRightL rightL;
	private int x = 240;
	private float y = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mySurfaceView = new MySurfaceView(this);
		setContentView(mySurfaceView);
		rightL = new BlockRightL(this);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mySurfaceView.onResumeMySurfaceView();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mySurfaceView.onPauseMySurfaceView();
	}

	/**
	 * 
	 * @author Artur Matusiak, Karol Nowak, Adam Nawarycz
	 *
	 * MySurfaceView class provides background/blocks render and detects screen touch
	 */
	class MySurfaceView extends SurfaceView implements Runnable {

		Thread thread = null;
		SurfaceHolder surfaceHolder;
		volatile boolean running = false;

		private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		private float x0;
		public MySurfaceView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			surfaceHolder = getHolder();
		}

		public void onResumeMySurfaceView() {
			running = true;
			thread = new Thread(this);
			thread.start();
		}

		public void onPauseMySurfaceView() {
			boolean retry = true;
			running = false;
			while (retry) {
				try {
					thread.join();
					retry = false;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub

			while (running) {

				if (surfaceHolder.getSurface().isValid()) {
					/**
					 * redraw block when y position is less than 740px and x position is more than 0px
					 */
					if (y >= 0 && y <= 740) {
						Canvas canvas = surfaceHolder.lockCanvas();
						y += 0.8f;

						paint.setColor(Color.BLACK);

						canvas.drawRect(0, 0, 480, 800, paint);
						canvas.drawBitmap(rightL.block, x, y, paint);
						surfaceHolder.unlockCanvasAndPost(canvas);
					}

					
				}
			}
		}

		@Override
		public boolean onTouchEvent(MotionEvent event) {
			// TODO Auto-generated method stub
			x0 = event.getX();
			if (x0 < 240 && x>20)
				x -= 20;
			else if(x0<410 && x<410)
				x += 20;

			return true;
		}

	}
}