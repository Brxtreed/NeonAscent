package com.Sciurus.NeonAscent;


import com.Sciurus.NeonAscent.R;
import com.Sciurus.NeonAscent.R.id;
import com.Sciurus.NeonAscent.R.layout;
import com.Sciurus.NeonAscent.R.menu;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuEntry extends ActionBarActivity {
	
	Button play;
	Button fb;
	Button howto;
	TextView mytextView;
	MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 requestWindowFeature(Window.FEATURE_NO_TITLE);
		    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
     //setContentView(new MainMenu(this));
		    setContentView(R.layout.activity_main_menu_entry);
		mp = MediaPlayer.create(this, R.raw.recode);
		mp.start();
		mp.setLooping(true);


		Typeface myTypeface = Typeface.createFromAsset(getAssets(), "neuropol.ttf");
		TextView myTextView = (TextView)findViewById(id.textView);
		myTextView.setTypeface(myTypeface);
		myTextView.setGravity(Gravity.CENTER);
		    
		    play = (Button) findViewById(R.id.playbutton);
		    fb = (Button) findViewById(R.id.likebutton);
			howto = (Button) findViewById(id.howto);

		play.setTypeface(myTypeface);
		fb.setTypeface(myTypeface);
		howto.setTypeface(myTypeface);


		    
		    play.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
			    	
			    	
			    	
			    	Intent intent = new Intent(MainMenuEntry.this, MainActivity.class);
			    
			    startActivity(intent);
			    }
		    });
		    
		    fb.setOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
			    	
			    	
			    	
			    	 Intent browse = new Intent( Intent.ACTION_VIEW , Uri.parse( "https://www.facebook.com/Sciuruscell/" ) );

					    startActivity( browse );
			    }
		    });

		howto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {


				Intent intent = new Intent(MainMenuEntry.this, Introscreen.class);

				startActivity(intent);
			}
		});


		    
		   
		    
		    
		    
     
	}

	@Override
	public void onPause() {
		super.onPause();
		mp.pause();
	}

	@Override
	public void onResume() {
		super.onResume();
		mp.start();
	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_menu_entry, menu);
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
}
