package io.github.xesam.android.push.b;

import android.content.Context;

import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

import io.github.xesam.android.push.PushChannelHelper;

/**
 * 自定义的消息处理
 * <p/>
 * Created by xesamguo@gmail.com on 16-4-5.
 */
final class MessageHandler extends UmengMessageHandler {
    @Override
    public void dealWithCustomMessage(Context context, UMessage uMessage) {
        super.dealWithCustomMessage(context, uMessage);
        //收到消息后，将消息推送到标准 BroadcastReceiver
        if (uMessage == null || uMessage.getRaw() == null) {
            return;
        }
        PushChannelHelper.sendToPushChannelConsumer(context, new PushChannelMessageB(uMessage));
    }
}