package dev.xesam.chelaile.push.spi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import dev.xesam.android.push.kit.api.ISdkPushProcessor;
import dev.xesam.android.push.kit.api.PushHelper;

/**
 * 友盟透传广播接收
 */
public abstract class AbsSdkPushReceiver extends BroadcastReceiver implements ISdkPushProcessor {
    @Override
    public final void onReceive(final Context context, Intent intent) {
        PushHelper.checkReceiveToken(context, intent, this);
        PushHelper.checkReceiveMessage(context, intent, this);
    }

}
