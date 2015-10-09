package com.jpt168.task;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.jpt168.model.OrderQuery;
import com.jpt168.protocal.BaseProtocal;

/**
 * Created by caomingyu on 15/9/15.
 * email:361786231@qq.com
 */
public class GetPayVerifyTask extends JPTTask {

    private String orderId;
    private String payType;
    private int userId;

    public GetPayVerifyTask(Context context, String orderId, String payType, int userId) {
        super(context);
        this.orderId = orderId;
        this.payType = payType;
        this.userId = userId;
    }

    @Override
    protected Object onTaskLoading() throws Exception {
        String payVerifyStr = BaseProtocal.getPayVerify(orderId,payType,userId);
        return JSON.parseObject(payVerifyStr, OrderQuery.class);
    }
}
