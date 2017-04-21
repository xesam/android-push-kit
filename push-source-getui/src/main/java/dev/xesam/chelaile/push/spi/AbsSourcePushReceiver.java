package dev.xesam.chelaile.push.spi;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.igexin.sdk.PushConsts;

import dev.xesam.android.push.kit.api.CoreSourcePushReceiver;
import dev.xesam.android.push.kit.api.SourcePushMsg;
import dev.xesam.android.push.kit.api.SourcePushToken;
import dev.xesam.android.push.kit.api.SimplePushMsg;

/**
 * 个推透传广播接收
 */
public abstract class AbsSourcePushReceiver extends CoreSourcePushReceiver {
    public static final String TAG = "AbsSourcePushReceiver";

    @Override
    public final void onReceive(Context context, Intent intent) {

        int pushCmd = intent.getIntExtra(PushConsts.CMD_ACTION, -1);

        switch (pushCmd) {
            case PushConsts.GET_CLIENTID: {
                String clientId = intent.getExtras().getString("clientid");
                Log.d("SdkPushManager Token", "clientId:" + clientId);
                SourcePushToken token = new SourcePushToken(clientId);
                if (checkPushRaw(context, token)) {
                    onReceive(context, token);
                } else {
                    Log.w(TAG, "checkPushRaw is false");
                }
                break;
            }
            case PushConsts.GET_MSG_DATA: {
                byte[] payload = intent.getByteArrayExtra("payload");// 获取透传（payload）数据
                if (payload != null) {
                    String msgContent = new String(payload);
                    Log.d("SdkPushManager SourcePushMsg", msgContent);
                    SourcePushMsg msg = new SimplePushMsg(msgContent);
                    if (checkPushRaw(context, msg)) {
                        onReceive(context, msg);
                    } else {
                        Log.w(TAG, "checkPushRaw is false");
                    }
                }
                break;
            }
            default:
                break;
        }
    }

}
