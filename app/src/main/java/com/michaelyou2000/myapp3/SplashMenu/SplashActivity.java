package com.michaelyou2000.myapp3.SplashMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.michaelyou2000.myapp3.HomeActivity;
import com.michaelyou2000.myapp3.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread((new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);

                        startActivity(new Intent(SplashActivity.this, HomeActivity.class));

                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }));
        thread.start();


    }



}