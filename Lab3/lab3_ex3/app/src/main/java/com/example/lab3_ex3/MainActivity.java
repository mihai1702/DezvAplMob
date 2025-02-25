package com.example.lab3_ex3;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    boolean daytime=true;
    boolean autoisON=false;

    private void customColors(View layout) {
        int currentColor = Color.WHITE; // Culoare implicită

        if (layout.getBackground() instanceof ColorDrawable) {
            currentColor = ((ColorDrawable) layout.getBackground()).getColor();
        }

        int newColor;
        switch (currentColor) {
            case Color.WHITE:
                newColor = Color.BLUE;
                sendNotification("Relaxation mode activated!");
                break;
            case Color.BLUE:
                newColor = Color.RED;
                sendNotification("Alert mode activated");
                break;
            case Color.RED:
                newColor = Color.GREEN;
                sendNotification("Nature mode activated");
                break;
            default:
                newColor = Color.WHITE;
                sendNotification("Standard mode activated");
                break;
        }

        layout.setBackgroundColor(newColor);
    }




    public int timeOfDay(){
        Calendar calendar= Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR_OF_DAY);
        int minute=calendar.get(Calendar.MINUTE);
        ///night time
        if(hour>=22 || hour<7)
            return 0;
        ///morning
        if(hour>=7 && hour<18)
            return 1;
        ///evening
        return 2;
    }
    private static final String CHANNEL_ID = "my_channel";
    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "My Channel",
                    NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }
    public void sendNotification(String textMessage){
        NotificationManager  notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent= new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Notification")
                .setContentText(textMessage)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);
        notificationManager.notify(1, builder.build());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button turnONOFFButton=findViewById(R.id.turnONOFFButton);
        Button autoButton=findViewById(R.id.autoButton);
        View layout=findViewById(R.id.main);
        TextView autoText=findViewById(R.id.autoTextView);
        Button customButton=findViewById(R.id.customButton);

        createNotificationChannel();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 101);
        }

        turnONOFFButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(daytime)
                {
                    daytime=false;
                    layout.setBackgroundColor(Color.GRAY);
                }
                else{
                    layout.setBackgroundColor(Color.YELLOW);
                    daytime=true;
                }
            }
        });
        autoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(autoisON)
                {
                    autoText.setText("Auto is OFF");
                    autoisON=false;
                }
                else if(autoisON==false)
                {
                    autoText.setText("Auto is ON");
                    autoisON=true;
                    int timeOfTheDay=timeOfDay();
                    if(timeOfTheDay==0) {
                        layout.setBackgroundColor(Color.GRAY);
                        sendNotification("Good Night! The light has turned off automatically");

                    }
                    else if(timeOfTheDay==1) {
                        layout.setBackgroundColor(Color.WHITE);
                        sendNotification("Good morning! Do you need more light?");
                    }
                    else if(timeOfTheDay==2) {
                        layout.setBackgroundColor(Color.YELLOW);
                    }
                }
            }
        });

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customColors(layout);
            }
        });
    }
}