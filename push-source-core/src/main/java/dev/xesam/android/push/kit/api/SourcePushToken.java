package dev.xesam.android.push.kit.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class SourcePushToken extends SourcePushRaw implements Parcelable {

    private String mToken;

    public SourcePushToken(String token) {
        this.mToken = token;
    }

    @Override
    public int getType() {
        return SourcePushRaw.TYPE_TOKEN;
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

    protected SourcePushToken(Parcel in) {
        this.mToken = in.readString();
    }

    public static final Parcelable.Creator<SourcePushToken> CREATOR = new Parcelable.Creator<SourcePushToken>() {
        @Override
        public SourcePushToken createFromParcel(Parcel source) {
            return new SourcePushToken(source);
        }

        @Override
        public SourcePushToken[] newArray(int size) {
            return new SourcePushToken[size];
        }
    };
}
