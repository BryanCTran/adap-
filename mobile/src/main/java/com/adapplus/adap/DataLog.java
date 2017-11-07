package com.adapplus.adap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DataLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_log);
    }
    public void dattomain(View view){
        Intent homeIntent = new Intent(DataLog.this, MainMenu.class);
        startActivity(homeIntent);
        finish();


    }
}
