package io.github.xesam.android.push;

import android.os.Parcelable;

/**
 * xesamguo@gmail.com
 */
public interface PushChannelMessage extends Parcelable {
    PushVendor getVendor();

    String getToken();

    String getPayload();
}
