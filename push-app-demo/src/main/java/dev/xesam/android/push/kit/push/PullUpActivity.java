package dev.xesam.android.push.kit.push;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by xesamguo@gmail.com on 17-6-19.
 */

public class PullUpActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "pull up", Toast.LENGTH_SHORT).show();
        finish();
    }
}
