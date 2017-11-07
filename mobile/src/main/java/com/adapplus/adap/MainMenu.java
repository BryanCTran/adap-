package com.adapplus.adap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void maintotut(View view){
        Intent homeIntent = new Intent(MainMenu.this, Tutorial.class);
        startActivity(homeIntent);
        finish();
    }

    public void maintocom(View view){
        Intent homeIntent = new Intent(MainMenu.this, MainActivity.class);
        startActivity(homeIntent);
        finish();
    }

    public void maintodata(View view){
        Intent homeIntent = new Intent(MainMenu.this, DataLog.class);
        startActivity(homeIntent);
        finish();
    }

    public void maintoset(View view){
        Intent homeIntent = new Intent(MainMenu.this, Settings.class);
        startActivity(homeIntent);
        finish();
    }
}
