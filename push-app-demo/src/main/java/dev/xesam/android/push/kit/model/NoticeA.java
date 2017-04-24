package dev.xesam.android.push.kit.model;

import android.os.Parcel;

import dev.xesam.android.push.kit.api.AppPushMsg;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class NoticeA implements AppPushMsg {

    private String name;

    @Override
    public int getType() {
        return BizType.TYPE_A;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NoticeA() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    protected NoticeA(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<NoticeA> CREATOR = new Creator<NoticeA>() {
        @Override
        public NoticeA createFromParcel(Parcel source) {
            return new NoticeA(source);
        }

        @Override
        public NoticeA[] newArray(int size) {
            return new NoticeA[size];
        }
    };
}
