package dev.xesam.android.push.kit.api;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * 解析推送消息
 */
public final class PushHelper {

    /**
     * @Warning 收到推送消息，注意同步修改 AndroidManifest.xml 里面对应的值
     * 注意同步修改 AndroidManifest.xml 里面对应的值!!!!!!!!!!!!!!!!!!!!!!
     */
    public static final String INTENT_ACTION_PUSH_SDK_PAYLOAD_PREFIX = "dev.xesam.push.action.sdk_payload.";
    public static final String INTENT_EXTRA_PUSH_SDK_PAYLOAD = "dev.xesam.push.extra.sdk_payload";

    private static String getDefaultSdkAction(Context context, @Nullable String packageName) {

        if (TextUtils.isEmpty(packageName)) {
            packageName = context.getPackageName();
        }
        return INTENT_ACTION_PUSH_SDK_PAYLOAD_PREFIX + packageName;
    }

    public static void broadcastSdk(Context context, PushRaw raw) {
        broadcastSdk(context, raw, null);
    }

    public static void broadcastSdk(Context context, PushRaw raw, @Nullable String packageName) {
        String action = getDefaultSdkAction(context, packageName);
        Intent intent = new Intent(action);
        intent.putExtra(INTENT_EXTRA_PUSH_SDK_PAYLOAD, raw);
        context.sendBroadcast(intent);
    }

    public static void checkReceiveSdk(Context context, Intent intent, CoreSdkPushReceiver receiver) {
        String expectAction = getDefaultSdkAction(context, null);
        final String action = intent.getAction();
        if (expectAction.equals(action)) {
            PushRaw raw = intent.getParcelableExtra(INTENT_EXTRA_PUSH_SDK_PAYLOAD);
            if (receiver.checkPushRaw(context, raw)) {
                receiver.onReceive(context, raw);
            }
        }
    }
}
