package io.github.xesam.android.push;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class PushChannelHelper {

    /**
     * @Warning 收到推送消息，注意同步修改 AndroidManifest.xml 里面对应的值
     * 注意同步修改 AndroidManifest.xml 里面对应的值!!!!!!!!!!!!!!!!!!!!!!
     */
    public static final String INTENT_PUSH_SDK_PAYLOAD_ACTION_PREFIX = "dev.xesam.push.action.sdk_payload.";
    public static final String INTENT_PUSH_SDK_PAYLOAD_EXTRA = "dev.xesam.push.extra.sdk_payload";

    private static String getDefaultSdkAction(Context context, @Nullable String packageName) {

        if (TextUtils.isEmpty(packageName)) {
            packageName = context.getPackageName();
        }
        return INTENT_PUSH_SDK_PAYLOAD_ACTION_PREFIX + packageName;
    }

    public static void sendToPushChannelConsumer(Context context, PushChannelMessage pushChannelMessage) {
        sendToPushChannelConsumer(context, pushChannelMessage, null);
    }

    public static void sendToPushChannelConsumer(Context context, PushChannelMessage pushChannelMessage, @Nullable String packageName) {
        String action = getDefaultSdkAction(context, packageName);
        Intent intent = new Intent(action);
        intent.putExtra(INTENT_PUSH_SDK_PAYLOAD_EXTRA, pushChannelMessage);
        context.sendBroadcast(intent);
    }

    public static PushChannelMessage getPushChannelMessage(Intent data) {
        return data.getParcelableExtra(INTENT_PUSH_SDK_PAYLOAD_EXTRA);
    }
}
