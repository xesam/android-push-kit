package dev.xesam.android.push.kit.push;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import dev.xesam.android.push.kit.StartActivity;
import dev.xesam.android.push.kit.api.AppPushMsg;
import dev.xesam.android.push.kit.api.CoreNotificationReceiver;

/**
 * Created by xesamguo@gmail.com on 17-4-24.
 */

public class NotificationReceiverImpl extends CoreNotificationReceiver {
    public static final String TAG = "NotifyReceiverImpl";

    @Override
    protected void trackMsgDismissed(Context context, AppPushMsg appPushMsg) {
        Log.w(TAG, "trackMsgDismissed");
    }

    @Override
    protected boolean hasRunningActivity(Context context) {
        return true;
    }

    @Override
    protected void trackMsgClick(Context context, AppPushMsg appPushMsg) {

    }

    @Override
    protected void onActionClick(Context context, AppPushMsg appPushMsg, boolean hasRunningActivity) {
        Log.w(TAG, "onActionClick");
        if (hasRunningActivity) {
            context.startActivity(new Intent(context, PullUpActivity.class));
        } else {
            context.startActivity(new Intent(context, StartActivity.class));
        }
    }
}
