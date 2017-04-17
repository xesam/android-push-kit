package dev.xesam.android.push.kit.api;

import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * 通知栏动作分发器
 * Created by xe on 16-11-5.
 */

public class CoreNotificationDispatcher {

    public static final int ACTION_CLICK = 0;
    public static final int ACTION_DISMISS = 1;
    private static final String EXTRA_ACTION_NOTIFY_ACTION = "dev.xesam.push.notify_action";

    public static void setActionCode(@NonNull Intent data, int action) {
        data.putExtra(EXTRA_ACTION_NOTIFY_ACTION, action);
    }

    public static int getActionCode(@NonNull Intent data) {
        return data.getIntExtra(EXTRA_ACTION_NOTIFY_ACTION, ACTION_CLICK);
    }
}
