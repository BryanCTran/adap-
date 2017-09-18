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
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   //Initialize edit text
    private EditText editText;
    //Initialize custom message button
    private Button actionButton;

//Firsttrybelow
   // NotificationCompat.Builder goodjob;
   // private static final int uniqueID = 456654;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //import button and edit text into protected void
        actionButton = (Button) findViewById(R.id.actionButton);
        editText = (EditText) findViewById(R.id.editText);
        //create text change listener for button disabling
        editText.addTextChangedListener(buttontextWatcher);
        //initial state is disabled to prevent accidental empty notify
        actionButton.setEnabled(false);

//Firsttry=previous method, look into this if change is needed https://www.youtube.com/watch?v=NgQzJ0s0XmM
     //   goodjob = new NotificationCompat.Builder(this);
       // goodjob.setAutoCancel(true);
    }
    //Textwatcher code
    private final TextWatcher buttontextWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        //if nothing in field, disable, else enable button
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
                .build();
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplication());
        int notificationId = 1;
        notificationManager.notify(notificationId, notification);
        //goodjobnotify().setTicker("Good Job!");

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