package io.github.xesam.android.push.b;

import android.os.Parcel;

import com.umeng.message.entity.UMessage;

import org.json.JSONException;
import org.json.JSONObject;

import io.github.xesam.android.push.PushChannelMessage;
import io.github.xesam.android.push.PushVendor;

/**
 * Created by xe on 16-10-24.
 */

class PushChannelMessageB implements PushChannelMessage {

    private JSONObject data;

    public PushChannelMessageB(UMessage uMessage) {
        this.data = uMessage.getRaw();
    }

    @Override
    public PushVendor getVendor() {
        return new VendorB();
    }

    @Override
    public String getToken() {
        return null;
    }

    @Override
    public String getPayload() {
        try {
            UMessage uMessage = new UMessage(this.data);
            return uMessage.custom;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.data.toString());
    }

    protected PushChannelMessageB(Parcel in) {
        try {
            this.data = new JSONObject(in.readString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final Creator<PushChannelMessageB> CREATOR = new Creator<PushChannelMessageB>() {
        @Override
        public PushChannelMessageB createFromParcel(Parcel source) {
            return new PushChannelMessageB(source);
        }

        @Override
        public PushChannelMessageB[] newArray(int size) {
            return new PushChannelMessageB[size];
        }
    };
}
