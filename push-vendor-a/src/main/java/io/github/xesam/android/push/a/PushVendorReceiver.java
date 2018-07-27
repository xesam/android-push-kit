package io.github.xesam.android.push.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.igexin.sdk.PushConsts;

import io.github.xesam.android.push.PushChannelHelper;

/**
 * 个推透传广播接收
 */
public class PushVendorReceiver extends BroadcastReceiver {

    @Override
    public final void onReceive(Context context, Intent intent) {

        int pushCmd = intent.getIntExtra(PushConsts.CMD_ACTION, -1);

        switch (pushCmd) {
            case PushConsts.GET_CLIENTID: {
                String clientId = intent.getStringExtra("clientid");
                if (clientId == null) {
                    PushChannelHelper.sendToPushChannelConsumer(context, new PushChannelMessageA(clientId, null));
                }
                break;
            }
            case PushConsts.GET_MSG_DATA: {
                byte[] payload = intent.getByteArrayExtra("payload");// 获取透传（payload）数据
                if (payload != null) {
                    String payloadStr = new String(payload);
                    PushChannelHelper.sendToPushChannelConsumer(context, new PushChannelMessageA(null, payloadStr));
                }
                break;
            }
            default:
                break;
        }
    }

}
