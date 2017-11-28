package com.adapplus.adap;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    //declaring the editText for the custom command
    private EditText editText;
    //declaring the Button for custom command
    private Button actionButton;
    //declaring the audiomanager for silencing
    private AudioManager myAudioManager;
    AudioManager mode = null;
    //declaring the arraylist for storing commands
    ArrayList<String> commands;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionButton = (Button) findViewById(R.id.actionButton);
        editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(buttontextWatcher);
        actionButton.setEnabled(false);
        mode = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        commands = new ArrayList<String>();




    }

    private final TextWatcher buttontextWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after){

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {
                actionButton.setEnabled(false);
            }else{
                actionButton.setEnabled(true);
            }
        }


    };


    public void comtomain (View view){
        Intent homeIntent = new Intent(MainActivity.this, MainMenu.class);
        startActivity(homeIntent);
        finish();


    }

    public void goodjobnotify(View view) {
        //Notification code for positive
        mode.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("ADAP+")
                .setContentText("Good Job!")
                .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                //priority and notification code. Fix vibration
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSmallIcon(R.drawable.ic_stat_name) //simple smiley face
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
        //Toast notification for message confirmation
        Context context = getApplicationContext();
        CharSequence text = "Message sent!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        //Data Logging
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String good = currentDateTimeString + " Good_Command";
        commands.add(currentDateTimeString);
        commands.add(good);
        //for (int i = 0 ; i < commands.size() ; i++){
        //    text = text + commands.get(i) + "" + "\n"
       // }
        try{
            FileOutputStream file = openFileOutput("Data.txt", MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);

            for (int i = 0 ; i < commands.size() ; i++){
                outputFile.write(commands.get(i) + "\n");
            }
            outputFile.flush();
            outputFile.close();
        }
        catch (IOException e){

        }
    }

    public void badjobnotify(View view) {
        mode.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        //Notification code for negative reinforcement
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("ADAP+")
                .setContentText("Don't do that!")
                .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSmallIcon(R.drawable.ic_stat_name2) //simple angry face
                .setVibrate(new long[]{100, 100, 100, 100, 100, 100, 100,100,100,100,100})
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
        //Toast notification for message confirmation
        Context context = getApplicationContext();
        CharSequence text = "Message sent!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //Data Logging
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String bad = currentDateTimeString + " Bad_Command";
        commands.add(currentDateTimeString);
        commands.add(bad);
        //for (int i = 0 ; i < commands.size() ; i++){
        //    text = text + commands.get(i) + "" + "\n"
        // }
        try{
            FileOutputStream file = openFileOutput("Data.txt", MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);

            for (int i = 0 ; i < commands.size() ; i++){
                outputFile.write(commands.get(i) + "\n");
            }
            outputFile.flush();
            outputFile.close();
        }
        catch (IOException e){

        }
    }

    public void sendNotification(View view) {
        mode.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        //Notification code for custom text
        String toSend = editText.getText().toString();
        //if(toSend.isEmpty())
          //  toSend = "You sent an empty notification";
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("ADAP+")
                .setContentText(toSend)
                .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setVibrate(new long[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50})
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);



        //Toast notification for message confirmation
        Context context = getApplicationContext();
        CharSequence text = "Message sent!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //Data Logging
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String custom = currentDateTimeString + " Custom_Command";
        commands.add(currentDateTimeString);
        commands.add(custom);
        //for (int i = 0 ; i < commands.size() ; i++){
        //    text = text + commands.get(i) + "" + "\n"
        // }
        try{
            FileOutputStream file = openFileOutput("Data.txt", MODE_PRIVATE);
            OutputStreamWriter outputFile = new OutputStreamWriter(file);

            for (int i = 0 ; i < commands.size() ; i++){
                outputFile.write(commands.get(i) + "\n");
            }
            outputFile.flush();
            outputFile.close();
        }
        catch (IOException e){

        }
    }



}
