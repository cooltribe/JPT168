package com.jpt168.application;

import android.util.Log;
/**
 * Created by caomingyu on 15/9/5.
 * email:361786231@qq.com
 */
public class LogManager {
    private static final String TAG = "TEST";
    public static void i(String msg){
        if(Constants.debug){
            Log.i(TAG,msg);
        }
    }
    public static void d(String msg){
        if(Constants.debug){
            Log.d(TAG,msg);
        }
    }
    public static void e(String msg){
        if(Constants.debug){
            Log.e(TAG,msg);
        }
    }

    public static void i(String tag, String msg){
        if(Constants.debug){
            Log.i(tag,msg);
        }
    }
    public static void d(String tag, String msg){
        if(Constants.debug){
            Log.d(tag,msg);
        }
    }
    public static void e(String tag, String msg){
        if(Constants.debug){
            Log.e(tag,msg);
        }
    }
}
