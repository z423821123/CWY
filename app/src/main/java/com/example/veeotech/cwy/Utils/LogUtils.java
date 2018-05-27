package com.example.veeotech.cwy.Utils;

import android.util.Log;

/**
 * Created by VeeoTech on 2018/5/17.
 */

public class LogUtils {

    public static final String LOG_TAG = "CWY";

    public static void showLogVerbose(String msg){
        Log.v(LOG_TAG,""+msg);
    }

    public static void showLogDebug(String msg){
        Log.d(LOG_TAG,""+msg);
    }
    public static void showLogInformation(String msg){
        Log.i(LOG_TAG,""+msg);
    }
    public static void showLogWarning(String msg){
        Log.w(LOG_TAG,""+msg);
    }
    public static void showLogError(String msg){
        Log.e(LOG_TAG,""+msg);
    }
}
