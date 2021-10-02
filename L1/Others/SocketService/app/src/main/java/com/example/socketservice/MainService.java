package com.example.socketservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import static android.app.Notification.FLAG_ONGOING_EVENT;

public class MainService extends Service {
    private static boolean isServiceRunning = false;
    private static final String CHANNEL_ID = "com.exemple.socketservice.MainService.CHANNEL_ID";
    private static MySocket mySocket;

    public static boolean getIsServiceRunning() {
        return isServiceRunning;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        mySocket = new MySocket(this);

        int icon = R.drawable.ic_launcher_foreground;
        CharSequence title = "Socket Service";
        CharSequence text = "Success";
        Intent intent1 = new Intent(this, MainService.class);
        PendingIntent pendingIntent = PendingIntent.getForegroundService(this, 0, intent1, 0);

        CharSequence name = "Socket Channel";
        String description = "The main service's channel";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
        channel.setDescription(description);

        Notification notif = new Notification.Builder(this)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(icon)
                .setContentIntent(pendingIntent)
                .setStyle(new Notification.BigTextStyle().bigText("The service launched successfully."))
                .setChannelId(CHANNEL_ID)
                .build();
        notif.flags = FLAG_ONGOING_EVENT;

        NotificationManager manager = (NotificationManager) getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);
        manager.notify(1, notif);

        startForeground(2, new Notification());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        isServiceRunning = true;

        new Thread(() -> mySocket.startServer()).start();
        Toast.makeText(this, "Socket Service is ready !", Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);
    }

    public static MySocket getMySocket() {
        return mySocket;
    }
}
