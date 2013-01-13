package karol.artur.adam.tetris;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * 
 * @author Artur Matusiak, Karol Nowak, Adam Nawarycz
 * Main activity of the game.
 * Shows navigation menu.
 */
public class MainActivity extends Activity implements android.view.View.OnClickListener {
	/*
	 * New Button objects
	 */
	private Button bNewGame, bSettings,bExit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * Settings layout for the whole activity
         */
        setContentView(R.layout.activity_main);
        /*
         * Connect new Button objects with items from xml file
         * Setting click listener for each button
         */
        bNewGame = (Button)findViewById(R.id.startGame);
        bNewGame.setOnClickListener(this);
        
        bSettings = (Button)findViewById(R.id.settingsGame);
        bSettings.setOnClickListener(this);
        
        bExit = (Button)findViewById(R.id.exitGame);
        bExit.setOnClickListener(this);
    }
    /*
     * Detecting which button was clicked
     */
	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.startGame:
				startActivity(new Intent(this,GameActivity.class));
				break;
				
			case R.id.settingsGame:
				startActivity(new Intent(this,SettingsActivity.class));
				break;
				
			case R.id.exitGame:
				this.finish();
				break;
		}
	}
	




}
