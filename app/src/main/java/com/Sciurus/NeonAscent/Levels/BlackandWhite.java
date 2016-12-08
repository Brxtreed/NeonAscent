package com.Sciurus.NeonAscent.Levels;


/**
 * Created by Braxton on 12/18/2015.
 */



import java.util.concurrent.atomic.AtomicBoolean;


        import com.Sciurus.NeonAscent.EndGameActvity;
        import com.Sciurus.NeonAscent.FallingCircle;
        import com.Sciurus.NeonAscent.MainActivity;
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







public class BlackandWhite extends View {

    boolean running = true;


    int collision = 0;
    int lives = 3;
    int score = 1;
    boolean touch = false;
    boolean actionDownFlag = true;
    Paint redPaint;
    String TextScore = "Level " + score ;
    String Lives = "OOO";
    Paint particle;
    Paint whitePaint;
    Paint grey;
    Paint textPaint;
    int radius = 25;
    int circley = 50;
    int circlex = 50;
    int screenw = 0;
    int screenh = 0;
    FallingCircle Circle1;
    FallingCircle Circle2;
    FallingCircle Circle3;
    FallingCircle Circle4;
    FallingCircle Circle5;
    int circlex2;
    int circlex3;
    Bitmap car;
    int bwidth;
    int bheight;
    int reset = 0;
    int gamewarp = 30;
    Paint clear;
    int speed = 10;
    int left = 0;
    int right = 0;
    int bottom = 0;
    int top = 0;
    Context mycontext;

