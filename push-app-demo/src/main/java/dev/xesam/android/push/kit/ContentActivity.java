package dev.xesam.android.push.kit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import dev.xesam.android.push.kit.push.AppPushReceiverImpl;

public class ContentActivity extends AppCompatActivity {

    public static final String TAG = "ContentActivity";

    private AppPushReceiverImpl appPushReceiver = new AppPushReceiverImpl() {
        @Override
        protected boolean onHandleReceive(Context context, Intent intent) {
            Log.d(TAG, "onHandleReceive");
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        appPushReceiver.register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        appPushReceiver.unregister(this);
    }
}
