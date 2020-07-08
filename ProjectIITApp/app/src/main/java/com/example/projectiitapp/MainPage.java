package com.example.projectiitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {
    public void toastMsg(String msg) {

        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        getSupportActionBar().hide();

        Button aboutbutton = findViewById(R.id.aboutbutton);
        final Intent movetoaboutpage = new Intent(this, AboutPage.class);
        final Intent movetochemistrypage = new Intent(this, ChemistryPage.class);
        final Intent movetoperformance = new Intent(this, Performance.class);
        final Intent movetophysicspage = new Intent(this, PhysicsPage.class);
        final Intent movetomathpage = new Intent(this, MathPage.class);
        final Intent movetovidpage = new Intent(this, VideoPage.class);
        Button chemistrybutton = findViewById(R.id.chemistrybutton), physicsbutton = findViewById(R.id.physicsbutton), mathbutton = findViewById(R.id.mathbutton);
        final Button PerformanceButton = findViewById(R.id.Performancebutton), vidbutton = findViewById(R.id.vidbutton), quizbutton = findViewById(R.id.quizgobutton);

        aboutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(movetoaboutpage);
            }
        });
        physicsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(movetophysicspage);
            }
            });
        quizbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toastMsg("Coming Soon");
            }
        });
        chemistrybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(movetochemistrypage);
            }
        });
        mathbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(movetomathpage);
            }
        });
        PerformanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(movetoperformance);
            }
        });
        mathbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(movetomathpage);
            }
        });
        vidbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(movetovidpage);
            }
        });






    }
}
