package dev.xesam.android.push.kit.push;

import android.content.Context;

import dev.xesam.android.push.kit.api.PushRaw;
import dev.xesam.chelaile.push.spi.AbsSdkPushReceiver;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class SdkPushReceiverImpl extends AbsSdkPushReceiver {

    @Override
    public boolean checkPushRaw(Context context, PushRaw data) {
        return false;
    }

    @Override
    public void onReceive(Context context, PushRaw raw) {
        if (raw.getType() == PushRaw.TYPE_TOKEN) {

        } else if (raw.getType() == PushRaw.TYPE_MSG) {

        }
    }
}
