package dev.xesam.android.push.kit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import dev.xesam.android.push.kit.api.AppPushMsg;
import dev.xesam.android.push.kit.api.CoreAppPushReceiver;
import dev.xesam.android.push.kit.model.BizType;
import dev.xesam.android.push.kit.push.AppPushReceiverImpl;

public class ContentActivity extends AppCompatActivity {

    public final String TAG = "ContentActivity";

    private TextView vContent;

    private AppPushReceiverImpl appPushReceiver = new AppPushReceiverImpl() {
        @Override
        protected boolean onHandleReceive(Context context, Intent intent) {
            Log.w(TAG, "onHandleReceive");
            AppPushMsg data = CoreAppPushReceiver.getAppPushMsg(intent);
            Log.w(TAG, data.toString());
            if (data.getType() == BizType.TYPE_A) {
                vContent.setText("TYPE_A:" + data.toString());
                return true;
            } else if (data.getType() == BizType.TYPE_B) {
                vContent.setText("TYPE_B:" + data.toString());
                return true;
            } else if (data.getType() == BizType.TYPE_C) {
                vContent.setText("TYPE_C:" + data.toString());
                return true;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        vContent = (TextView) findViewById(R.id.content);
        appPushReceiver.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appPushReceiver.unregister(this);
    }
}
