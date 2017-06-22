package dev.xesam.android.push.kit;

import android.app.Activity;
import android.content.Intent;

import dev.xesam.android.push.kit.api.AppPushMsg;

/**
 * Created by xesamguo@gmail.com on 17-6-22.
 */

public class NaviHelper {

    private static final String INTENT_NAVI = "navi";

    public static void putNaviData(Intent intent, AppPushMsg appPushMsg) {
        intent.putExtra(INTENT_NAVI, appPushMsg);
    }

    public static AppPushMsg getNaviData(Intent intent) {
        return intent.getParcelableExtra(INTENT_NAVI);
    }

    public void start(Activity activity) {
        AppPushMsg msg = getNaviData(activity.getIntent());
        if (msg != null) {
            Intent intent = new Intent(activity, ContentActivity.class);
            NaviHelper.putNaviData(intent, msg);
            activity.startActivity(intent);
        }
    }
}
