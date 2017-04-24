package dev.xesam.android.push.kit.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 通知栏动作分发器
 * Created by xe on 16-11-5.
 */

public abstract class CoreNotificationReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        int action = NotificationHelper.getActionCode(intent);
        AppPushMsg rawMsg;
        if (action == NotificationHelper.ACTION_DISMISS) {
            rawMsg = CoreAppPushReceiver.getAppPushMsg(intent);
            this.trackMsgDismissed(context, rawMsg);
        } else if (action == NotificationHelper.ACTION_CLICK) {
            rawMsg = CoreAppPushReceiver.getAppPushMsg(intent);
            this.trackMsgClick(context, rawMsg);
            this.onActionClick(context, rawMsg, this.hasRunningActivity(context));
        }

    }

    protected abstract void trackMsgDismissed(Context context, AppPushMsg appPushMsg);

    protected abstract boolean hasRunningActivity(Context context);

    protected abstract void trackMsgClick(Context context, AppPushMsg appPushMsg);

    protected abstract void onActionClick(Context context, AppPushMsg appPushMsg, boolean hasRunningActivity);
}
