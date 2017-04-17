package dev.xesam.android.push.kit.api;

import android.content.BroadcastReceiver;
import android.content.Context;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public abstract class CoreSdkPushReceiver extends BroadcastReceiver {
    public abstract boolean checkPushRaw(Context context, PushRaw data);

    public abstract void onReceive(Context context, PushRaw raw);
}
