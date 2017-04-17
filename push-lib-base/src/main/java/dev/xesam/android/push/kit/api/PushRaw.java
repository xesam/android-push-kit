package dev.xesam.android.push.kit.api;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public abstract class PushRaw {
    public static final int TYPE_TOKEN = 1;
    public static final int TYPE_MSG = 2;

    public abstract int getType();
}
