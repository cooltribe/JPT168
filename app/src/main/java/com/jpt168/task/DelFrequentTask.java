package com.jpt168.task;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.Frequent;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/13.
 * email:361786231@qq.com
 */
public class DelFrequentTask extends JPTTask {

    private int passengerId;
    private int userId;

    public DelFrequentTask(Context context, int passengerId, int userId) {
        super(context);
        this.passengerId = passengerId;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String frequentDelStr = BaseProtocal.getFrequentDel(passengerId,userId);
        Log.i("testAPI",frequentDelStr);
        return JSON.parseObject(frequentDelStr, Frequent.class);
    }
}
