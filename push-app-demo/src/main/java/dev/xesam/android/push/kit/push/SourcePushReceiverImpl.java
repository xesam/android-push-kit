package dev.xesam.android.push.kit.push;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import dev.xesam.android.push.kit.api.AppPushMsg;
import dev.xesam.android.push.kit.api.CoreAppPushReceiver;
import dev.xesam.android.push.kit.api.SourcePushMsg;
import dev.xesam.android.push.kit.api.SourcePushRaw;
import dev.xesam.android.push.kit.api.SourcePushToken;
import dev.xesam.android.push.kit.model.NoticeA;
import dev.xesam.android.push.kit.model.NoticeB;
import dev.xesam.android.push.kit.model.NoticeC;
import dev.xesam.chelaile.push.spi.AbsSourcePushReceiver;

/**
 * Created by xesamguo@gmail.com on 17-4-17.
 */

public class SourcePushReceiverImpl extends AbsSourcePushReceiver {

    public static final String TAG = "SourcePushReceiverImpl";

    @Override
    public boolean checkPushRaw(Context context, SourcePushRaw data) {
        return true;
    }

    @Override
    public void onReceive(Context context, SourcePushRaw raw) {
        if (raw.getType() == SourcePushRaw.TYPE_TOKEN) {
            onReceiveToken(context, (SourcePushToken) raw);
        } else if (raw.getType() == SourcePushRaw.TYPE_MSG) {
            onReceiveMsg(context, (SourcePushMsg) raw);
        }
    }

    private void onReceiveToken(Context context, SourcePushToken token) {
        Log.w(TAG, token.getToken());
        Toast.makeText(context, "SourcePushToken = " + token.getToken(), Toast.LENGTH_SHORT).show();
    }

    private void onReceiveMsg(Context context, SourcePushMsg msg) {
        Log.w(TAG, msg.getRawPayload());
        String customPayload = msg.getCustomPayload();
        Gson gson = new GsonBuilder().registerTypeAdapter(AppPushMsg.class, new JsonDeserializer<AppPushMsg>() {

            @Override
            public AppPushMsg deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                final JsonObject jsonObject = json.getAsJsonObject();

                final JsonElement jsonType = jsonObject.get("type");
                final String type = jsonType.getAsString();

                if (type.equals("a")) {
                    JsonElement jsonName = jsonObject.get("name");
                    String name = jsonName.getAsString();
                    NoticeA notice = new NoticeA();
                    notice.setName(name);
                } else if (type.equals("b")) {
                    JsonElement jsonName = jsonObject.get("name");
                    String name = jsonName.getAsString();
                    NoticeB notice = new NoticeB();
                    notice.setName(name);
                } else if (type.equals("c")) {
                    JsonElement jsonName = jsonObject.get("name");
                    String name = jsonName.getAsString();
                    NoticeC notice = new NoticeC();
                    notice.setName(name);
                }
                return null;
            }
        }).create();
        AppPushMsg appMsg = gson.fromJson(customPayload, AppPushMsg.class);
        CoreAppPushReceiver.broadcastAppPushMsg(context, DemoConstant.APP_RECEIVER_ACTION, appMsg);
    }
}
