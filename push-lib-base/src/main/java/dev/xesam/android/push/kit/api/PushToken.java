package dev.xesam.android.push.kit.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class PushToken extends PushRaw implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mToken);
    }

    protected PushToken(Parcel in) {
        this.mToken = in.readString();
    }

    public static final Parcelable.Creator<PushToken> CREATOR = new Parcelable.Creator<PushToken>() {
        @Override
        public PushToken createFromParcel(Parcel source) {
            return new PushToken(source);
        }

        @Override
        public PushToken[] newArray(int size) {
            return new PushToken[size];
        }
    };
}
