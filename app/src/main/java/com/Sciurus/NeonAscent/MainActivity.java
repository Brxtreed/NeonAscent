package com.Sciurus.NeonAscent;




import com.Sciurus.NeonAscent.Levels.BlackandWhite;
import com.Sciurus.NeonAscent.R;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends ActionBarActivity {
	static MediaPlayer mp = null;
	int [] tracks = new int[3];
	int currentTrack = 0;
	
	gameview gameview;
	BlackandWhite view;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
		    WindowManager.LayoutParams.FLAG_FULLSCREEN);

		tracks[0] = R.raw.recode;
		tracks[1] = R.raw.recode2;
		tracks[2] = R.raw.recode3;

		mp = MediaPlayer.create(this, tracks[0]);
		mp.start();
		mp.setLooping(true);


		    
		    
		    Bitmap bitmap = BitmapFactory.decodeResource( getResources(), R.drawable.triangle);

			//Creates a new game view with the player icon image
			view = new BlackandWhite(this,bitmap);



        setContentView(view);
        
		
		
        
        

	}
	

	
	
	

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();

		view.setrun(false);
		
		mp.stop();
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) {

			view.setrun(false);
	        
	        mp.stop();

			//if the back buttons is pressed the game ends
	        finish();
	    }
	    return false;
	}


	@Override
	public void onResume(){
		super.onResume();
		mp.reset();
		mp = MediaPlayer.create(this, tracks[currentTrack]);

		mp.start();
		mp.setLooping(true);

	}









	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void playSong(int songIndex) {
		this.currentTrack = songIndex;
		mp.reset();
		mp = MediaPlayer.create(this, tracks[songIndex]);
		mp.start();
		mp.setLooping(true);
	}
}
