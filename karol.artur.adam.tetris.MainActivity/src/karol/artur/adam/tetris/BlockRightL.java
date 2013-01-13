package karol.artur.adam.tetris;

import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
/**
 * 
 * @author Artur Matusiak, Karol Nowak, Adam Nawarycz
 * BlockRightL class sets background for new block
 */
public class BlockRightL {

	public Bitmap block;
	public boolean moveable = true;
	
	BlockRightL(Context context){
		try {
			/*
			 * opens and sets rl.png file from "assets" dir
			 */
			block = BitmapFactory.decodeStream(context.getAssets().open("rl.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
