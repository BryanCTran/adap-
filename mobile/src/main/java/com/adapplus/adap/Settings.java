package com.adapplus.adap;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    Spinner viblist;
    String intensitylist[] = {"Pattern 1","Pattern 2", "Pattern 3"};
    ArrayAdapter<String> adapterviblist;

    Spinner viblistneg;

    ArrayAdapter<String> adapterviblistneg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        viblist = (Spinner) findViewById(R.id.spinner4);

        adapterviblist = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, intensitylist);
        adapterviblist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viblist.setAdapter(adapterviblist);


        viblistneg = (Spinner) findViewById(R.id.spinner3);

        adapterviblistneg = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, intensitylist);
        adapterviblistneg.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viblistneg.setAdapter(adapterviblistneg);


    }

    public void posmesclick(View view){
        Context context = getApplicationContext();
        CharSequence text = "Default Message Saved!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void negmesclick(View view){
        Context context = getApplicationContext();
        CharSequence text = "Default Message Saved!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void posvibclick(View view){
        Context context = getApplicationContext();
        CharSequence text = "Default Vibration Saved!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void negvibclick(View view){
        Context context = getApplicationContext();
        CharSequence text = "Default Vibration Saved!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void settomain(View view){
        Intent homeIntent = new Intent(Settings.this, MainMenu.class);
        startActivity(homeIntent);
        finish();
    }
}
