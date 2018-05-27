package com.example.veeotech.cwy.Utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CWY on 2018/5/15.
 */


public class ActivityUtil {
    private List<Activity> AllActivitites = new ArrayList<Activity>();
    private static ActivityUtil instance;

    public ActivityUtil() {

    }

    public synchronized static ActivityUtil getInstance() {
        if (null == instance) {
            instance = new ActivityUtil();
        }
        return instance;
    }

    //在Activity基类的onCreate()方法中执行
    public void addActivity(Activity activity) {
        AllActivitites.add(activity);
    }

    //注销是销毁所有的Activity
    public void OutSign() {
        for (Activity activity : AllActivitites) {
            if (activity != null) {
                activity.finish();
            }
        }
    }
}
