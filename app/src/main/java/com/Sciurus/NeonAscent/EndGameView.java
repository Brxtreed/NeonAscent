package com.Sciurus.NeonAscent;



import java.util.concurrent.atomic.AtomicBoolean;


import com.Sciurus.NeonAscent.R;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;

import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;







public class EndGameView extends View {
	
	boolean running = true;
	boolean white = true;
	
	
	int collision = 0;
	int lives = 3;
	int score = 1;
	boolean touch = false;
	boolean actionDownFlag = true;
	Paint redPaint;
	String TextScore = "Game Over" ;
	Paint particle;
	Paint whitePaint;
	Paint grey;
	Paint textPaint;
	int radius = 25;
	int circley = 50;
	int circlex = 50;
	int x;
	int y;
	int dirrection = 0;
	int height;
	int width;
	int oheight;
	int owidth;
	Bitmap background;
	int currentframe = 0;
	int screenw = 0;
	int screenh = 0;
	Endcircles Circle1;
	Endcircles Circle2;
	Endcircles Circle3;
	Endcircles Circle4;
	Endcircles Circle5;
	Endcircles Circle6;
	int circlex2;
	int circley2;
	int circlex3;
	int circley3;
	Bitmap car;
	int bwidth;
	int bheight;
	int reset = 0;
	int gamewarp = 10;
	Paint clear;
	Thread therad;
	
	
	
	

	int speed = 10;
	int sradius = 5;
	int left = 0;
	int right = 0;
	int bottom = 0;
	int top = 0;
	Bitmap spaceship;
	Bitmap mouse;
	Context mycontext;
	AlertDialog.Builder alertDialogBuilder;
	
	public EndGameView(Context context) {
		super(context);
		
		
		this.mycontext = context;
		
	
	
		
		
		
		this.redPaint = new Paint();
		this.redPaint.setAntiAlias(true);
	    this.redPaint.setColor(Color.CYAN);
	    
	    this.particle = new Paint();
		this.particle.setAntiAlias(true);
	    this.particle.setColor(Color.WHITE);
	    
	    
	    
	    this.whitePaint = new Paint();
		this.whitePaint.setAntiAlias(true);
	    this.whitePaint.setColor(Color.YELLOW);
	    
	    this.grey = new Paint();
		this.grey.setAntiAlias(true);
	    this.grey.setColor(Color.LTGRAY);
	    
	    
	    this.clear = new Paint();
	  	this.clear.setAntiAlias(true);
	  	this.clear.setColor(Color.WHITE);
	  	
	  	this.textPaint = new Paint();
	  	textPaint.setColor(Color.CYAN);
	  	textPaint.setTextSize(75);
	  	endHand();
	  	
	  	
	  
	    
	   
	    
	    
	
	   
	  
	   
	   circlex = 40;
	   
	   Thread thread = new Thread() {
		    @Override
		    public void run() {
		    	circlex3 = circlex;
		    	
		    	
		        try {
		        	
		            while(running) {
		            	
		            	 
		                sleep(10000);
		                System.out.println("This thread is running");
		                
		                if (white == false){
			            	   white = true;
		                }
		               
		                
		                
		                
		                else if  (white == true){
		            	   white = false;
		               }
		            
		                
		              
		                
		                
		                
		                
		                
		             
		                
		               
		            }
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        
		    }
		};

		
		thread.start();
	
	  
		// TODO Auto-generated constructor stub
	    
	 
	  
		
		
		
	}
	
	
		
		
	
	
	
	
	








	
		
		
		
		
		
		
		
		
		
public void Draw(Canvas canvas){
	//Circle1.drawthis(canvas);
}

private void endHand() {
	final Dialog endHandDialog = new Dialog(mycontext);
	endHandDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	endHandDialog.setContentView(R.layout.end_hand_dialog);
	endHandDialog.setCancelable(false);
	
	
	TextView endHandText = (TextView) endHandDialog.findViewById(R.id.endHandText);

			endHandText.setText("Would You like to retry?");
    Button nextHandButton = (Button) endHandDialog.findViewById(R.id.nextHandButton);
    Button NoButton = (Button) endHandDialog.findViewById(R.id.Nobutton);
    
    	
    
    nextHandButton.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
                          	
        	Intent i1 = new Intent (getContext(), MainActivity.class);
        	getContext().startActivity(i1);
			((EndGameActvity)mycontext).finish();
        }
    }); 
    
   NoButton.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
        	running = false;
        	((EndGameActvity)mycontext).finish();
                          	
        	endHandDialog.dismiss();
        }
    }); 
    endHandDialog.show();
}

@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
        // Show your Alert Box here
    }
    return false;
}



	
	
	






















