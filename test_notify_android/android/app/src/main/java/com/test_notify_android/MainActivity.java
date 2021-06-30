package com.test_notify_android;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.ReactActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {

    FirebaseMessaging.getInstance().subscribeToTopic("weather")
            .addOnCompleteListener(new OnCompleteListener<Void>() {
              @Override
              public void onComplete(@NonNull Task<Void> task) {
                String msg = "done";
                if (!task.isSuccessful()) {
                  msg = "fail";
                }

              }
            });
    return "test_notify_android";
  }
}
