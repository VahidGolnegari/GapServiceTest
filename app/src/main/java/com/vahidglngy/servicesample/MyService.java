package com.vahidglngy.servicesample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {

    private final int MY_ID = 2001;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,createChannelId(notificationManager));
            builder.setContentText("Gap Sampple Test");
            builder.setContentTitle("Test");
            builder.setSmallIcon(R.drawable.ic_launcher_foreground);
            builder.setAutoCancel(true);
            Notification notification = builder.build();
            startForeground(MY_ID,notification);

        } else {
            Log.d("service","isStarted");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("servise","destroyed");
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private String createChannelId(NotificationManager notificationManager) {
        String channelId = "GapChannelId";
        String channelName = "GapChannelName";
        NotificationChannel notificationChannel = new NotificationChannel(channelId,channelName,NotificationManager.IMPORTANCE_HIGH);
        notificationManager.createNotificationChannel(notificationChannel);
        return channelId;
    }

}
