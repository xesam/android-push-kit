package dev.xesam.android.push.kit.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

/**
 * 通知栏动作分发器
 * Created by xe on 16-11-5.
 */

public abstract class CoreNotificationReceiver extends BroadcastReceiver {

    private static final String NOTICE_MSG = "dev.xesam.push.extra.notice_msg";

    public static <T extends Parcelable> T getMsg(Intent data) {
        return data.getParcelableExtra(NOTICE_MSG);
    }

    public static <T extends Parcelable> void putMsg(Intent data, T msg) {
        data.putExtra(NOTICE_MSG, msg);
    }

    public void onReceive(Context context, Intent intent) {
        int action = NotificationHelper.getActionCode(intent);
        AppPushMsg rawMsg;
        if (action == NotificationHelper.ACTION_DISMISS) {
            rawMsg = getMsg(intent);
            this.trackMsgDismissed(context, rawMsg);
        } else if (action == NotificationHelper.ACTION_CLICK) {
            rawMsg = getMsg(intent);
            this.trackMsgClick(context, rawMsg);
            this.onActionClick(context, rawMsg, this.hasRunningActivity(context));
        }

    }

    protected abstract void trackMsgDismissed(Context context, AppPushMsg appPushMsg);

    protected abstract boolean hasRunningActivity(Context context);

    protected abstract void trackMsgClick(Context context, AppPushMsg appPushMsg);

    protected abstract void onActionClick(Context context, AppPushMsg appPushMsg, boolean hasRunningActivity);
}
