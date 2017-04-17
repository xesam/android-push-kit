package dev.xesam.android.push.kit.api;

import android.support.annotation.NonNull;

/**
 * Created by xe on 16-10-24.
 */

public interface IPushManager {

    @NonNull
    PushSource getPushSource();

    void setDebugToken(String token);

    String getDebugToken();

    void init(String xiaomiId, String xiaomiKey);

    void setDebug(boolean debug);

    void onAppStart();

    void setEnable(boolean enable);

    //统计消息被点击或者处理
    void trackMsgClick(String rawPayload);

    //统计消息被忽略
    void trackMsgDismissed(String rawPayload);
}
