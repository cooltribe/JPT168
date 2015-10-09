package com.jpt168.task;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.Country;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by honeyshare-B on 15/9/12.
 * email:657523985@qq.com
 */
public class GetCountryTask extends JPTTask {

    public GetCountryTask(Context context) {
        super(context);
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String countryStr = BaseProtocal.getCountry();
        Log.i("testAPI","countryStr" + countryStr);
        return JSON.parseObject(countryStr, Country.class);
    }
}
