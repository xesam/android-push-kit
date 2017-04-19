package com.github.xesam.push_app_mock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import dev.xesam.android.push.kit.api.PushHelper;
import dev.xesam.android.push.kit.api.PushRaw;
import dev.xesam.android.push.kit.api.PushToken;
import dev.xesam.android.push.kit.api.SimplePushMsg;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.send_token).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PushRaw pushRaw = new PushToken("a-mock-token");
                PushHelper.broadcastSdk(getApplicationContext(), pushRaw);
            }
        });

        findViewById(R.id.send_notice_a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PushRaw pushRaw = new SimplePushMsg("{\"type\":\"a\",\"name\":\"noticeA\"}");
                PushHelper.broadcastSdk(getApplicationContext(), pushRaw);
            }
        });

        findViewById(R.id.send_notice_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PushRaw pushRaw = new SimplePushMsg("{\"type\":\"b\",\"name\":\"noticeB\"}");
                PushHelper.broadcastSdk(getApplicationContext(), pushRaw);
            }
        });

        findViewById(R.id.send_notice_c).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PushRaw pushRaw = new SimplePushMsg("{\"type\":\"c\",\"name\":\"noticeC\"}");
                PushHelper.broadcastSdk(getApplicationContext(), pushRaw);
            }
        });
    }
}
