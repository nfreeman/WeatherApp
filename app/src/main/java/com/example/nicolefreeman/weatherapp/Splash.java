package com.example.nicolefreeman.weatherapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;

public class Splash extends Activity {

    private final int DURATION = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    public void onResume() {
        super.onResume();
        splashWelcome(DURATION);
    }

    protected void splashWelcome(final int limit) {
        Thread splashScreenThread = new Thread(){
            @Override
            public void run(){
                try{
                    int wait = 0;
                    while(wait < limit){
                        sleep(100);
                        wait +=100;
                    }
                } catch (InterruptedException e) {
                    Log.d("SplashScreen Error:", e.getMessage().toString());

                }finally {
                    Intent intent = new Intent(Splash.this, Main2Activity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
        splashScreenThread.start();
    }
}

