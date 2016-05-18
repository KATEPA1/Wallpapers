package com.james.wallpapers.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.james.wallpapers.R;
import com.james.wallpapers.Supplier;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread() {
            @Override
            public void run() {
                ((Supplier) getApplicationContext()).getNetworkResources();
                try {
                    sleep(1500);
                } catch (InterruptedException ignored) {
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                });
            }
        }.start();
    }
}