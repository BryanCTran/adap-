package com.adapplus.adap;

import android.app.Notification;
import android.content.Context;
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

import static com.adapplus.adap.R.raw.silence;


public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button actionButton;

//Firsttrybelow
    // NotificationCompat.Builder goodjob;
    // private static final int uniqueID = 456654;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionButton = (Button) findViewById(R.id.actionButton);
        editText = (EditText) findViewById(R.id.editText);
        editText.addTextChangedListener(buttontextWatcher);
        actionButton.setEnabled(false);
//Firsttry=previous method, look into this if change is needed https://www.youtube.com/watch?v=NgQzJ0s0XmM
        //   goodjob = new NotificationCompat.Builder(this);
        // goodjob.setAutoCancel(true);


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
    }

    public void badjobnotify(View view) {
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
    }

    public void sendNotification(View view) {
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
    }


}