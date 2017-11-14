package com.adapplus.adap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataLog extends AppCompatActivity {
    ArrayList<String> commands;
    TextView Read;
    Button dataloader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_log);
        commands = new ArrayList<String>();
        //loadData();
        Read = (TextView) findViewById(R.id.textView4);
        dataloader = (Button)findViewById(R.id.loadbut);
    }
    public void dattomain(View view){
        Intent homeIntent = new Intent(DataLog.this, MainMenu.class);
        startActivity(homeIntent);
        finish();


    }

    public void loadData(){
        commands.clear();
        //commands
        File file = getApplicationContext().getFileStreamPath("Data.txt");
        String lineFromFile;

        if (file.exists()){
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));

                while ((lineFromFile = reader.readLine()) != null){
                    //StringTokenizer tokens = new StringTokenizer(lineFromFile);
                    String writer = reader.readLine();
                    commands.add(writer);
                }
                reader.close();

                setTextToTextView();
            }
            catch (IOException e){

            }
        }

    }

    public void dataload(View view){
        loadData();
    }

    private void setTextToTextView(){
        String text = "";

        for (int i = 0 ; i < commands.size() ; i++){
            text = text + commands.get(i) + "\n";
        }
        Read.setText(text);
    }
}
