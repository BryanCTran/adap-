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
import android.widget.Toast;
import android.widget.VideoView;

public class Tutorial extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        VideoView vv = (VideoView)findViewById(R.id.vidview);
        String path = Environment.getExternalStorageDirectory().getPath()+"/tut.mp4";
        vv.setVideoPath(path);
        vv.start();
    }


    public void tuttomain(View view){
        Intent homeIntent = new Intent(Tutorial.this, MainMenu.class);
        startActivity(homeIntent);
        finish();

    }

    public void playvid(View view){
        Context context = getApplicationContext();
        CharSequence text = "Nothing here yet!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
