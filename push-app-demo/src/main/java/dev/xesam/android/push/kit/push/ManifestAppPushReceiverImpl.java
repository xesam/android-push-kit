package dev.xesam.android.push.kit.push;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import dev.xesam.android.push.kit.R;
import dev.xesam.android.push.kit.api.CoreAppPushReceiver;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class ManifestAppPushReceiverImpl extends CoreAppPushReceiver {
    public static final String TAG = "ManifestAppPushReceiver";

    @Override
    protected IntentFilter getIntentFilter(Context context) {
        return null;
    }

    @Override
    protected int getPriority() {
        return 1;
    }

    @Override
    protected boolean onHandleReceive(Context context, Intent intent) {
        Log.w(TAG, "onHandleReceive");
        Parcelable data = CoreAppPushReceiver.getAppPushMsg(intent);
        Log.w(TAG, data.toString());
        return true;
    }

    private void postNotification(Context context) {
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("this is title")
                .setContentText("this is content")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(null)
                .setDeleteIntent(null)
                .build();

    }
}
