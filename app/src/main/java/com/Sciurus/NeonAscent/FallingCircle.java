package com.Sciurus.NeonAscent;



import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


import com.Sciurus.NeonAscent.Levels.BlackandWhite;

public class FallingCircle {
	 int[] DIRECTION_TO_ANIMATION_MAP = { 3, 1, 0, 2 };
	int currentframe = 0;
	public int circlex = 0;
	public int circley = 0;
	int screenw = 0;
	int screenh = 0;
	int velocity = 0;

       private int ySpeed;
       int bwidth = 0;
       int bheight = 0;
       gameview gameview;
       EndGameView Endgame;
	   BlackandWhite blackandwhite;
       Random number;
       int speed = 30;
       //boolean running = true;
       int randomcolor;
       volatile boolean running = true;
       int radius = 20;
      
      
       Paint white;
 
     int width = 0;
     int height = 0;
     int randomradi = 0;
      
       public FallingCircle(gameview gameview, int screenw, int screenh) {
    	   
    	   this.gameview = gameview;
    	   this.screenw = screenw;
    	   this.screenh = screenh;
    	   System.out.println("Screen height is" +screenh);
    	  
             
             white = new Paint();
             white.setAntiAlias(true);
             white.setColor(Color.RED);
             circley = 0;
            
             
             
           
     	   
     		
     		
     		number = new Random();
     		velocity = number.nextInt(10)+5;
     		circlex = number.nextInt(screenw);
     		//circlex = number.nextInt(1000);
     		randomcolor = number.nextInt(3);
     		circley = number.nextInt(1000);
     		
     		if(randomcolor == 0) {
     			//Orange Color
     			white.setColor(Color.GREEN);
     			
     		}
     		
     		if(randomcolor == 1) {
     			white.setColor(Color.WHITE);
     		}
     		
     		if(randomcolor == 2) {
     			//Pink Color
     			white.setColor(Color.WHITE);
     		}
     		 Thread thread = new Thread() {
     		    @Override
     		    public void run() {
     		    	
     		        try {
     		        	
     		            while(running == true) {
     		                
     		                sleep(speed);
     		                update();
     		                
     		                
     		                
     		             
     		                
     		               
     		            }
     		        } catch (InterruptedException e) {
     		            e.printStackTrace();
     		        }
     		        
     		    }
     		};

     		
     		thread.start();
       }
       
public FallingCircle(EndGameView gameend, int screenw, int screenh) {
    	   
    	   this.Endgame = gameend;
    	   this.screenw = screenw;
    	   this.screenh = screenh;
    	   System.out.println("Screen height is" +screenh);
    	  
             
             white = new Paint();
             white.setAntiAlias(true);
             white.setColor(Color.RED);
             circley = 0;
            
             
             
           
     	   
     		
     		
     		number = new Random();
     		velocity = number.nextInt(10)+5;
     		circlex = number.nextInt(screenw);
     		//circlex = number.nextInt(1000);
     		randomcolor = number.nextInt(3);
     		circley = number.nextInt(1000);
     		
     		if(randomcolor == 0) {
     			//Orange Color
				white.setColor(Color.RED);
     			
     		}
     		
     		if(randomcolor == 1) {
     			white.setColor(Color.WHITE);
     		}
     		
     		if(randomcolor == 2) {
     			//Pink Color
				white.setColor(Color.GREEN);
     		}
     		 Thread thread = new Thread() {
     		    @Override
     		    public void run() {
     		    	
     		        try {
     		        	
     		            while(running == true) {
     		                
     		                sleep(speed);
     		                update();
     		                
     		                
     		                
     		             
     		                
     		               
     		            }
     		        } catch (InterruptedException e) {
     		            e.printStackTrace();
     		        }
     		        
     		    }
     		};

     		
     		thread.start();
       }


	public FallingCircle(BlackandWhite blackAndWhite, int screenw, int screenh) {

		this.blackandwhite = blackAndWhite;
		this.screenw = screenw;
		this.screenh = screenh;
		System.out.println("Screen height is" +screenh);


		white = new Paint();
		white.setAntiAlias(true);
		white.setColor(Color.RED);
		circley = 0;







		number = new Random();
		velocity = number.nextInt(10)+5;
		circlex = number.nextInt(screenw);
		//circlex = number.nextInt(1000);
		randomcolor = number.nextInt(3);
		circley = number.nextInt(1000);

		if(randomcolor == 0) {
			//Orange Color
			white.setColor(Color.GREEN);

		}

		if(randomcolor == 1) {
			white.setColor(Color.WHITE);
		}

		if(randomcolor == 2) {
			//Pink Color
			white.setColor(Color.WHITE);
		}
		Thread thread = new Thread() {
			@Override
			public void run() {

				try {

					while(running == true) {

						sleep(speed);
						updatecode();






					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};


		thread.start();
	}
     		
     		
     	
       
       
      
		
		
	

     		
             
       
       
       
       
       public void setx(int touch){
    	   
    	   
       }
       
       private void update() {
    	   circley = circley+velocity;
    	   if(circley>= screenh + 500) {
    		   circley = 0;
    		   velocity = number.nextInt(10)+5;
    		   circlex= number.nextInt(screenw)+100;
    		   radius = 20;
    		   
    		   randomcolor = number.nextInt(3);
    		   randomradi = number.nextInt(10);
        		
        		if(randomcolor == 0) {
        			//orange color
					white.setColor(Color.GREEN);
        			
        		}
        		
        		if(randomcolor == 1) {
					white.setColor(Color.WHITE);
        		}
        		
        		if(randomcolor == 2) {
					white.setColor(Color.GREEN);
        		}
    	   }
    	   
    	   	
    	 
       }

	private void updatecode() {
		circley = circley+velocity;
		if(circley>= screenh + 500) {
			circley = 0;
			velocity = number.nextInt(10)+5;
			circlex= number.nextInt(screenw)+100;
			radius = 20;

			randomcolor = number.nextInt(3);
			randomradi = number.nextInt(10);

			if(randomcolor == 0) {
				//orange color
				white.setColor(Color.rgb(0, 153, 51));

			}

			if(randomcolor == 1) {
				white.setColor(Color.rgb(0, 230, 77));
			}

			if(randomcolor == 2) {
				white.setColor(Color.rgb(128, 255, 170));
			}
			}
		}




       
public void setspeed(int x){
	
	speed = x;
    	   
    	
       }
       public void drawthis(Canvas canvas, boolean running) {
             
            this.running = running; 
           //update();
         	
         	canvas.drawCircle(circlex, circley, radius, white);
         	canvas.drawRect(circlex-1, circley-300,circlex+1, circley-5, white);
        	
    	   
    	   System.out.println("Drawing sucess");
             //canvas.drawCircle(x, y , 50, white);
             
       }
       
     
}
