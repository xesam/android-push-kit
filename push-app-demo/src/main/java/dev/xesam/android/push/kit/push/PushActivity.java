package dev.xesam.android.push.kit.push;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import dev.xesam.android.push.kit.NaviHelper;
import dev.xesam.android.push.kit.api.CorePushActivity;

/**
 * Created by xesamguo@gmail.com on 17-6-19.
 */

public class PushActivity extends CorePushActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "pull up", Toast.LENGTH_SHORT).show();
        new NaviHelper().start(this);
        finish();
    }
}
