package com.yangzhiyan.mycctv;

import android.app.Application;

import org.xutils.x;

/**
 * Created by YZY on 2016/11/8.
 */

public class CCTVApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
