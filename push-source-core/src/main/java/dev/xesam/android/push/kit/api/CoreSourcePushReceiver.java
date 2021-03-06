package dev.xesam.android.push.kit.api;

import android.content.BroadcastReceiver;
import android.content.Context;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public abstract class CoreSourcePushReceiver extends BroadcastReceiver {
    public abstract boolean checkPushRaw(Context context, SourcePushRaw data);

    public abstract void onReceive(Context context, SourcePushRaw raw);
}