public void onDraw(Canvas canvas) {
	
	
canvas.drawRect(0, 0, screenw, screenh/3, redPaint);

	
	
	
	if (white == true){
	canvas.drawRGB(255, 255, 255);
	
	}
	
	if (white == false) {
		canvas.drawRGB(0, 0, 0);
		this.clear.setColor(Color.BLACK);
		
	}
	
	
	if (reset ==2) {
		
		canvas.drawColor(0xffffffff);
		this.clear.setColor(Color.WHITE);
		}
		
	Circle1.drawthis(canvas,true);
	
	
	canvas.drawCircle(screenw/2, screenh-1085, this.radius, this.redPaint);
	
	if(circlex+50 >= screenw/2 && circlex-50 <= screenw/2
	     	&& circley+50>=screenh-1085 && circley-50<=screenh-1085) {
		
		circlex = 50;
		circley = screenh-75;
		gamewarp = gamewarp -2;
		
		if(reset == 2) {
			reset = 0;
		}
		reset = reset+1;
		score = score + 1;
		
		Circle1.setspeed(10);
    	Circle2.setspeed(10);
    	Circle3.setspeed(10);
    	Circle4.setspeed(10);
    	Circle5.setspeed(10);
		
		
	}
	
	Circle1.setspeed(60);
	Circle2.setspeed(60);
	Circle3.setspeed(60);
	Circle4.setspeed(60);
	Circle5.setspeed(60);
	
	//if(circley <= screenh-200){
		
		Circle2.drawthis(canvas,true);
	//}
	
	//if(circley <= screenh-400){
		Circle3.drawthis(canvas,true);
	//}
	
	//if(circley <= screenh-600){
		Circle4.drawthis(canvas,true);
	//}
	
	//if(circley <= screenh-800){
		Circle5.drawthis(canvas,true);
	//}
	
		
		
	 
	
	
	
	
	
	

	
	
	//The Particle Circle
	
	//canvas.drawCircle(circlex-250, this.circley, 35, this.redPaint);
	
	


	//canvas.drawRect(0, screenh-125, screenw, screenh-100, redPaint)
	//canvas.drawRect(0, screenh-225, screenw, screenh-200, redPaint);
	//canvas.drawRect(0, screenh-325, screenw, screenh-300, redPaint);
	//canvas.drawRect(0, screenh-325, screenw, screenh-300, redPaint);
	
	//canvas.drawBitmap(car,circlex-10, circley-10, circlex+10, circley+10, null);
	
	

	canvas.drawCircle(circlex3, circley, 10, redPaint);
	canvas.drawCircle(circlex3-30, circley, 10, redPaint);
	canvas.drawCircle(circlex3-50, circley, 15, clear);
	
	
	canvas.drawText(TextScore, screenw/2-(textPaint.measureText(TextScore)/2), screenh/2, textPaint);
	
	invalidate();
	
	
	
	
}








public void onSizeChanged(int x, int y, int paramInt3, int paramInt4)
{
  this.screenw = x;
  this.screenh = y;
  circley = y-75;
  Circle1 = new Endcircles(this, screenw, screenh);
  Circle2 = new Endcircles(this, screenw, screenh);
  Circle3 = new Endcircles(this, screenw, screenh);
  Circle4 = new Endcircles(this, screenw, screenh);
  Circle5 = new Endcircles(this, screenw, screenh);
  right = screenw+500;
  left = screenw+200;
  top = screenh/2;
  bottom = screenh/2+150;
  
 
  
  circlex = 50;
  circlex2 = circlex;
  
}

final Handler rhandler = new Handler(); 
Runnable RLongPressed = new Runnable() { 
    public void run() { 
    	if(touch == true) {
    	rhandler.postDelayed(this, 10);
        circlex = circlex+10;
        //circlex2 = circlex2-20;
        
        
       // right = right+20;
        //left = left+20;
        
       
        
        
       
        
        if(circlex >= screenw){
        	circlex=0;
        	circley= circley-100;
        	
        	
        	//circley= circley-100;
        	 // srcr = srcr-20;
              //srcl = srcl-20;
             
        }
        
        
        invalidate();
    	}
    }   
};

Runnable LLongPressed = new Runnable() { 
    public void run() { 
    	if(touch == true) {
        	rhandler.postDelayed(this, 10);
        	
        	
            
        	
        circlex = circlex-10;
        //left = left-20;
        //right = right-20;
        
    
        
        if(circlex <= 10){
        	circlex=10;
        	
        }
        
        if(right <= 10 ){
        	right=screenw+500;
        	left = screenw+300;
        }
        
        invalidate();
    	}
    }   
};


Runnable DLongPressed = new Runnable() { 
    public void run() { 
    	if(touch == true) {
        	rhandler.postDelayed(this, 10);
            
        	
        circley = circley+10;
        
        
        invalidate();
    	}
    }   
};

Runnable ULongPressed = new Runnable() { 
    public void run() { 
    	if(touch == true) {
        	rhandler.postDelayed(this, 10);
            
        	
        circley = circley-10;
        
        
        invalidate();
    	}
    }   
};

@Override
public boolean onTouchEvent(MotionEvent e) {
    // MotionEvent reports input details from the touch screen
    // and other input controls. In this case, you are only
    // interested in events where the touch position changed.

    float x = e.getX();
    float y = e.getY();

    

    switch (e.getAction()) {
        case MotionEvent.ACTION_DOWN:
    }
	return true;
    
        	
        	
}

private void update() {
	if (circlex2 <= circlex-10) {
		circlex2 = circlex;
		
		
	}
	circlex2 = circlex2-1;
	
}


}
	


