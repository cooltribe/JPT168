package com.jpt168.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by caomingyu on 15/9/8.
 * email:361786231@qq.com
 */
public class Util {
    private static final String TAG = "Util";
    public static String partLongDateTOString(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date _date = new Date(time);
        return  sdf.format(_date);

    }
    public static void setUserToSharedPrefrences(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        Editor editor = sharedPreferences.edit();
        editor.putString("","");
        editor.commit();
    }

    public static int getUserIdFromSharedPrefrences(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        return sharedPreferences.getInt("userId",-1);
    }

}
