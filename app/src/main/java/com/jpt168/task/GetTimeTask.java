package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.application.LogManager;
import com.jpt168.model.Time;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/12.
 * email:361786231@qq.com
 */
public class GetTimeTask extends JPTTask {


    public GetTimeTask(Context context) {
        super(context);
    }

    @Override

    protected Object onTaskLoading() throws Exception {
        String timeStr = BaseProtocal.getTime();
        LogManager.i("testTimeApi","timeStr-->" + timeStr);
        return JSON.parseObject(timeStr,Time.class);
    }
}
