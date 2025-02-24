package com.example.safealertapp;

import android.content.Context;
import android.telephony.SmsManager;
import android.widget.Toast;

public class emergContact {
    public String name;
    public String phoneNumber;

    public emergContact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void sendEmergMessage(Context context, String locationLink) {
        String Message1 = "This is an automated message. This person set your contact as an emergency contact. "+" The location is: "+locationLink;;

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, Message1, null, null);

            Toast.makeText(context, "Mesaj trimis la " + name, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(context, "Eroare la trimiterea mesajului", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
