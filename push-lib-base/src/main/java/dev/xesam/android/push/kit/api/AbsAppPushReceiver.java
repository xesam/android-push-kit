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
public abstract class AbsAppPushReceiver extends BroadcastReceiver {

    private static String EXTRA_APP_PUSH_MSG = "dev.xesam.push.extra.app_msg";

    public static <T extends Parcelable> T getAppPushMsg(Intent data) {
        return data.getParcelableExtra(EXTRA_APP_PUSH_MSG);
    }

    public static <T extends Parcelable> void setAppPushMsg(Intent data, T msg) {
        data.putExtra(EXTRA_APP_PUSH_MSG, msg);
    }

    private boolean mDynamicRegistered = false;

    protected abstract IntentFilter getIntentFilter(Context context);

    protected abstract int getPriority();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (onHandlerProcess(context, intent)) {
            abortBroadcast();//终止广播传递
        }
    }

    /**
     * 是否终止广播，如果返回 true，则终止
     */
    protected abstract boolean onHandlerProcess(Context context, Intent intent);

    public void register(Context context) {
        if (!mDynamicRegistered) {
            IntentFilter intentFilter = getIntentFilter(context);
            intentFilter.setPriority(getPriority());
            context.registerReceiver(this, getIntentFilter(context));
            mDynamicRegistered = true;
        }
    }

    public void unregister(Context context) {
        if (mDynamicRegistered) {
            context.unregisterReceiver(this);
            mDynamicRegistered = false;
        }
    }
}
