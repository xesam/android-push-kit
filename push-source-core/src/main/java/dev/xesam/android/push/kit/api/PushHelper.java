package dev.xesam.android.push.kit.api;

import android.content.Context;
import android.content.Intent;

/**
 * 解析推送消息
 */
public final class PushHelper {

    /**
     * 返回包名相关的配置
     */
    public static String getPackagePushConfig(Context context, String prefix) {
        return prefix + context.getPackageName();
    }

    /**
     * @Warning 收到推送消息，注意同步修改 AndroidManifest.xml 里面对应的值
     * 注意同步修改 AndroidManifest.xml 里面对应的值!!!!!!!!!!!!!!!!!!!!!!
     */
    private static final String INTENT_EXTRA_PUSH_SDK_PAYLOAD = "dev.xesam.push.extra.sdk_payload";

    private static String getReceiveSdkAction(Context context) {
        return getPackagePushConfig(context, "dev.xesam.push.action.sdk_payload.");
    }

    public static void broadcastSdk(Context context, PushRaw raw) {
        Intent intent = new Intent();
        intent.setAction(getReceiveSdkAction(context));
        intent.putExtra(INTENT_EXTRA_PUSH_SDK_PAYLOAD, raw);
        context.sendBroadcast(intent);
    }

    public static void checkReceiveSdk(Context context, Intent intent, CoreSdkPushReceiver processor) {
        final String action = intent.getAction();
        if (getReceiveSdkAction(context).equals(action)) {
            PushRaw token = intent.getParcelableExtra(INTENT_EXTRA_PUSH_SDK_PAYLOAD);
            if (processor.checkPushRaw(context, token)) {
                processor.onReceive(context, token);
            }
        }
    }
}
