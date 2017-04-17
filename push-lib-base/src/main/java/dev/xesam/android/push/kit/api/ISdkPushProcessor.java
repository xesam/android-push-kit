package dev.xesam.android.push.kit.api;

import android.content.Context;

/**
 * 消息处理器
 * Created by xe on 16-10-24.
 */

@Deprecated
public interface ISdkPushProcessor {
    /**
     * 接收到推送Token
     */
    void onReceivePushToken(Context context, String token);

    /**
     * 接收到推送消息
     */
    void onReceivePushMsg(Context context, PushMsg pushMsg);
}
