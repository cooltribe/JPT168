package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.Frequent;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/12.
 * email:361786231@qq.com
 */
public class GetFrequentQueryTask extends JPTTask {

    private int passengerId;
    private String passengerName;
    private int passengerType;
    private int pageSize;
    private int pageIndex;
    private int userId;

    public GetFrequentQueryTask(Context context, int passengerId, String passengerName, int passengerType, int pageSize, int pageIndex, int userId) {
        super(context);
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerType = passengerType;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String frequentQueryStr = BaseProtocal.getFrequentQuery(passengerId,passengerName,passengerType,pageSize,pageIndex,userId);
        return JSON.parseObject(frequentQueryStr, Frequent.class);
    }
}
