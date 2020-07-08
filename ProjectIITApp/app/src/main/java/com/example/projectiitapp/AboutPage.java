package com.example.projectiitapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AboutPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        getSupportActionBar().hide();

        //EditText mEdit2 = (EditText) findViewById(R.id.editText2);
        //mEdit2.setEnabled(false);
}}
