package dev.xesam.android.push.kit.push;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import dev.xesam.android.push.kit.R;
import dev.xesam.android.push.kit.api.AppPushMsg;
import dev.xesam.android.push.kit.api.CoreAppPushReceiver;
import dev.xesam.android.push.kit.model.BizType;

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
        AppPushMsg data = CoreAppPushReceiver.getAppPushMsg(intent);
        if (data.getType() == BizType.TYPE_A) {
            Log.w(TAG, "TYPE_A:" + data.toString());
        } else if (data.getType() == BizType.TYPE_B) {
            Log.w(TAG, "TYPE_B:" + data.toString());
        } else if (data.getType() == BizType.TYPE_C) {
            Log.w(TAG, "TYPE_C:" + data.toString());
        }
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
