package dev.xesam.android.push.kit.push;

import android.content.Context;
import android.util.Log;

import dev.xesam.android.push.kit.api.CoreAppPushReceiver;
import dev.xesam.android.push.kit.api.PushMsg;
import dev.xesam.android.push.kit.api.PushRaw;
import dev.xesam.android.push.kit.api.PushToken;
import dev.xesam.chelaile.push.spi.AbsSdkPushReceiver;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class SdkPushReceiverImpl extends AbsSdkPushReceiver {

    public static final String TAG = "SdkPushReceiverImpl";

    @Override
    public boolean checkPushRaw(Context context, PushRaw data) {
        return true;
    }

    @Override
    public void onReceive(Context context, PushRaw raw) {
        if (raw.getType() == PushRaw.TYPE_TOKEN) {
            onReceiveToken(context, (PushToken) raw);
        } else if (raw.getType() == PushRaw.TYPE_MSG) {
            onReceiveMsg(context, (PushMsg) raw);
        }
    }

    private void onReceiveToken(Context context, PushToken token) {
        // TODO: 17-4-18
        Log.w(TAG, token.getToken());
        CoreAppPushReceiver.broadcastAppPushMsg(context, DemoConstant.APP_RECEIVER_ACTION, token);
    }

    private void onReceiveMsg(Context context, PushMsg msg) {
        // TODO: 17-4-18
        Log.w(TAG, msg.getRawPayload());
        CoreAppPushReceiver.broadcastAppPushMsg(context, DemoConstant.APP_RECEIVER_ACTION, msg);
    }
}
