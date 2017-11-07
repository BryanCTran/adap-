package com.adapplus.adap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void settomain(View view){
        Intent homeIntent = new Intent(Settings.this, MainMenu.class);
        startActivity(homeIntent);
        finish();
    }
}
