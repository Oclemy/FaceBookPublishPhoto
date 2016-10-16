package com.tutorials.hp.facebookpublishphoto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.sromku.simple.fb.SimpleFacebook;
import com.tutorials.hp.facebookpublishphoto.mFaceBook.LogIn;
import com.tutorials.hp.facebookpublishphoto.mFaceBook.MyConfiguration;


public class MainActivity extends AppCompatActivity {

   SimpleFacebook fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         SimpleFacebook.setConfiguration(new MyConfiguration().getMyConfigs());
        fb=SimpleFacebook.getInstance(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  new LogIn(MainActivity.this,fb).login();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        fb=SimpleFacebook.getInstance(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        fb.onActivityResult(requestCode, resultCode, data);
    }
}