    public BlackandWhite(Context context, Bitmap bitmap) {
        super(context);


        this.mycontext = context;






        //Initilizes and sets the red paint
        this.redPaint = new Paint();
        this.redPaint.setAntiAlias(true);
        this.redPaint.setColor(Color.rgb(128, 255, 170));


        //Initilizes and sets the particle color
        this.particle = new Paint();
        this.particle.setAntiAlias(true);
        this.particle.setColor(Color.WHITE);


        //Initilizes and sets the white paint color
        this.whitePaint = new Paint();
        this.whitePaint.setAntiAlias(true);
        this.whitePaint.setColor(Color.WHITE);

        //Initilizes and sets the grey paint color
        this.grey = new Paint();
        this.grey.setAntiAlias(true);
        this.grey.setColor(Color.LTGRAY);



        //Initilizes and sets the clear paint color
        this.clear = new Paint();
        this.clear.setAntiAlias(true);
        this.clear.setColor(Color.BLACK);

        this.textPaint = new Paint();
        textPaint.setColor(Color.GREEN);
        textPaint.setTextSize(50);








        circlex = 40;




        //Initilizes and starts the game thread
        Thread thread = new Thread() {
            @Override
            public void run() {
                circlex3 = circlex;


                try {

                    while(running) {


                        sleep(50);

                        if (circlex <= 20) {
                            circlex3 = circlex;
                        }


                        circlex3 = circlex3-20;
                        if(circlex3<= circlex-300){
                            circlex3= circlex;
                        }










                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };


        thread.start();



    }


    //Collision check

    public void checkcollid() {

        //Changes the text to reflect the number of lives the player contains

        if (collision == 1) {
            Lives = "OO-";
            ((MainActivity)mycontext).playSong(1);
        }

        if (collision == 2) {
            Lives = "O--";
            ((MainActivity)mycontext).playSong(2);
        }

        if (collision == 3) {
            System.out.println("collision is" + collision);

            Intent i1 = new Intent (getContext(), EndGameActvity.class);
            getContext().startActivity(i1);
            ((MainActivity)mycontext).finish();
            running = false;

        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            running = false;
            //((MainActivity)mycontext).finish();
        }
        return false;
    }

    public void setrun(boolean run) {
        running = run;

    }


    //Draws the various circles and player point
    public void onDraw(Canvas canvas) {

        if(collision == 0|| collision == 2) {

            canvas.drawRect(0, 0, screenw, screenh / 3, redPaint);
            canvas.drawRGB(0, 0, 0);

            if(collision == 2) {
                canvas.drawRect(0,0,screenw,screenh/2, whitePaint);
                particle.setColor(Color.WHITE);
            }
        }

        if (collision == 1){
            canvas.drawRGB(255, 255, 255);
            particle.setColor(Color.WHITE);
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

            //Sets the falling circles speed

            Circle1.setspeed(gamewarp);
            Circle2.setspeed(gamewarp);
            Circle3.setspeed(gamewarp);
            Circle4.setspeed(gamewarp);
            Circle5.setspeed(gamewarp);


        }



        Circle2.drawthis(canvas,true);
        Circle3.drawthis(canvas,true);
        Circle4.drawthis(canvas,true);
        Circle5.drawthis(canvas,true);




        //Respawns the various falling circles once they fall to the bottom

        if(circlex+50 >= Circle1.circlex && circlex-50 <= Circle1.circlex
                && circley+50>=Circle1.circley && circley-50<=Circle1.circley)
        {
            circlex = 50;
            circley = screenh- 75;
            collision = collision +1;
            checkcollid();





        }
        if(circlex+40 >= Circle2.circlex && circlex-40 <= Circle2.circlex
                && circley+40>=Circle2.circley && circley-40<=Circle2.circley)
        {
            circlex = 50;
            circley = screenh - 75;
            collision = collision +1;
            checkcollid();



        }
        if(circlex+40 >= Circle3.circlex && circlex-40 <= Circle3.circlex
                && circley+40>=Circle3.circley && circley-40<=Circle3.circley)
        {
            circlex = 50;
            circley = screenh - 75;
            collision = collision +1;
            checkcollid();



        }
        if(circlex+40 >= Circle4.circlex && circlex-40 <= Circle4.circlex
                && circley+40>=Circle4.circley && circley-40<=Circle4.circley)
        {
            circlex = 50;
            circley = screenh - 75;
            collision = collision +1;
            checkcollid();


        }

        if(circlex+40 >= Circle5.circlex && circlex-40 <= Circle5.circlex
                && circley+40>=Circle5.circley && circley-40<=Circle5.circley)
        {
            circlex = 50;
            circley = screenh - 50;
            collision = collision +1;
            checkcollid();

        }









        canvas.drawRect(left, top, right, bottom, grey);


        //Draws the trailing circle reticule
        canvas.drawCircle(this.circlex, this.circley, this.radius, this.redPaint);



        /* Methods that Draw the particles Rectangle Stream */

        if(circley <= screenh-75){
            canvas.drawRect(0, screenh-25, screenw, screenh, redPaint);

        }

        if(circley <= screenh-225){

            canvas.drawRect(0, screenh-185, screenw, screenh-175, redPaint);
        }

        if(circley <= screenh-325){

            canvas.drawRect(0, screenh-285, screenw, screenh-275, redPaint);
        }

        if(circley <= screenh-425){

            canvas.drawRect(0, screenh-385, screenw, screenh-375, redPaint);
        }

        if(circley <= screenh-525){

            canvas.drawRect(0, screenh-485, screenw, screenh-475, redPaint);
        }

        if(circley <= screenh-625){

            canvas.drawRect(0, screenh-585, screenw, screenh-575, redPaint);
        }

        if(circley <= screenh-725){

            canvas.drawRect(0, screenh-685, screenw, screenh-675, redPaint);
        }

        if(circley <= screenh-825){

            canvas.drawRect(0, screenh-785, screenw, screenh-775, redPaint);
        }

        if(circley <= screenh-925){

            canvas.drawRect(0, screenh-885, screenw, screenh-875, redPaint);
        }

        if(circley <= screenh-1025){

            canvas.drawRect(0, screenh-985, screenw, screenh-975, redPaint);
        }

        if(circley <= screenh-1125){

            canvas.drawRect(0, screenh-1085, screenw, screenh-1075, redPaint);
        }


        canvas.drawRect(0, circley-5, circlex+5, circley+5, redPaint);



        Rect src = new Rect (0,0, bwidth,bheight);
        Rect dst = new Rect (circlex-50, circley-75, circlex+50, circley+75);
        canvas.drawCircle(circlex3, circley, 10, redPaint);
        canvas.drawCircle(circlex3-30, circley, 10, redPaint);
        canvas.drawCircle(circlex3-50, circley, 15, clear);

        canvas.drawBitmap(car, src, dst, null);
        TextScore = "Level " + score;
        canvas.drawText(TextScore, screenw/10, screenh/10, textPaint);
        canvas.drawText("Shields " + Lives, screenw/10, screenh/ 8, textPaint);

        invalidate();




    }








    public void onSizeChanged(int x, int y, int paramInt3, int paramInt4)
    {
        this.screenw = x;
        this.screenh = y;
        circley = y-75;
        Circle1 = new FallingCircle(this, screenw, screenh);
        Circle2 = new FallingCircle(this, screenw, screenh);
        Circle3 = new FallingCircle(this, screenw, screenh);
        Circle4 = new FallingCircle(this, screenw, screenh);
        Circle5 = new FallingCircle(this, screenw, screenh);
        right = screenw+500;
        left = screenw+200;
        top = screenh/2;
        bottom = screenh/2+150;



        circlex = 50;
        circlex2 = circlex;

    }


    //Handles the touch input for contious running
    final Handler rhandler = new Handler();
    Runnable RLongPressed = new Runnable() {
        public void run() {
            if(touch == true) {
                rhandler.postDelayed(this, 10);
                circlex = circlex+10;
                if(circlex >= screenw){
                    circlex=0;
                    circley= circley-100;
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


                // Go Left
                if (x<getWidth()/2){
                    touch = true;
                    circlex = circlex-10;
                    rhandler.postDelayed(LLongPressed, 10);
                    actionDownFlag = true;
                    speed = 100;
                    Circle1.setspeed(50);
                    Circle2.setspeed(50);
                    Circle3.setspeed(50);
                    Circle4.setspeed(50);
                    Circle5.setspeed(50);










                    invalidate();


                    return true;
                }

                //Go Right
                if (x>getWidth()/2){
                    touch = true;
                    circlex = circlex+2;
                    rhandler.postDelayed(RLongPressed, 10);
                    actionDownFlag = true;
                    speed = 10;
                    Circle1.setspeed(gamewarp);
                    Circle2.setspeed(gamewarp);
                    Circle3.setspeed(gamewarp);
                    Circle4.setspeed(gamewarp);
                    Circle5.setspeed(gamewarp);

                    update();

                    invalidate();
                    return true;

                }

                
            case MotionEvent.ACTION_UP: {
                touch = false;


            }

            case MotionEvent.ACTION_MOVE: {


            }


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



