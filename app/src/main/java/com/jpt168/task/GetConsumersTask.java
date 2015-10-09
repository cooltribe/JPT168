package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/16.
 * email:361786231@qq.com
 */
public class GetConsumersTask extends JPTTask{

    private int userId;


    public GetConsumersTask(Context context, int userId) {
        super(context);
        this.userId = userId;
    }

    @Override

    protected Object onTaskLoading() throws Exception {
        String consumerStr = BaseProtocal.getConsumers(userId);
        return JSON.parseObject(consumerStr, OrderQuery.class);
    }
}
