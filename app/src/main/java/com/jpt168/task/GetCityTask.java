package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.application.LogManager;
import com.jpt168.model.City;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by honeyshare-B on 15/9/12.
 * email:657523985@qq.com
 */
public class GetCityTask extends JPTTask {


    public GetCityTask(Context context) {
        super(context);
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String cityStr = BaseProtocal.getCity();
        LogManager.i("testCityApi","cityStr-->" + cityStr);
        return JSON.parseObject(cityStr,City.class);
    }
}
