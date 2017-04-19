package dev.xesam.chelaile.push.spi;

import android.content.Context;
import android.content.Intent;

import dev.xesam.android.push.kit.api.CoreSdkPushReceiver;
import dev.xesam.android.push.kit.api.PushHelper;

/**
 * 个推透传广播接收
 */
public abstract class AbsSdkPushReceiver extends CoreSdkPushReceiver {
    @Override
    public final void onReceive(Context context, Intent intent) {
        PushHelper.checkReceiveSdk(context, intent, this);
//        final String action = intent.getAction();
//        if (PushHelper.getPackageConfig(context, Constant.ACTION_TOKEN).equals(action)) {
//            PushHelper.broadcastSdk();
//        } else if (PushHelper.getPackageConfig(context, Constant.ACTION_MESSAGE).equals(action)) {
//
//        }
    }

}
