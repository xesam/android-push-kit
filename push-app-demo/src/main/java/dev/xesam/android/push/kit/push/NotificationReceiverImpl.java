package dev.xesam.android.push.kit.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import dev.xesam.android.push.kit.DemoApp;
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
        return DemoApp.getThis().hasRunningActivity();
    }

    @Override
    protected void trackMsgClick(Context context, AppPushMsg appPushMsg) {

    }

    @Override
    protected void onActionClick(Context context, AppPushMsg appPushMsg, boolean hasRunningActivity) {
        Log.w(TAG, "onActionClick");
        Intent intent;
        if (hasRunningActivity) {
            intent = new Intent(context, PushActivity.class);
        } else {
            intent = new Intent(context, StartActivity.class);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}
