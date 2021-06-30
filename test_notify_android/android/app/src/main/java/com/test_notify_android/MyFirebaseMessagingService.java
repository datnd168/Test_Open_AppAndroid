package com.test_notify_android;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.FirebaseException;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService  extends FirebaseMessagingService {
    private static final String   TAG="Asda";
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
         Log.d(TAG,remoteMessage.toString());
        super.onMessageReceived(remoteMessage);
        getFirebaseMessageing(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody() );
    }

    public  void getFirebaseMessageing(String title,String msg){
        NotificationCompat.Builder builder =new NotificationCompat.Builder(this,"myFirebaseChannel")
                .setSmallIcon(R.drawable.redbox_top_border_background)
             .setContentTitle(title)
                .setContentText(msg)
                .setAutoCancel(true);
        NotificationManagerCompat manager= NotificationManagerCompat.from(this);
        manager.notify(101,builder.build());

    }
}
