package com.ideotic.edioticideas.aaya;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by Mukul on 13-05-2016.
 */
public class Splash extends Activity {

    private static int SPLASH_TIMER_COUNT = 5000;
//    private LottieAnimationView lan;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        lan = findViewById(R.id.imageViewLogo);
//        lan.setVisibility(View.VISIBLE);
//        lan.playAnimation();
        new Handler().postDelayed(new Runnable() {

            //showing splash screen with timer..

            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
                if (pref.getBoolean("activity_executed", false)) {
                    Intent intent = new Intent(Splash.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    SharedPreferences.Editor ed = pref.edit();
                    ed.putBoolean("activity_executed", true);
                    ed.commit();
                    //Starts needs activity
                    Intent intent = new Intent(Splash.this, Needs.class);
                    startActivity(intent);
                }


                //closes splash
                finish();
            }
        }, SPLASH_TIMER_COUNT);
    }
}
