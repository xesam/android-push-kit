package dev.xesam.android.push.kit;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by xesamguo@gmail.com on 17-6-22.
 */

public class DemoApp extends Application {

    public static DemoApp _this;

    public static DemoApp getThis() {
        return _this;
    }

    private int count = 0;

    private ActivityLifecycleCallbacks mActivityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            count++;
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            count--;
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        _this = this;
        registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        unregisterActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
    }

    public boolean hasRunningActivity() {
        return count > 0;
    }
}
