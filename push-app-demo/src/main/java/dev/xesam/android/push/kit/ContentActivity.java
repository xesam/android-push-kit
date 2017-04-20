package dev.xesam.android.push.kit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import dev.xesam.android.push.kit.api.CoreAppPushReceiver;
import dev.xesam.android.push.kit.push.AppPushReceiverImpl;

public class ContentActivity extends AppCompatActivity {

    public final String TAG = "ContentActivity";

    private TextView vContent;

    private AppPushReceiverImpl appPushReceiver = new AppPushReceiverImpl() {
        @Override
        protected boolean onHandleReceive(Context context, Intent intent) {
            Log.d(TAG, "onHandleReceive");
            Parcelable data = CoreAppPushReceiver.getAppPushMsg(intent);
            vContent.setText(data.toString());
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
