package dev.xesam.chelaile.push.spi;

import android.content.Context;
import android.content.Intent;

import dev.xesam.android.push.kit.api.CoreSdkPushReceiver;

/**
 * 个推透传广播接收
 */
public abstract class AbsSdkPushReceiver extends CoreSdkPushReceiver {
    @Override
    public final void onReceive(Context context, Intent intent) {
    }

}
