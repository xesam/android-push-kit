package dev.xesam.android.push.kit.api;

import android.support.annotation.NonNull;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class PushToken extends PushRaw {

    private String mToken;

    public PushToken(String token) {
        this.mToken = token;
    }

    @Override
    public int getType() {
        return PushRaw.TYPE_TOKEN;
    }

    @NonNull
    public String getToken() {
        return mToken;
    }
}
