package dev.xesam.android.push.kit.model;

import android.os.Parcel;

import dev.xesam.android.push.kit.api.AppPushMsg;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class NoticeA implements AppPushMsg {
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

    public NoticeA() {
    }

    protected NoticeA(Parcel in) {
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
