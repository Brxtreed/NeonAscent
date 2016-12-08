package com.Sciurus.NeonAscent;



import java.util.concurrent.atomic.AtomicBoolean;


import com.Sciurus.NeonAscent.R;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Handler;

import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;







public class MainMenu extends View {
	
	int screenw = 0;
	int screenh = 0;
	Paint redPaint;
	Paint TextColor;
	String StartText = "Start";
	Context context;
	
	
	public MainMenu(Context context) {
		super(context);
		this.context = context;
		
		this.redPaint = new Paint();
		this.redPaint.setAntiAlias(true);
	    this.redPaint.setColor(Color.RED);
	    
	    TextColor = new Paint(); 
	    TextColor.setColor(Color.WHITE); 
	    TextColor.setStyle(Style.FILL); 
		
	
	  
		// TODO Auto-generated constructor stub
	    
	  
	   Thread thread = new Thread() {
		    @Override
		    public void run() {
		    	
		    	
		        try {
		        	
		            while(true) {
		                
		                sleep(50);
		             
		                
		                
		             
		                
		               
		            }
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        
		    }
		};

		
		thread.start();
		
		
		
	}
	








	
		
		
		
		
		
		
		
		
		
public void Draw(Canvas canvas){
	//Circle1.drawthis(canvas);
}

	
	
	






















public void onDraw(Canvas canvas) {
	
	
	
	
	
	
	
	
	
	canvas.drawRect(0, 0, screenw, screenh/3, redPaint);
	
	canvas.drawText(StartText, screenw/2, screenh/3-50, TextColor);
	

	
		
		//canvas.drawRect(0, screenh-285, screenw, screenh-275, redPaint);

	invalidate();
	
	
}








public void onSizeChanged(int x, int y, int paramInt3, int paramInt4)
{
  this.screenw = x;
  this.screenh = y;
  
  
}


@Override
public boolean onTouchEvent(MotionEvent e) {
    // MotionEvent reports input details from the touch screen
    // and other input controls. In this case, you are only
    // interested in events where the touch position changed.

    float x = e.getX();
    float y = e.getY();

    switch (e.getAction()) {
        case MotionEvent.ACTION_DOWN:
        	
        	
        	 // Go Left
            if (x<getWidth()/2){
            	
            	Intent i1 = new Intent (getContext(), MainActivity.class);
            	getContext().startActivity(i1);

            	           	
            	 	invalidate();
            	return true;
            }
            
            //Go Right
            if (x>getWidth()/2){
            	
            	
            	invalidate();
            	return true;
              
            }


        	
        case MotionEvent.ACTION_UP: {
        	
  
             
        }
        
        case MotionEvent.ACTION_MOVE: {

           
        }

           
    }
    
    

    
    return true;
}

}
	


