package dev.xesam.chelaile.push.api;

import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * 统一SDK推送消息对象
 * Created by xe on 16-10-24.
 */

public abstract class PushMsg implements Parcelable {

    /**
     * 获取SDK的数据
     */
    @Nullable
    public abstract String getRawPayload();

    /**
     * 获取自定义的数据
     */
    @Nullable
    public abstract String getCustomPayload();
}
