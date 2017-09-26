package com.adapplus.adap;

import android.app.Notification;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText editText;
//Firsttrybelow
    // NotificationCompat.Builder goodjob;
    // private static final int uniqueID = 456654;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
//Firsttry=previous method, look into this if change is needed https://www.youtube.com/watch?v=NgQzJ0s0XmM
        //   goodjob = new NotificationCompat.Builder(this);
        // goodjob.setAutoCancel(true);

    }

    //  firsttry: public void goodjobnotify(View view){
    //    goodjob.setSmallIcon(R.mipmap.ic_launcher);
    //  goodjob.setTicker("Good Job!");


    //}

    public void goodjobnotify(View view) {
        //Notification code for positive reinforcement
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("ADAP+")
                .setContentText("Good Job!")
                .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                //priority and notification code. Fix vibration
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
    }

    public void badjobnotify(View view) {
        //Notification code for negative reinforcement
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("ADAP+")
                .setContentText("Don't do that!")
                .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
    }

    public void sendNotification(View view) {
        //Notification code for custom text
        String toSend = editText.getText().toString();
        if(toSend.isEmpty())
            toSend = "You sent an empty notification";
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("ADAP+")
                .setContentText(toSend)
                .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
    }
}