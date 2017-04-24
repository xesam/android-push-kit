package dev.xesam.android.push.kit.model;

import android.os.Parcel;

import dev.xesam.android.push.kit.api.AppPushMsg;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class NoticeB implements AppPushMsg {
    private String name;

    @Override
    public int getType() {
        return BizType.TYPE_B;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NoticeB{" +
                "name='" + name + '\'' +
                '}';
    }

    public NoticeB() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected NoticeB(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<NoticeB> CREATOR = new Creator<NoticeB>() {
        @Override
        public NoticeB createFromParcel(Parcel source) {
            return new NoticeB(source);
        }

        @Override
        public NoticeB[] newArray(int size) {
            return new NoticeB[size];
        }
    };
}
