package com.example.socketservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class MainReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
                Toast.makeText(context, "Socket Service is starting...", Toast.LENGTH_LONG).show();
                Intent service = new Intent(context, MainService.class);
                context.startForegroundService(service);
            } else {
                throw new Exception("Socket Service received an invalid action");
            }
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
