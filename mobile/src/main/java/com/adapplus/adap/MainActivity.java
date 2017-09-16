package com.adapplus.adap;

import android.app.Notification;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    public Button sendgood;

        public void init() {

        sendgood= (Button)findViewById(R.id.sendgood);
        sendgood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Intent notify = new Intent(sendNotification(View view);)
                public void sendNotification(View view) {
                                    Notification notification = new NotificationCompat.Builder(getApplication())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("ADAP+")
                            .setContentText("Good job!")
                            .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                            .build();
                    NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
                    int notificationId = 1;
                    notificationManager.notify(notificationId, notification);
                }
            }
        });





    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
    }
    public void sendNotification(View view) {
        String toSend = editText.getText().toString();
        if(toSend.isEmpty())
            toSend = "You sent an empty notification";
        Notification notification = new NotificationCompat.Builder(getApplication())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("ADAP+")
                .setContentText(toSend)
                .extend(new NotificationCompat.WearableExtender().setHintShowBackgroundOnly(true))
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
    }
}