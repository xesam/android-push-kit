package io.github.xesam.android.push.a;

import android.os.Parcel;

import io.github.xesam.android.push.PushChannelMessage;
import io.github.xesam.android.push.PushVendor;

/**
 * xesamguo@gmail.com
 */
class PushChannelMessageA implements PushChannelMessage {

    private String token;
    private String payload;

    public PushChannelMessageA(String token, String payload) {
        this.token = token;
        this.payload = payload;
    }

    @Override
    public PushVendor getVendor() {
        return new VendorA();
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getPayload() {
        return payload;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.token);
        dest.writeString(this.payload);
    }

    protected PushChannelMessageA(Parcel in) {
        this.token = in.readString();
        this.payload = in.readString();
    }

    public static final Creator<PushChannelMessageA> CREATOR = new Creator<PushChannelMessageA>() {
        @Override
        public PushChannelMessageA createFromParcel(Parcel source) {
            return new PushChannelMessageA(source);
        }

        @Override
        public PushChannelMessageA[] newArray(int size) {
            return new PushChannelMessageA[size];
        }
    };
}
