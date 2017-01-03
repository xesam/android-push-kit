package dev.xesam.chelaile.push.spi;

import android.os.Parcel;
import android.support.annotation.Nullable;

import com.umeng.message.entity.UMessage;

import org.json.JSONException;
import org.json.JSONObject;

import dev.xesam.chelaile.push.api.PushMsg;

/**
 * Created by xe on 16-10-24.
 */

public class UmengPushMsg extends PushMsg {
    String mMsg;

    UmengPushMsg(UMessage uMessage) {
        this.mMsg = uMessage.getRaw().toString();
    }

    @Override
    @Nullable
    public String getRawPayload() {
        return mMsg;
    }

    @Override
    @Nullable
    public String getCustomPayload() {
        try {
            JSONObject raw = new JSONObject(mMsg);
            UMessage uMessage = new UMessage(raw);
            return uMessage.custom;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "UmengPushMsg{" +
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

    protected UmengPushMsg(Parcel in) {
        this.mMsg = in.readString();
    }

    public static final Creator<UmengPushMsg> CREATOR = new Creator<UmengPushMsg>() {
        @Override
        public UmengPushMsg createFromParcel(Parcel source) {
            return new UmengPushMsg(source);
        }

        @Override
        public UmengPushMsg[] newArray(int size) {
            return new UmengPushMsg[size];
        }
    };
}
