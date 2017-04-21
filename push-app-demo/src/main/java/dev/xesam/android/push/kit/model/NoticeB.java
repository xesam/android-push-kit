package dev.xesam.android.push.kit.model;

import android.os.Parcel;

import dev.xesam.android.push.kit.api.AppPushMsg;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class NoticeB implements AppPushMsg {
    @Override
    public int getType() {
        return BizType.TYPE_A;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public NoticeB() {
    }

    protected NoticeB(Parcel in) {
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
