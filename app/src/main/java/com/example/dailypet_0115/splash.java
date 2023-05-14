package com.example.dailypet_0115;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splash extends AppCompatActivity {
    public void onAttachedToWindow(){
        super.onAttachedToWindow();
        Window window=getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    Thread splashTread;

    private ImageView logo2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
         logo2 = (ImageView) findViewById(R.id.splash_logo);
        Animation myanim = AnimationUtils.loadAnimation(splash.this, R.anim.fade_in);
        logo2.startAnimation(myanim);


        final Intent i = new Intent(splash.this, firstpage.class);
        Thread timer = new Thread() {
            public void run() {
                try {

                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }

        };
        timer.start();
        }
    }

