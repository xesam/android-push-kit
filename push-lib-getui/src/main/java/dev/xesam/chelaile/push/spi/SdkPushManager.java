package dev.xesam.chelaile.push.spi;

import android.content.Context;
import android.support.annotation.NonNull;

import com.igexin.sdk.PushManager;

import dev.xesam.android.push.kit.api.IPushManager;
import dev.xesam.android.push.kit.api.PushSource;

/**
 * 个推管理
 * <p>
 * Created by xesamguo@gmail.com on 16-4-1.
 */
public final class SdkPushManager implements IPushManager {

    private static String CACHE_LOG_TOKEN = "a1";
    private static PushSource sSource = new GeTuiPushSource();

    private Context mContext;

    public SdkPushManager(Context context) {
        mContext = context.getApplicationContext();
    }

    @NonNull
    @Override
    public PushSource getPushSource() {
        return sSource;
    }

    @Override
    public void setDebugToken(String token) {
        CACHE_LOG_TOKEN = token;
    }

    @Override
    public String getDebugToken() {
        return CACHE_LOG_TOKEN;
    }

    @Override
    public void init(String xiaomiId, String xiaomiKey) {
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

    @Override
    public void trackMsgClick(String rawPayload) {

    }

    @Override
    public void trackMsgDismissed(String rawPayload) {

    }
}
