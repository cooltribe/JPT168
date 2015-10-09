package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/15.
 * email:361786231@qq.com
 */
public class GetFareRuleTask extends JPTTask{

    private String bufferKey;
    private String flightId;
    private int userId;

    public GetFareRuleTask(Context context, String bufferKey, String flightId, int userId) {
        super(context);
        this.bufferKey = bufferKey;
        this.flightId = flightId;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String fareRuleStr = BaseProtocal.getFareRule(bufferKey,flightId,userId);
        return JSON.parseObject(fareRuleStr, OrderQuery.class);
    }
}
