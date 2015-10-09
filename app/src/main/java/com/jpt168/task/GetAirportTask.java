package com.jpt168.task;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.Airport;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/12.
 * email:361786231@qq.com
 */
public class GetAirportTask extends JPTTask{

    public GetAirportTask(Context context) {
        super(context);
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String airportStr = BaseProtocal.getAirport();
        Log.i("testAirportAPi","airportStr-->" + airportStr);
        return JSON.parseObject(airportStr, Airport.class);
    }
}
