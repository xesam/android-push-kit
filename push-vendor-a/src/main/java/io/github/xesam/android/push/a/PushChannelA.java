package io.github.xesam.android.push.a;

import android.content.Context;

import com.igexin.sdk.PushManager;

import java.util.Map;

import io.github.xesam.android.push.PushChannel;

/**
 * 个推管理
 * <p>
 * Created by xesamguo@gmail.com on 16-4-1.
 */
public final class PushChannelA extends PushChannel {

    private Context mContext;

    public PushChannelA(Context context) {
        mContext = context.getApplicationContext();
    }

    @Override
    public void initialize(Map<String, String> params) {
        PushManager.getInstance().initialize(mContext);
    }

    @Override
    public void setDebug(boolean debug) {

    }

    @Override
    public void onAppStart() {

    }

    @Override
    public void setEnable(boolean enable) {
        if (enable) {
            PushManager.getInstance().initialize(mContext);
            PushManager.getInstance().turnOnPush(mContext);
        } else {
            PushManager.getInstance().turnOffPush(mContext);
            PushManager.getInstance().stopService(mContext);
        }
    }
}
