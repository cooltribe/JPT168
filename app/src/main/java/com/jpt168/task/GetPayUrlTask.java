package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/15.
 * email:361786231@qq.com
 */
public class GetPayUrlTask extends JPTTask{

    private String orderId;
    private String PayType;
    private int userId;

    public GetPayUrlTask(Context context, String orderId, String payType, int userId) {
        super(context);
        this.orderId = orderId;
        this.PayType = payType;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String payUrlStr = BaseProtocal.getPayUrl(orderId,PayType,userId);
        return JSON.parseObject(payUrlStr, OrderQuery.class);
    }
}
