package dev.xesam.android.push.kit.api;

import android.os.Parcelable;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public abstract class SourcePushRaw implements Parcelable {
    public static final int TYPE_TOKEN = 1;
    public static final int TYPE_MSG = 2;

    public abstract int getType();
}
