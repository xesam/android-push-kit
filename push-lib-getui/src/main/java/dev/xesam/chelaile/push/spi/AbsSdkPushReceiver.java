package dev.xesam.chelaile.push.spi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.igexin.sdk.PushConsts;

import dev.xesam.android.push.kit.api.ISdkPushProcessor;
import dev.xesam.android.push.kit.api.PushHelper;
import dev.xesam.android.push.kit.api.SimplePushMsg;

/**
 * 个推透传广播接收
 */
public abstract class AbsSdkPushReceiver extends BroadcastReceiver implements ISdkPushProcessor {
    @Override
    public final void onReceive(final Context context, Intent intent) {

        int pushCmd = intent.getIntExtra(PushConsts.CMD_ACTION, -1);

        switch (pushCmd) {
            case PushConsts.GET_CLIENTID: {
                String clientId = intent.getExtras().getString("clientid");
                Log.d("SdkPushManager Token", "clientId:" + clientId);
                if (PushHelper.isTokenAvailable(clientId)) {
                    onReceivePushToken(context, clientId);
                }
                break;
            }
            case PushConsts.GET_MSG_DATA: {
                byte[] payload = intent.getByteArrayExtra("payload");// 获取透传（payload）数据
                if (payload != null) {
                    String msgContent = new String(payload);
                    Log.d("SdkPushManager PushMsg", msgContent);
                    onReceivePushMsg(context, new SimplePushMsg(msgContent));
                }
                break;
            }
            default:
                break;
        }
    }

}
