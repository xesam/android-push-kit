package dev.xesam.chelaile.push.api;

import android.os.Parcel;
import android.support.annotation.Nullable;

/**
 * 简单消息实现
 * Created by xe on 16-10-27.
 */

public class SimplePushMsg extends PushMsg {
    private String mMsg;

    public SimplePushMsg(String mMsg) {
        this.mMsg = mMsg;
    }

    @Override
    @Nullable
    public String getRawPayload() {
        return mMsg;
    }

    @Override
    @Nullable
    public String getCustomPayload() {
        return mMsg;
    }

    @Override
    public String toString() {
        return "SimplePushMsg{" +
                "mMsg='" + mMsg + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mMsg);
    }

    protected SimplePushMsg(Parcel in) {
        this.mMsg = in.readString();
    }

    public static final Creator<SimplePushMsg> CREATOR = new Creator<SimplePushMsg>() {
        @Override
        public SimplePushMsg createFromParcel(Parcel source) {
            return new SimplePushMsg(source);
        }

        @Override
        public SimplePushMsg[] newArray(int size) {
            return new SimplePushMsg[size];
        }
    };
}
