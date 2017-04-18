package dev.xesam.android.push.kit.push;

import android.content.Context;

import dev.xesam.android.push.kit.api.PushMsg;
import dev.xesam.android.push.kit.api.PushRaw;
import dev.xesam.android.push.kit.api.PushToken;
import dev.xesam.chelaile.push.spi.AbsSdkPushReceiver;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class SdkPushReceiverImpl extends AbsSdkPushReceiver {

    @Override
    public boolean checkPushRaw(Context context, PushRaw data) {
        return true;
    }

    @Override
    public void onReceive(Context context, PushRaw raw) {
        if (raw.getType() == PushRaw.TYPE_TOKEN) {
            onReceiveToken((PushToken) raw);
        } else if (raw.getType() == PushRaw.TYPE_MSG) {
            onReceiveMsg((PushMsg) raw);
        }
    }

    private void onReceiveToken(PushToken token) {
        // TODO: 17-4-18
    }

    private void onReceiveMsg(PushMsg msg) {
        // TODO: 17-4-18
    }
}
