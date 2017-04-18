package dev.xesam.android.push.kit.push;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import dev.xesam.android.push.kit.api.CoreAppPushReceiver;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class AppPushReceiverImpl extends CoreAppPushReceiver {
    @Override
    protected IntentFilter getIntentFilter(Context context) {
        return null;
    }

    @Override
    protected int getPriority() {
        return DEFAULT_PRIORITY;
    }

    @Override
    protected boolean onHandleReceive(Context context, Intent intent) {
        return false;
    }
}
