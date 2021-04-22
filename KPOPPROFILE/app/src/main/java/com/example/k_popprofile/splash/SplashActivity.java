package com.example.k_popprofile.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.k_popprofile.MainActivity;
import com.example.k_popprofile.R;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            Intent home = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(home);
            finish();
                }, SPLASH_TIME

        );
    }
}