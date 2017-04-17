package dev.xesam.chelaile.push.spi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.umeng.message.IUmengCallback;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.entity.UMessage;

import org.android.agoo.xiaomi.MiPushRegistar;
import org.json.JSONException;
import org.json.JSONObject;

import dev.xesam.android.push.kit.api.IPushManager;
import dev.xesam.android.push.kit.api.PushHelper;
import dev.xesam.android.push.kit.api.PushSdkType;
import dev.xesam.android.push.kit.api.PushSource;

/**
 * 友盟推送管理
 * <p/>
 * Created by xesamguo@gmail.com on 16-4-1.
 */
public final class SdkPushManager implements IPushManager {

    private static String CACHE_LOG_TOKEN = "a1";
    private static PushSource sSource = new UmengPushSource();

    private Context mContext;

    public SdkPushManager(Context context) {
        mContext = context.getApplicationContext();
    }

    @Override
    public PushSdkType getPushSdkType() {
        return PushSdkType.UMENG;
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
        PushAgent mPushAgent = PushAgent.getInstance(mContext);
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //这个回调基本上只会调用一次，所以很不可靠
                PushHelper.broadcastReceiveToken(mContext, deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
            }
        });

        //再次调用，避免失败
        String deviceToken = mPushAgent.getRegistrationId();
        if (!TextUtils.isEmpty(deviceToken)) {
            PushHelper.broadcastReceiveToken(mContext, deviceToken);
        }

        mPushAgent.setMessageHandler(new MessageHandler());

        MiPushRegistar.register(mContext, xiaomiId, xiaomiKey);
    }

    @Override
    public void setDebug(boolean debug) {
        PushAgent mPushAgent = PushAgent.getInstance(mContext);
        mPushAgent.setDebugMode(debug);
    }

    @Override
    public void onAppStart() {
        PushAgent.getInstance(mContext).onAppStart();
    }

    @Override
    public void setEnable(boolean enable) {
        PushAgent mPushAgent = PushAgent.getInstance(mContext);
        if (enable) {

            mPushAgent.enable(new IUmengCallback() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onFailure(String s, String s1) {
                }
            });
        } else {
            mPushAgent.disable(new IUmengCallback() {
                @Override
                public void onSuccess() {
                }

                @Override
                public void onFailure(String s, String s1) {
                }
            });
        }
    }

    @Override
    public void trackMsgClick(String rawPayload) {
        try {
            JSONObject object = new JSONObject(rawPayload);
            UTrack.getInstance(mContext).trackMsgClick(new UMessage(object));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void trackMsgDismissed(String rawPayload) {
        try {
            JSONObject object = new JSONObject(rawPayload);
            UTrack.getInstance(mContext).trackMsgDismissed(new UMessage(object));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
