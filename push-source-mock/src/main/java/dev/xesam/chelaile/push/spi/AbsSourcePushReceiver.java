package dev.xesam.chelaile.push.spi;

import android.content.Context;
import android.content.Intent;

import dev.xesam.android.push.kit.api.CoreSourcePushReceiver;
import dev.xesam.android.push.kit.api.PushHelper;

/**
 * 个推透传广播接收
 */
public abstract class AbsSourcePushReceiver extends CoreSourcePushReceiver {
    @Override
    public final void onReceive(Context context, Intent intent) {
        PushHelper.checkReceiveSdk(context, intent, this);
    }

}
