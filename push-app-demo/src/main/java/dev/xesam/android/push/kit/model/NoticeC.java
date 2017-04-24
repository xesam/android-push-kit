package dev.xesam.android.push.kit.model;

import android.os.Parcel;
import android.os.Parcelable;

import dev.xesam.android.push.kit.api.AppPushMsg;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class NoticeC implements AppPushMsg, Parcelable {
    private String name;

    @Override
    public int getType() {
        return BizType.TYPE_C;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NoticeC{" +
                "name='" + name + '\'' +
                '}';
    }

    public NoticeC() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected NoticeC(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<NoticeC> CREATOR = new Creator<NoticeC>() {
        @Override
        public NoticeC createFromParcel(Parcel source) {
            return new NoticeC(source);
        }

        @Override
        public NoticeC[] newArray(int size) {
            return new NoticeC[size];
        }
    };
}
