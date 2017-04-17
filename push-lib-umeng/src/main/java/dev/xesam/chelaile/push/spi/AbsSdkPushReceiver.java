package dev.xesam.chelaile.push.spi;

import android.content.Context;
import android.content.Intent;

import dev.xesam.android.push.kit.api.CoreSdkPushReceiver;
import dev.xesam.android.push.kit.api.ISdkPushProcessor;
import dev.xesam.android.push.kit.api.PushHelper;

/**
 * 友盟透传广播接收
 */
public abstract class AbsSdkPushReceiver extends CoreSdkPushReceiver implements ISdkPushProcessor {
    @Override
    public final void onReceive(Context context, Intent intent) {
        PushHelper.checkReceiveSdk(context, intent, this);
    }

}
