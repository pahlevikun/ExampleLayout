package com.example.examplelayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
public class SplashActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

            StartAnimations();

    }

    private void StartAnimations() {
        int SPLASH_TIME_OUT = 3000;
            new Handler().postDelayed(new Thread() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    SplashActivity.this.startActivity(intent);
                    SplashActivity.this.finish();
                }
            }, SPLASH_TIME_OUT);

    }

    @Override
    public void onBackPressed() {

    }

}