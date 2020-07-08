package com.example.projectiitapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int SPLASH_TIMEOUT = 1000;
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent homeIntent = new Intent(MainActivity.this, MainPage.class);
                startActivity(homeIntent);
                finish();
            }

        },SPLASH_TIMEOUT);


    }
}
