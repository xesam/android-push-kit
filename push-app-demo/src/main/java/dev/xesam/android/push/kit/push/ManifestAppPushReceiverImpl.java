package dev.xesam.android.push.kit.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import dev.xesam.android.push.kit.R;
import dev.xesam.android.push.kit.api.AppPushMsg;
import dev.xesam.android.push.kit.api.CoreAppPushReceiver;
import dev.xesam.android.push.kit.api.CoreNotificationReceiver;
import dev.xesam.android.push.kit.api.NotificationHelper;
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
        AppPushMsg msg = CoreAppPushReceiver.getAppPushMsg(intent);
        if (msg.getType() == BizType.TYPE_A) {
            Log.w(TAG, "TYPE_A:" + msg.toString());
            Intent clickIntent = new Intent(context, NotificationReceiverImpl.class);
            NotificationHelper.setActionCode(clickIntent, NotificationHelper.ACTION_CLICK);
            Intent deleteIntent = new Intent(context, NotificationReceiverImpl.class);
            NotificationHelper.setActionCode(deleteIntent, NotificationHelper.ACTION_DISMISS);
            CoreNotificationReceiver.putMsg(clickIntent, msg);
            CoreNotificationReceiver.putMsg(deleteIntent, msg);
            postNotification(
                    context,
                    PendingIntent.getBroadcast(context, 1, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT),
                    PendingIntent.getBroadcast(context, 2, deleteIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            );
        } else if (msg.getType() == BizType.TYPE_B) {
            Log.w(TAG, "TYPE_B:" + msg.toString());
            Intent clickIntent = new Intent(context, NotificationReceiverImpl.class);
            NotificationHelper.setActionCode(clickIntent, NotificationHelper.ACTION_CLICK);
            Intent deleteIntent = new Intent(context, NotificationReceiverImpl.class);
            NotificationHelper.setActionCode(deleteIntent, NotificationHelper.ACTION_DISMISS);
            CoreNotificationReceiver.putMsg(clickIntent, msg);
            CoreNotificationReceiver.putMsg(deleteIntent, msg);
            postNotification(
                    context,
                    PendingIntent.getBroadcast(context, 1, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT),
                    PendingIntent.getBroadcast(context, 2, deleteIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            );
        } else if (msg.getType() == BizType.TYPE_C) {
            Log.w(TAG, "TYPE_C:" + msg.toString());
            Intent clickIntent = new Intent(context, NotificationReceiverImpl.class);
            NotificationHelper.setActionCode(clickIntent, NotificationHelper.ACTION_CLICK);
            Intent deleteIntent = new Intent(context, NotificationReceiverImpl.class);
            NotificationHelper.setActionCode(deleteIntent, NotificationHelper.ACTION_DISMISS);
            CoreNotificationReceiver.putMsg(clickIntent, msg);
            CoreNotificationReceiver.putMsg(deleteIntent, msg);
            postNotification(
                    context,
                    PendingIntent.getBroadcast(context, 1, clickIntent, PendingIntent.FLAG_UPDATE_CURRENT),
                    PendingIntent.getBroadcast(context, 2, deleteIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            );
        }
        return true;
    }

    private void postNotification(Context context, PendingIntent clickIntent, PendingIntent deleteIntent) {
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle("this is title")
                .setContentText("this is content")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(clickIntent)
                .setDeleteIntent(deleteIntent)
                .build();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(notification.hashCode(), notification);

    }
}
