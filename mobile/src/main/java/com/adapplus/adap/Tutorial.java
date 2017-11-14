package com.adapplus.adap;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class Tutorial extends AppCompatActivity {
    Button play;
    VideoView vid;
    MediaController med;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        play = (Button) findViewById(R.id.button3);
        vid = (VideoView) findViewById(R.id.vidview);
        med = new MediaController(this);
    }


    public void tuttomain(View view){
        Intent homeIntent = new Intent(Tutorial.this, MainMenu.class);
        startActivity(homeIntent);
        finish();
    }

    public void playvid(View view){
        String vidpath = "android.resource://com.adapplus.adap/" + R.raw.tut;
        Uri uri = Uri.parse(vidpath);
        vid.setVideoURI(uri);
        vid.setMediaController(med);
        med.setAnchorView(vid);
        vid.start();
    }
}
