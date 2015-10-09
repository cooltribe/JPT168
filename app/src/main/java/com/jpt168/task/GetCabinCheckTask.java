package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/15.
 * email:361786231@qq.com
 */
public class GetCabinCheckTask extends  JPTTask{

    private String bufferKey;
    private String flightId;
    private int passNumber;
    private int userId;

    public GetCabinCheckTask(Context context, String bufferKey, String flightId, int passNumber, int userId) {
        super(context);
        this.bufferKey = bufferKey;
        this.flightId = flightId;
        this.passNumber = passNumber;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String cabinCheckStr = BaseProtocal.getCabinCheck(bufferKey,flightId,passNumber,userId);
        return JSON.parseObject(cabinCheckStr, OrderQuery.class);
    }
}
