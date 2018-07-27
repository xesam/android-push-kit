package io.github.xesam.android.push;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 推送通道消息接收
 */
public abstract class PushChannelReceiver extends BroadcastReceiver implements PushChannelConsumer {
    @Override
    public void onReceive(Context context, Intent intent) {
        PushChannelMessage pushChannelMessage = PushChannelHelper.getPushChannelMessage(intent);
        onReceive(context, pushChannelMessage);
    }
}
