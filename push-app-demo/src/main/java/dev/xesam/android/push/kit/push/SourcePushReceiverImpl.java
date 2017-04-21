package dev.xesam.android.push.kit.push;

import android.content.Context;
import android.util.Log;

import dev.xesam.android.push.kit.api.SourcePushMsg;
import dev.xesam.android.push.kit.api.SourcePushRaw;
import dev.xesam.android.push.kit.api.SourcePushToken;
import dev.xesam.chelaile.push.spi.AbsSourcePushReceiver;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class SourcePushReceiverImpl extends AbsSourcePushReceiver {

    public static final String TAG = "SourcePushReceiverImpl";

    @Override
    public boolean checkPushRaw(Context context, SourcePushRaw data) {
        return true;
    }

    @Override
    public void onReceive(Context context, SourcePushRaw raw) {
        if (raw.getType() == SourcePushRaw.TYPE_TOKEN) {
            onReceiveToken(context, (SourcePushToken) raw);
        } else if (raw.getType() == SourcePushRaw.TYPE_MSG) {
            onReceiveMsg(context, (SourcePushMsg) raw);
        }
    }

    private void onReceiveToken(Context context, SourcePushToken token) {
        // TODO: 17-4-18
        Log.w(TAG, token.getToken());
//        CoreAppPushReceiver.broadcastAppPushMsg(context, DemoConstant.APP_RECEIVER_ACTION, token);
    }

    private void onReceiveMsg(Context context, SourcePushMsg msg) {
        // TODO: 17-4-18
        Log.w(TAG, msg.getRawPayload());
//        CoreAppPushReceiver.broadcastAppPushMsg(context, DemoConstant.APP_RECEIVER_ACTION, msg);
    }
}
