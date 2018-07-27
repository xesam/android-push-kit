package io.github.xesam.android.push.b;

import android.content.Context;
import android.text.TextUtils;

import com.umeng.message.IUmengCallback;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import java.util.Map;

import io.github.xesam.android.push.PushChannel;

/**
 * 友盟推送管理
 * <p/>
 * Created by xesamguo@gmail.com on 16-4-1.
 */
public final class PushChannelB extends PushChannel {

    private Context mContext;

    public PushChannelB(Context context) {
        mContext = context.getApplicationContext();
    }

    @Override
    public void initialize(Map<String, String> params) {
        PushAgent mPushAgent = PushAgent.getInstance(mContext);
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                //这个回调基本上只会调用一次，所以很不可靠
//                SourcePushToken token = new SourcePushToken(deviceToken);
//                PushHelper.broadcastSdk(mContext, token);
            }

            @Override
            public void onFailure(String s, String s1) {
            }
        });

        //再次调用，避免失败
        String deviceToken = mPushAgent.getRegistrationId();
        if (!TextUtils.isEmpty(deviceToken)) {
//            SourcePushToken token = new SourcePushToken(deviceToken);
//            PushHelper.broadcastSdk(mContext, token);
        }

        mPushAgent.setMessageHandler(new MessageHandler());

//        if (params.containsKey("xiaomi")){
//            MiPushRegistar.register(mContext, xiaomiId, xiaomiKey);
//        }

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
}
