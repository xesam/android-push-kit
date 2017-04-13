package dev.xesam.android.push.kit.api;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/**
 * 解析推送消息
 */
public final class PushHelper {

    /**
     * @Warning token变化，注意同步修改 AndroidManifest.xml 里面对应的值
     * 注意同步修改 AndroidManifest.xml 里面对应的值!!!!!!!!!!!!!!!!!!!!!!
     */

    private static final String INTENT_EXTRA_PUSH_SDK_TOKEN = "dev.xesam.push.extra.sdk_token";

    private static String getReceiveTokenAction(Context context) {
        return getPackagePushConfig(context, "dev.xesam.push.action.sdk_token.");
    }

    /**
     * @Warning 收到推送消息，注意同步修改 AndroidManifest.xml 里面对应的值
     * 注意同步修改 AndroidManifest.xml 里面对应的值!!!!!!!!!!!!!!!!!!!!!!
     */
    private static final String INTENT_EXTRA_PUSH_SDK_MSG = "dev.xesam.push.extra.sdk_msg";

    private static String getReceiveMessageAction(Context context) {
        return getPackagePushConfig(context, "dev.xesam.push.action.sdk_msg.");
    }

    /**
     * 返回包名相关的配置
     */
    public static String getPackagePushConfig(Context context, String prefix) {
        return prefix + context.getPackageName();
    }

    /**
     * 判断token是否有效,8字节的标准由后台指定
     */
    public static boolean isTokenAvailable(String token) {
        return !TextUtils.isEmpty(token) && token.length() > 8;
    }

    /**
     * 收到token，转发出去
     */
    public static void broadcastReceiveToken(Context context, String token) {
        Intent intent = new Intent();
        intent.setAction(getReceiveTokenAction(context));
        intent.putExtra(INTENT_EXTRA_PUSH_SDK_TOKEN, token);
        context.sendBroadcast(intent);
    }

    /**
     * 检查是否是收到 Token
     */
    public static void checkReceiveToken(Context context, Intent intent, ISdkPushProcessor processor) {
        final String action = intent.getAction();
        if (getReceiveTokenAction(context).equals(action)) {
            String token = intent.getStringExtra(INTENT_EXTRA_PUSH_SDK_TOKEN);
            if (isTokenAvailable(token)) {
                processor.onReceivePushToken(context, token);
            }
        }
    }

    /**
     * 收到自定义消息，转发出去
     */
    public static void broadcastReceiveMessage(Context context, PushMsg pushMsg) {
        Intent intent = new Intent();
        intent.setAction(getReceiveMessageAction(context));
        intent.putExtra(INTENT_EXTRA_PUSH_SDK_MSG, pushMsg);
        context.sendBroadcast(intent);
    }

    /**
     * 检查是否是收到 Msg
     */
    public static void checkReceiveMessage(Context context, Intent intent, ISdkPushProcessor processor) {
        final String action = intent.getAction();
        if (getReceiveMessageAction(context).equals(action)) {
            PushMsg pushMsg = intent.getParcelableExtra(INTENT_EXTRA_PUSH_SDK_MSG);
            processor.onReceivePushMsg(context, pushMsg);
        }
    }
}
