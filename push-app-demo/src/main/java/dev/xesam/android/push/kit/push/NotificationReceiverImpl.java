package dev.xesam.android.push.kit.push;

import android.content.Context;

import dev.xesam.android.push.kit.api.AppPushMsg;
import dev.xesam.android.push.kit.api.CoreNotificationReceiver;

/**
 * Created by xesamguo@gmail.com on 17-4-24.
 */

public class NotificationReceiverImpl extends CoreNotificationReceiver {
    @Override
    protected void trackMsgDismissed(Context context, AppPushMsg appPushMsg) {

    }

    @Override
    protected boolean hasRunningActivity(Context context) {
        return false;
    }

    @Override
    protected void trackMsgClick(Context context, AppPushMsg appPushMsg) {

    }

    @Override
    protected void onActionClick(Context context, AppPushMsg appPushMsg, boolean hasRunningActivity) {

    }
}
