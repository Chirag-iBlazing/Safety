package com.devstree.safety;

import android.app.Application;

/**
 * Created by Dhara on 29-09-2018.
 */

public class SafetyApplication extends Application {

    private static SafetyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

    }

}
