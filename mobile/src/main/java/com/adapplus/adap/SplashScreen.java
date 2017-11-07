package com.adapplus.adap;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 5000;
    public static int REQUEST_BLUETOOTH = 1;
    private BluetoothAdapter Bluestatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Bluestatus = BluetoothAdapter.getDefaultAdapter();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreen.this, MainMenu.class);
                startActivity(homeIntent);
                finish();
                if (!Bluestatus.isEnabled()){
                    Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBT, REQUEST_BLUETOOTH);
                }
            }
        },SPLASH_TIME_OUT);




    }
}
