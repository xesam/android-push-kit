package dev.xesam.android.push.kit.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;

/**
 * 应用内消息接收器
 * Created by xe on 16-10-26.
 */
public abstract class CoreAppPushReceiver extends BroadcastReceiver {
    public static final int DEFAULT_PRIORITY = 10;

    private static String EXTRA_APP_PUSH_MSG = "dev.xesam.push.extra.app_msg";

    public static <T extends Parcelable> T getAppPushMsg(Intent data) {
        return data.getParcelableExtra(EXTRA_APP_PUSH_MSG);
    }

    public static <T extends Parcelable> void broadcastAppPushMsg(Context context, Intent intent, T msg) {
        broadcastAppPushMsg(context, intent, msg, true);
    }

    public static <T extends Parcelable> void broadcastAppPushMsg(Context context, Intent intent, T msg, boolean ordered) {
        intent.putExtra(EXTRA_APP_PUSH_MSG, msg);
        if (ordered) {
            context.sendOrderedBroadcast(intent, null);
        } else {
            context.sendBroadcast(intent);
        }
    }

    private boolean mDynamicRegistered = false;

    protected abstract IntentFilter getIntentFilter(Context context);

    protected abstract int getPriority();

    @Override
    public final void onReceive(Context context, Intent intent) {
        final boolean consumed = onHandleReceive(context, intent);
        if (consumed) {
            abortBroadcast();//终止广播传递
        }
    }

    /**
     * 是否终止广播，如果返回 true，则终止
     */
    protected abstract boolean onHandleReceive(Context context, Intent intent);

    public void register(Context context) {
        if (!mDynamicRegistered) {
            IntentFilter intentFilter = getIntentFilter(context);
            intentFilter.setPriority(getPriority());
            context.registerReceiver(this, getIntentFilter(context));
            mDynamicRegistered = true;
        }
    }

    public void unregister(Context context) {
        if (!mDynamicRegistered) {
            context.unregisterReceiver(this);
            mDynamicRegistered = false;
        }
    }
}
