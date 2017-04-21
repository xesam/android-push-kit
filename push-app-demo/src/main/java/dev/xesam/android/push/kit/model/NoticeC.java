package dev.xesam.android.push.kit.model;

import android.os.Parcel;
import android.os.Parcelable;

import dev.xesam.android.push.kit.api.AppPushMsg;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class NoticeC implements AppPushMsg, Parcelable {
    @Override
    public int getType() {
        return BizType.TYPE_C;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public NoticeC() {
    }

    protected NoticeC(Parcel in) {
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
