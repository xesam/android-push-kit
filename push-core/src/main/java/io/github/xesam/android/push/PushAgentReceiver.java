package io.github.xesam.android.push;


import android.content.Context;

/**
 * 推送通道消息接收
 */
public interface PushAgentReceiver {
    void onReceive(Context context, String message);
}
