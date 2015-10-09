package com.jpt168.task;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.Airline;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/12.
 * email:361786231@qq.com
 */
public class GetAirlineTask extends  JPTTask {

    public GetAirlineTask(Context context) {
        super(context);
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String airlineStr = BaseProtocal.getAirline();
        Log.i("testAirline","airlineStr-->" + airlineStr);
        return JSON.parseObject(airlineStr, Airline.class);
    }
}
